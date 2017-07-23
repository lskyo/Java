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
	
	//�������ע��
	//1. ʹ�� propagation ָ������Ĵ�����Ϊ������ǰ�����񷽷�������һ�����񷽷�����ʱ
	//���ʹ������Ĭ��ȡֵΪ REQUIRED�������÷���������
	//REQUIRED_NEW��ʹ���Լ������񣬵��õ����񷽷������񱻹���
	//2. ʹ�� isolation ָ������ĸ��뼶����õ�ȡֵΪ READ_COMMITTED
	//3. Ĭ������� Spring ������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ�����Խ������ã�ͨ�������ʹ��Ĭ��ֵ����
	//4. ʹ�� readOnly ָ�������Ƿ�Ϊֻ������ʾ�������ֻ��ȡ���ݿ����ݵ����������ݿ⣬
	//�������԰������ݿ������Ż�����
	//5. ʹ�� timeout ָ��ǿ�ƻع�֮ǰ���������ռ�õ�ʱ�䣬��λ�롣
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,
			//noRollbackFor={UserAccountException.class}
			readOnly=false,
			timeout=3
	)
	@Override
	public void purchase(String username, String isbn) {
		//1. ��ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2. ������Ŀ��
		bookShopDao.updateBookStock(isbn);
		
		//3. �����û����
		bookShopDao.updateUserAccount(username, price);
	}

}
