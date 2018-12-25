package com.sicnu.dao;

import java.sql.ResultSet;



import com.sicnu.model.UserModel;
import com.sicnu.util.DB;
import com.sicnu.util.MD5_Encoding;



public class UserDao {
	private DB mydb=new DB();
	//登录
	  public boolean login(String name,String pwd,String type){
		  boolean flag=false;
		  MD5_Encoding md5=new MD5_Encoding();
		  try{
				mydb.openDB();
				String sql="select * from user where username=? and password=?  ";
				String u_password=md5.getMD5ofStr(pwd);
				Object[] params={name,u_password};
				ResultSet rs=mydb.executeQuery(sql, params);
				flag=rs.next();
				if(flag==false){
					return false;
				}else{
					flag=true;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				mydb.close();
			}
		  return flag;
	  }
	  
	  //注册
	  public boolean register(UserModel us){
		  boolean success=false;
			MD5_Encoding md5=new MD5_Encoding();
			
		  try{
			
				mydb.openDB();
				String sql="insert into user (username,password,phone,email,address) VALUES (?, ?,?,?,?)";
				String u_password=md5.getMD5ofStr(us.getPwd());
				Object[] params={us.getName(),u_password,us.getTel(),us.getEmail(),us.getAdress()};
				
				success=mydb.executeUpdate(sql, params);
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				mydb.close();
			}
		  return success;
	  }
		  

}
