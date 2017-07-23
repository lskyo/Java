package com.lskyo.spring.tx.xml;

public interface BookShopDao {

	public int findBookPriceByIsbn(String isbn);
	public void updateBookStock(String isbn);
	public void updateUserAccount(String username, int price);
	
}
