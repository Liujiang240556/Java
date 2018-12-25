package com.sicnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sicnu.dao.BookDao;
import com.sicnu.model.BookModel;
import com.sicnu.model.CartItem;

public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
			 {
		 PrintWriter out=response.getWriter(); 
		String book_id=request.getParameter("id");
	
		 response.setContentType("text/html;charset=utf-8");
		  
		   HttpSession session =request.getSession();
		   request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("utf-8");

	    //购物车功能
	     //1:首先考虑我购买的是哪一本书籍，这里可以使用id确认
		   BookDao bd=new BookDao();
	       BookModel book=bd.findByID(Integer.valueOf(book_id));
	       book.setId(book_id);
	
	    //2:考虑如何把书籍放到购物车中
	        //2.1:首先考虑是否有购物车，如果没有，则创建，如果有直接使用
	       //2.2:其次先将购物车从session中拿出来，不存在就创建。
	    @SuppressWarnings("unchecked")
		Map<Integer,CartItem> cart=(Map<Integer,CartItem>)session.getAttribute("cart");
	    //如果没有购物车，那么创建，只有第一次访问才会操作
	    if(cart==null){
	         //new一个购物车
	        cart=new HashMap<Integer,CartItem>();
	    }
		  
	     //3:考虑如何把书籍放到购物车中
	        //3.1:第一考虑购物车中是否有该书籍，所以先从购物车中获取该书籍，如果为空，那么没有该书籍  
	    //我出错在了这里，一定要把String类型的转换成int类型
	     CartItem item=(CartItem)cart.get(Integer.valueOf(book.getId()));
	     if(item==null){
	        //如果购物车中不存在该书籍，那么创建，且数量默认为1
	        item=new CartItem();
	        //将书籍放到购物车中
	       item.setBook(book);
	        //将书籍的默认数量为1
	        item.setQuantity(1);
	    	
	    }else{
	         //如果购物车中已经有该书籍，那么数量加1 
	         item.setQuantity(item.getQuantity()+1);
	    }
	    
	    //4:考虑如何把购物车项(即挑选的书籍是哪一个和书本的数量)放到购物车中
	   cart.put(Integer.valueOf(book.getId()),item);

	   //5:将购物车放到session中，方便后面取出来
	   session.setAttribute("cart", cart);
	   out.print("<script>alert('添加成功');location.href='index.jsp'</script>");
	 
	   
	 
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

		doGet(request,response);
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
