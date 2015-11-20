<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.11.2015
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
  <title>My humble ZOO shop</title>
  <style>
    table, th, td {
      border: 2px solid black;
      border-collapse: collapse;
    }
    th, td {
      padding: 5px;
    }
  </style>
</head>
<body>
<h1>${message}</h1>
<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
  <form action="<c:url value="/logout" />" method="POST" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Logout" />
  </form>
</sec:authorize>
<fieldset>
  <legend>Products list:</legend>
  <table>
    <tr>
      <th>Animal Type</th>
      <th>Name</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
    <c:forEach var="animal" items="${animalsList}">
      <p>
        <tr>
          <td>${animal.type}
          <td>${animal.name}
          <td>${animal.price}
          <td>
          <a href="<c:url value="/add_to_cart"> <c:param name="id" value="${animal.id}"/> </c:url>" >Buy now</a>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value="/update_animal"> <c:param name="id" value="${animal.id}"/> </c:url>" >Edit</a>

            <a href="<c:url value="/delete_animal"> <c:param name="id" value="${animal.id}"/> </c:url>" >Delete</a>
          </sec:authorize>
        </td>
        </tr>
      </p>
    </c:forEach>
  </table>

  <table>
    <tr>
      <th>Title</th>
      <th>Weight</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
    <c:forEach var="food" items="${foodList}">
      <p>
        <tr>
          <td>${food.title}
          <td>${food.weight}
          <td>${food.price}
          <td>
          <a href="<c:url value="/add_to_cart"> <c:param name="id" value="${food.id}"/> </c:url>" >Buy now</a>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value="/update_food"> <c:param name="id" value="${food.id}"/> </c:url>" >Edit</a>

            <a href="<c:url value="/delete_food"> <c:param name="id" value="${food.id}"/> </c:url>" >Delete</a>
          </sec:authorize>
          </td>
        </tr>
      </p>
    </c:forEach>
  </table>

  <table>
    <tr>
      <th>Title</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
    <c:forEach var="accessorie" items="${accsList}">
      <p>
        <tr>
          <td>${accessorie.title}
          <td>${accessorie.price}
          <td>
          <a href="<c:url value="/add_to_cart"> <c:param name="id" value="${food.id}"/> </c:url>" >Buy now</a>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value="/update_accessorie"> <c:param name="id" value="${accessorie.id}"/> </c:url>" >Edit</a>

            <a href="<c:url value="/delete_accessorie"> <c:param name="id" value="${accessorie.id}"/> </c:url>" >Delete</a>
          </sec:authorize>
          </td>
        </tr>
      </p>
    </c:forEach>
  </table>
  <br>
  <sec:authorize access="hasRole('ROLE_ADMIN')">
  <input type="button" onclick="location.href='/create_product';" value="Add new product" />
  </sec:authorize>
</fieldset>
</body>
</html>

