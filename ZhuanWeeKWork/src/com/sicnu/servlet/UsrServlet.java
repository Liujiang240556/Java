package com.sicnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sicnu.dao.UserDao;
import com.sicnu.model.UserModel;


public class UsrServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UsrServlet() {
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
		if("login".equals(action)){			
			login(request, response);			
		}else if("logout".equals(action)){
			logout(request, response);
		}else if("register".equals(action)){
			register(request,response);
		}
		else{
			out.print("<script>alert('非法操作！');location.href='login.jsp'</script>");
			return;
		}	
	}

	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				//获取数据
				String name=request.getParameter("userName");
				String password=request.getParameter("password");
				String type=request.getParameter("u_type");
				String rnd=request.getParameter("rnd");
				//判断验证码
				HttpSession session=request.getSession();
				String random=(String)session.getAttribute("random");
				if(!rnd.equals(random)){
					out.println("<script>alert('验证码输入错误，请重新输入！');history.go(-1);</script>");
					return;
				}

				
				UserDao ud=new UserDao();
				if(ud.login(name, password,type)){
					//将用户名放入session中
					session.setAttribute("u_name", name);
					if(type.equals("0")){
				out.println("<script>alert('用户登录成功');location.href='index.jsp';</script>");
					}else if(type.equals("1")){
					out.println("<script>alert('管理员登录成功');location.href='admin.jsp';</script>");
					}
				}else{
					out.println("<script>alert('登录失败');location.href='login.jsp';</script>");
					
				}
			}
			public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				HttpSession session=request.getSession();
				session.invalidate();
				PrintWriter out = response.getWriter();
				out.println("<script>alert('退出登录！');location.href='login.jsp';</script>");
				
			}
			
			public void register(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				//获取数据
				String username_register=request.getParameter("username_register");
				String register_mima=request.getParameter("register_mima");
				String tel=request.getParameter("tel");
				String email=request.getParameter("email");
				String adress=request.getParameter("address");
				
				UserModel um=new UserModel();
				um.setEmail(email);
				um.setName(username_register);
				um.setTel(tel);
				um.setPwd(register_mima);
				um.setAdress(adress);
				
				
				UserDao registerDao=new UserDao();
				if(registerDao.register(um)){
					out.println("<script>alert('用户注册成功');location.href='login.jsp';</script>");
				}else{
					out.println("<script>alert('用户注册失败');history.go(-1);</script>");
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
