<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouvelle Enchère</title>
</head>
<body>

<jsp:include page="articlesdisponibles.jsp" />

<h2>Nouvelle enchère</h2>

<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>

<form method="post">

    <h3>Client</h3>
    <table>
        <tr>
            <td><label for="revId">Identifiant :</label></td>
            <td><input type="number" name="revId" id="revId" required></td>
        </tr>
        <tr>
            <td><label for="revNom">Nom :</label></td>
            <td><input type="text" name="revNom" id="revNom" required></td>
        </tr>
        <tr>
            <td><label for="revPrenom">Prénom :</label></td>
            <td><input type="text" name="revPrenom" id="revPrenom" required></td>
        </tr>
    </table>

    <h3>Article</h3>
    <table>
        <tr>
            <td><label for="articleId">Identifiant :</label></td>
            <td><input type="number" name="articleId" id="articleId" required></td>
        </tr>
        <tr>
            <td><label for="prix">Prix proposé :</label></td>
            <td><input type="number" name="prix" id="prix" required></td>
        </tr>
    </table>

    <br>
    <input type="submit" value="Soumettre l'enchère">

</form>

</body>
</html>
