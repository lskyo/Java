package com.lskyo.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	
	@Autowired
	private BookShopDao bookShopDao;
	
	//添加事务注解
	//1. 使用 propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
	//如何使用事务，默认取值为 REQUIRED，即调用方法的事务
	//REQUIRED_NEW：使用自己的事务，调用的事务方法的事务被挂起
	//2. 使用 isolation 指定事务的隔离级别，最常用的取值为 READ_COMMITTED
	//3. 默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置，通常情况下使用默认值即可
	//4. 使用 readOnly 指定事务是否为只读，表示这个事务只读取数据库数据但不更新数据库，
	//这样可以帮助数据库引擎优化事务。
	//5. 使用 timeout 指定强制回滚之前的事务可以占用的时间，单位秒。
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,
			//noRollbackFor={UserAccountException.class}
			readOnly=false,
			timeout=3
	)
	@Override
	public void purchase(String username, String isbn) {
		//1. 获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2. 更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//3. 更新用户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
