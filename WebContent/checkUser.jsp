<%@ page language="java" import="java.util.*" pageEncoding="GB18030" %>
  <%@ page import="java.sql.*" %>

<%	Connection conn =null;
  	Statement prepStmt = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssh", "root", "");
		/* out.print("connection ok"); */
		String a = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
		String sql = "select * from employee where username='" + a + "'";
		prepStmt = conn.createStatement();
		ResultSet rs = prepStmt.executeQuery(sql);
		if(rs.next()){
			out.print("�ܱ�Ǹ�����û��ѱ�ע�ᣡ");
		}else{
			out.print("��ϲ�������û�δ��ע�ᣡ");
		}
 	}catch(ClassNotFoundException e){
 		e.printStackTrace();
 	}catch(SQLException e){
 		e.printStackTrace();
 	}finally{
 		try{
 			if(prepStmt != null){
 				prepStmt.close();
 				prepStmt = null;
 			}
 			if(conn != null){
 				conn.close();
 				conn = null;
 			}
 		}catch(SQLException ex){
 			ex.printStackTrace();
 		}
 	}
%>