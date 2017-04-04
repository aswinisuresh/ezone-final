<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<script src="Resources/Bootstrap/bootstrap.js"></script>
<script src="Resources/JQuery/jquery-3.1.1.min.js"></script>
<title>Welcome User</title>
<style type="text/css">
.thumbnail{        
    <!-- width : 100%; -->
    overflow: initial;
    height: 400px;
}

.thumbnail img {
    max-height: 100%;
    max-width: 100%;
}
</style>
</head>
<body>
 <jsp:include page="CommonHeader.jsp"></jsp:include>
 <div class="row">
 <c:forEach items="${prList}" var="pList">
    <div class="col-xs-6 col-md-3">
      <div class="thumbnail">
        <img src="${path}${pList.prodid}.jpg" alt="${pList.prodname}" height="75">
          <div class="caption">
          <center>${pList.prodname}
          <p>Cost: ${pList.prodcost}</p>
          
          <a href="#" class="btn btn-primary"
										   ng-click="addItemToCart('${product.prodiId}')"><span
												class="glyphicon glyphicon-shopping-cart"></span>Add to cart
											</a>
		<%-- 								<a href="<spring:url value="/user/cart" />"
										   class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
          
        <button type="button">Add to Cart</button> --%>
          </center>
          </div>
          </div>
    </div>
    </c:forEach>
    </div> 
    
<jsp:include page="CommonFooter.jsp"></jsp:include>
</body>
</html>