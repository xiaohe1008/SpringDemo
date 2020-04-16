<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="hello">访问springmvc的第一个案例</a>
	
	 <form action="login" method="post">
	         用户名： <input name="userName" type="text" />
	         邮    箱： <input name="email" type="text" />
	         密    码： <input name="psw" type="text" />
	         年    龄：  <input name="age" type="text" />
	         性    别：  <input name="sex" type="text" />
	         电    话：  <input name="tel" type="text" />
	        状     态：  <input name="statusDesc" type="text" />  
	          地   址：  <input name="address" type="text" />
	             <input type="submit"/>
    </form>
	
	
	
	
	
	
	<hr/>
	<!--    实现基本数据类型表单的绑定 -->
	<form action="saveUser" method="post">
	   昵称：<input type="text" name="username" /> <br>
	  密码：<input type="password" name="password" /><br>
	 年龄：<input type="text" name="age" /><br>
	 省份：<input type="text" name="address.provincveName" /><br>
	 城市：<input type="text" name="address.cityName" /><br>
	 <input type="submit" value="提交">
	</form>
	<hr />
         <!-- 实现list表单绑定 -->
	<form action="updateAccount" method="post">
		   昵称：<input type="text" name="username" /> <br>
		  密码：<input type="password" name="password" /><br>
		 年龄：<input type="text" name="age" /><br>
		 省份：<input type="text" name="address.provincveName" /><br>
		 城市：<input type="text" name="address.cityName" /><br>
		账户1名称：<input type="text" name="accountList[0].accountName" /><br>
		 账户1金额：<input type="text" name="accountList[0].money" /><br>
		 账户2名称：<input type="text" name="accountList[1].accountName" /><br>
		 账户2金额：<input type="text" name="accountList[1].money" /><br>
		<input type="submit" value="提交">
	</form>
	<hr />
	<!-- 通过ModelAttributr进行用户信息修改 -->
	<form action="updateUser" method="post">
	<!-- 	userId:<input type="text" name="userid"/><br/> -->
		userName:<input type="text" name="userName"/><br/>
	    password:<input type="password" name="password"/><br/>
		<input type="submit" value="提交"/>
	</form>
	<hr />
	
	<form action="delete/deleteByDate" method="get">
		日期：<input type="text" name="date"/>
	<input type="submit" value="提交">
	
	</form>
	 
	
	
</body>
</html>