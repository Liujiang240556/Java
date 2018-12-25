package com.sicnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sicnu.dao.BookDao;
import com.sicnu.model.BookModel;

public class AdminServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//转换编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//设置内容类型
		response.setContentType("text/html;charset=UTF-8");
		//创建out对象
		PrintWriter out=response.getWriter();
		//获取action的值
		String action=request.getParameter("action");		
		if("insert".equals(action)){			
			insert(request, response);			
		}else if("deletebook".equals(action)){
			deletebook(request, response);
		}else if("updatebook".equals(action)){
			updatebook(request,response);
		}
		else{
			out.print("<script>alert('非法操作！');location.href='login.jsp'</script>");
			return;
		}	
	
		
	}

	private void updatebook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_price=request.getParameter("book_price");
		String book_des=request.getParameter("book_des");
		String book_img=request.getParameter("book_img");
		String book_id=request.getParameter("book_id");
		PrintWriter out=response.getWriter();
		
		BookModel bm=new BookModel();
		bm.setName(book_name);
		bm.setDescripte(book_des);
		bm.setAuthor(book_author);
		bm.setPrice(Double.valueOf(book_price));
		bm.setImage(book_img);
		bm.setId(book_id);
		BookDao bd=new BookDao();
		if(bd.updataBook(bm)){
			out.print("<script>alert('修改成功');location.href='admin.jsp'</script>");
		}else{
			out.print("<script>alert('修改失败');history.go(-1)</script>");
		}
	}

	private void deletebook(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String book_id=request.getParameter("id");
		BookDao bd=new BookDao();
		if(bd.delbook(Integer.valueOf(book_id))){
			out.print("<script>alert('删除成功');location.href='admin.jsp'</script>");
		}else{
			out.print("<script>alert('删除失败');history.go(-1)</script>");
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_price=request.getParameter("book_price");
		String book_des=request.getParameter("book_des");
		String book_img=request.getParameter("book_img");
		
		BookModel bm=new BookModel();
		bm.setName(book_name);
		bm.setDescripte(book_des);
		bm.setAuthor(book_author);
		bm.setPrice(Double.valueOf(book_price));
		bm.setImage(book_img);
		BookDao bd=new BookDao();
		if(bd.insertbook(bm)){
			out.print("<script>alert('增加成功');location.href='admin.jsp'</script>");
			
		}else{
			out.print("<script>alert('增加失败');location.href='history.go(-1)'</script>");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
