<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>     
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">部门管理</td>
		</tr>
		<tr>
			<td align="right">
			    <a href="department_saveUI.action">添加</a>
			</td>
		</tr>
	</table>
	<br/>
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th width="300">部门名称</th>
				<th width="300">编辑</th>
				<th width="300">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="d">
				<tr>
					<td align="center"><s:property value="#d.dname" /></td>
					<td align="center">
					   <a href="department_editById.action?did=<s:property value="#d.did"/>">
					      编辑
					   </a>
					</td>
					<td align="center">
					    <a href="department_delete.action?did=<s:property value="#d.did"/>">
					       <img src="<%=basePath %>images/trash.gif" />
					    </a>
				    </td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br/>
	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right">
			<span>
			     第<s:property value="currentPage" />/<s:property value="pageSize" />页
			</span>
			&nbsp;&nbsp; 
			<span>
			    总记录数：<s:property value="totalSize" />&nbsp;&nbsp;
			    每页显示:<s:property value="pageCount" /></span>&nbsp;&nbsp; 
			<span>
			   <s:if test="currentPage != 1">
					<a href="department_findAll.action?currentPage=1">[首页]</a>&nbsp;&nbsp;
                    <a href="department_findAll.action?currentPage=<s:property value="currentPage-1"/>">[上一页]</a>&nbsp;&nbsp;
               </s:if> 
               <s:if test="currentPage != pageSize">
					<a href="department_findAll.action?currentPage=<s:property value="currentPage+1"/>">[下一页]</a>&nbsp;&nbsp;
                    <a href="department_findAll.action?currentPage=<s:property value="pageSize"/>">[尾页]</a>&nbsp;&nbsp;
               </s:if> 
            </span>
            </td>
		</tr>
	</table>
</body>
</html>