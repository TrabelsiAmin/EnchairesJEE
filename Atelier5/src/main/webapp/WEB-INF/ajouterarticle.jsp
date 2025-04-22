<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajout Article</title>
</head>
<body>

<jsp:include page="index.jsp" />

<h2>ajout d'un article avec revendeur</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form method="post">

    <h3>Revendeur</h3>
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
            <td><label for="libelle">Libellé :</label></td>
            <td><input type="text" name="libelle" id="libelle" required></td>
        </tr>
        <tr>
            <td><label for="prixMinimal">Prix minimal :</label></td>
            <td><input type="number" step="0.01" name="prixMinimal" id="prixMinimal" required></td>
        </tr>
    </table>

    <br>
    <input type="submit" value="Enregistrer">

</form>

</body>
</html>
