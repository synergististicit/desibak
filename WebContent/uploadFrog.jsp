<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Frog</title>
  <style type="text/css">
  
  table { 
    border-spacing: 25px;
    border-collapse: separate;
}
#footer{
    position:fixed;
    height:25px;
    background-color:yellow;
    bottom:0px;
    left:0px;
    right:0px;
    margin-bottom:0px;
}
  </style>
</head>
<body>
	<header style="background-color: pink;height: 30px;">
	   <b>Frog Store!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</b>
	</header>
	   <img src="img/6.jpg" height="80px;"/> 		
	 	<hr/>
	 	 	 <span style="color:blue;font-weight: bold;font-size: 14px;">
	 	 	Hey!   ${sessionScope.uname} welcome and you have logged in at  ${sessionScope.lastLoginTime}
	 	 </span>
	 	 <br/> <br/>
	 	<span style="color:red;font-weight: bold;font-size: 14px;">${message}</span>
	 	 <form action="uploadFrog" method="POST">
	 	  <table>
	 	  			<tr>
	 	  					<td>Name: </td>
	 	  					<td><input type="text"  name="name" style="height: 24px;width: 300px;"></td>
	 	  			</tr>
	 	  
	 	  			<tr>
	 	  					<td>Color:</td>
	 	  					<td>
	 	  					<select   name="color" style="height: 28px;width: 200px;background-color:pink;">
	 	  							<option>Red</option>
	 	  							<option>Yellow</option>
	 	  							<option>Blue</option>
	 	  							<option>Green</option>
	 	  							<option>Voilet</option>
	 	  							<option>Pink</option>
	 	  					</select>
	 	  					</td>
	 	  			</tr>
	 	  			
	 	  				<tr>
	 	  					<td>Price:</td>
	 	  					<td>
	 	  					<select   name="price" style="height: 28px;width: 100px;">
	 	  							<option>10</option>
	 	  							<option>30</option>
	 	  							<option>40</option>
	 	  							<option>50</option>
	 	  							<option>60</option>
	 	  							<option>70</option>
	 	  					</select>
	 	  					</td>
	 	  			</tr>
	 	  				<tr>
	 	  					<td>Email</td>
	 	  					<td><input type="text"  name="email"  style="width: 400px;height: 26px;background-color: pink;"/></td>
	 	  			</tr>
	 	  				<tr>
	 	  					<td></td>
	 	  					<td><input type="submit"  value="Upload"  style="background-color: yellow;height: 28px;"/> </td>
	 	  			</tr>
	 	  </table>
	 	  <a href="showFrogs"><img src="img/all.png"/>Show All</a>
	 	</form>
	 	
		<footer id="footer">
	   <b>@Copyright 2017!</b>
	</footer>

</body>
</html>