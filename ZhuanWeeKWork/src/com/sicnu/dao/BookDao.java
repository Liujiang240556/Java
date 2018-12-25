package com.sicnu.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sicnu.model.BookModel;
import com.sicnu.util.DB;

public class BookDao {
	public DB mydb = new DB();

	public ArrayList<BookModel> findAllBooks() {
		ArrayList<BookModel> books = new ArrayList<BookModel>();
		try {
			mydb.openDB();
			String sql = "select * from book_category";
			Object[] params = {};
			ResultSet rs = mydb.executeQuery(sql, params);
			while (rs.next()) {
				BookModel bm = new BookModel();
				bm.setId(rs.getString("id"));
				bm.setName(rs.getString("name"));
				bm.setPrice(rs.getDouble("price"));
				bm.setAuthor(rs.getString("author"));
				bm.setDescripte(rs.getString("description"));
				bm.setImage(rs.getString("image"));
				bm.setType(rs.getString("type"));
				bm.setCategory_description(rs.getString("category_description"));
				books.add(bm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mydb.close();
		}
		return books;
	}

	public BookModel findByID(int id) {
		try {
			mydb.openDB();
			String sql = "select * from book where id=?";
			Object[] params = { id };
			ResultSet rs = mydb.executeQuery(sql, params);
			while (rs.next()) {
				BookModel bm = new BookModel();
				bm.setId(rs.getString("id"));
				bm.setName(rs.getString("name"));
				bm.setPrice(rs.getDouble("price"));
				bm.setAuthor(rs.getString("author"));
				bm.setDescripte(rs.getString("description"));
				bm.setImage(rs.getString("image"));
				return bm;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mydb.close();
		}
		return null;
	}

	public boolean insertbook(BookModel bm) {
		boolean count = false;
		try {
			mydb.openDB();
			String sql = "insert into book(name,author,price,image,description)  values (?,?,?,?,?)";
			Object[] params = { bm.getName(), bm.getAuthor(), bm.getPrice(),
					bm.getImage(), bm.getDescripte() };
			count = mydb.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mydb.close();
		}
		return count;
	}

	public boolean delbook(int id) {
		boolean count = false;
		try {
			mydb.openDB();
			String sql = "delete from book  where id=?";
			Object[] params = { id };
			count = mydb.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mydb.close();
		}
		return count;
	}

	public boolean updataBook(BookModel bm) {

		boolean count = false;
		try {
			mydb.openDB();
			String sql = "update  book set  name=?,author=?,price=?,image=?,description=?  where id=?";
			Object[] params = { bm.getName(), bm.getAuthor(), bm.getPrice(),
					bm.getImage(), bm.getDescripte(),bm.getId() };
			count = mydb.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mydb.close();
		}
		return count;
	}
}
