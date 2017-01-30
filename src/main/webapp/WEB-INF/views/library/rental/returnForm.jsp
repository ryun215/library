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
	<script type="text/javascript">
	$( document ).ready(function() {
		function getContextPath() {
			var hostIndex = location.href.indexOf( location.host ) + location.host.length;
			return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
		};
	
	$('btn').click(function(){
		 $.ajax({
		        url : getContextPath()+"/getRental",
		        type: "get",
		        data : { "bookCode" : $("#bookCode").val() },
		        success : function(data){
					//@ResponseBody 를 이용해서 이미 json객체로 넘어오기때문에 parse를 할필요가 없다.
		            //var data = JSON.parse(responseData);
		            if(!data){
		                alert("해당도서의 대여정보가 없습니다.");
		                return false;
		            }
		            $("#bookName").val(data.bookName);
		            $("#memberName").val(data.memberName);
		            $("#totalPrice").val(data.totalPrice);
		            $("#rentalPayment").val(data.rentalPayment);
		            $("#willPay").val(data.willPay);
		            $("#rentalCode").val(data.rentalCode);
		            $("#bookTotalDay").val(data.bookTotalDay);
		        }
		    });
		});
	
	});
	
	
	</script>
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
	        <li><a href="/rental/rental">대여관리</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class="container-fluid text-center">    
	  <div class="row content">
	    <div class="col-sm-2 sidenav">
	      <p><a href="/rental/rental">대여</a></p>
	      <p><a href="/rental/return">반납</a></p>
	    </div>
	    <div class="col-sm-8 text-center"> 
	      <h1>도서 반납</h1>
	      <form action="/rental/return" method="post">
		      <table align="center">
		      		<tr>
		      			<td>도서코드</td>
		      			<td><input type="text" id="bookCode" name="bookCode"/></td>
		      			<td><input type="button" id="btn" value="조회" /></td>
		      		</tr>
		      		<tr>
		      			<td>도서명</td>
		      			<td><input type="text" name="bookName" id="bookName"/></td>
		      		</tr>
		      		<tr>
		      			<td>회원이름</td>
		      			<td><input type="text" name="memberId" id="memberId"/></td>
		      		</tr>
		      		<tr>
		      			<td>총요금</td>
		      			<td><input type="text" name="totalPayment" id="totalPayment"/></td>
		      		</tr>
		      		<tr>
		      			<td>받은금액</td>
		      			<td>
		      				<input type="text" id="prePayment"/>
		      			</td>
		      		</tr><tr>
		      			<td>받을금액</td>
		      			<td>
		      				<input type="text" id="receivables"/>
		      			</td>
		      		</tr>
		      		<tr>
		      			<td>
		      			</td>
		      			<td>
		      				<input type="submit" value="반납"/>
		      			</td>
		      		</tr>
		      	</table>
	      	</form>
	    </div>
	  </div>
	</div>
</body>
</html>
