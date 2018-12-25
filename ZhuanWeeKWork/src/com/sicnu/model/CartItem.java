package com.sicnu.model;

import java.io.Serializable;

//购物车模型  
//购物车  里面有书本对象，购买数量
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private BookModel book;
	private int quantity;

	
	public BookModel getBook() {
		return book;
	}
	public void setBook(BookModel book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
