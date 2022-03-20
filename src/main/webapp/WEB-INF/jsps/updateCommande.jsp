<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create COMMANDE</title>
</head>
<body>

<form action="updateCommande" method="post">
<table>

<tr>   <td> </td>  <td>Commande Id: </td> <td></td> <td><input type="text" name="id" value="${commande.commandeId}" readonly/></td>   </tr>

<tr>   <td> </td>  <td>Produit Id: </td> <td></td> <td><input type="text" name="id" value="${commande.produitId}" readonly/></td>   </tr>
 
<tr>   <td> </td>  <td> NAME:  </td> <td></td> <td><input type="text" name="name" value="${commande.name}"/></td>   </tr>

<tr>   <td> </td>  <td> DESCRIPTION: </td> <td></td> <td><input type="text" name="description" value="${commande.description}"/></td>   </tr>
 
<tr>   <td> </td>  <td> QUANTITE: </td> <td></td> <td><input type="text" name="quantite" value="${commande.quantite}"/></td>   </tr>
 
<tr>   <td> </td>  <td> PRICE: </td> <td> </td> <td><input type="text" name="price" value="${commande.price}"/></td>   </tr>
 
<tr>   <td> </td>  <td>  TOTAL:</td> <td></td> <td><input type="text" name="prixTotal" value="${commande.prixTotal}"/></td>   </tr>
 
<tr>   <td> </td>  <td> ENVIRONMENT: </td> <td></td> <td><input type="text" name="prixTotal" value="${commande.env}"/></td>   </tr>
 
<tr>   <td> </td>  <td>  </td> <td></td> <td><input type="submit" value="save"/></td>   </tr>

</table>
</form>

</body>
</html>