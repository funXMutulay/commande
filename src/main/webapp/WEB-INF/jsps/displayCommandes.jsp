<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>COMMANDES</title>
</head>
<body>

<h2>Commandes:</h2>
<table>
<tr>
<th>Commande Id</th>
<th>Commande Id</th>
<th>Name</th>
<th>Description</th>
<th>Quantite</th>
<th>Prix</th>
<th>Total</th>
<th>Environnement</th>
</tr>

<c:forEach items="${commandes}" var="commande">
<tr>
<td>${commande.commandeId}</td>
<td>${commande.produitId}</td>
<td>${commande.name}</td>
<td>${commande.description}</td>
<td>${commande.quantite}</td>
<td>${commande.price}</td>
<td>${commande.prixTotal}</td>
<td>${commande.env}</td>
<td><a href="deleteCommande?id=${commande.commandeId}">delete</a></td>
<td><a href="showUpdate?id=${commande.commandeId}">edit</a></td>
</tr>
</c:forEach>
</table>
<a href="showCreate">Add Commande</a>
</body>
</html>