<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Enchères</title>
</head>
<body>

<c:set var="text1" value="Prix: " />
<c:set var="text2" value="Client ID: " />

<jsp:include page="index.jsp" />

<h1>Liste des Enchères par Article</h1>

<c:forEach var="article" items="${articles}">
    <p>
        <strong>Article ID :</strong> ${article.id} <br>
        <strong>Libellé :</strong> ${article.libele} <br>
        <strong>Prix Minimal :</strong> ${article.prixMinimal} €
    </p>

    <c:if test="${not empty article.enchaires}">
        <p>Enchères :</p>
        <ul>
            <c:forEach var="ench" items="${article.enchaires}">
                <li>${text1}${ench.valeur} - ${text2}${ench.client.idClient}</li>
            </c:forEach>
        </ul>
    </c:if>

    <hr>
</c:forEach>

</body>
</html>
