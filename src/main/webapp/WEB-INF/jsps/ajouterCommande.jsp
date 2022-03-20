<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CREER COMMANDE</title>
</head>
<body>

<form:form action="saveCommande" method="post" modelAttribute="commande">
<table>
<tr><td>Id Produit:</td> <td><form:input type="text" path="produitId"/></td></tr> 
<tr><td>NAME: </td> <td> <form:input type="text" path="name"/></td></tr>
<tr><td>DESCRIPTION: </td> <td><form:input type="text" path="description"/></td></tr>
<tr><td>QUANTITE: </td> <td><form:input type="number" path="quantite"/></td></tr>
<tr><td>PRICE : </td> <td><form:input type="number" path="price"/></td></tr>
<tr><td>TOTAL: </td> <td><form:input type="number" path="prixTotal"/></td></tr>
<tr><td>ENVIRONMENT</td> <td><form:input type="text" path="env"/></td></tr>
<tr><td></td> <td><input type="submit" value="save"/></td></tr>
</table>
</form:form>
${msg}

<a href="displayCommandes">AFFICHER LES COMMANDES</a>

</body>
</html>