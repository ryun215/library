<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="#">4조 도서관</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	       	<li><a href="/book/bookInsert">도서관리</a></li>
	        <li><a href="/member/memberInsert">회원관리</a></li>
	        <li><a href="/rental/rentalInsert">대여관리</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container-fluid text-center">    
	  <div class="row content">
	    <div class="col-sm-2 sidenav">
	      <p><a href="/member/memberInsert">회원가입</a></p>
	     
	    </div>
	    <div class="col-sm-8 text-center"> 
	      <h1>회원등록</h1>
	    <form action="/member/memberInsert" method="post">
	      <table align="center">
		      		<tr>
		      			<td>ID</td>
		      			<td><input type="text" name="memberId"/></td>
		      		</tr>
		      		<tr>
		      			<td>이름</td>
		      			<td><input type="text" name="memberName"/></td>
		      		</tr>
		      		<tr>
		      			<td>연락처</td>
		      			<td><input type="text" name="memberPhone"/></td>
		      		</tr>
		      		<tr>
		      			<td>등급</td>
		      			<td>
		      				<select name="memberlevelCode">
		      					<option>선택</option>
		      					<c:forEach var="memberLevel" items="${memberlevel}">
		      					<option value="${memberLevel.memberlevelCode}">${memberLevel.memberlevelName}</option>
		      					</c:forEach> 
		      				</select>
		      		</tr>
		      		<tr>
		      			<td>
		      			</td>
		      			<td>
		      				<input type="submit" value="완료"/>
		      				<input type="reset" value="초기화"/>
		      			</td>
	      			</tr>
	      		</table>
	      	</form>
	    </div>
	  </div>
	</div>


</body>
</html>
