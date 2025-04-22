<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des articles</title>
</head>
<body>

<jsp:include page="index.jsp" />

<h2>Articles disponibles</h2>

<c:forEach var="article" items="${articles}">
    <p>
        <strong>ID :</strong> ${article.id} <br>
        <strong>Libellé :</strong> ${article.libele} <br>
        <strong>Prix Minimal :</strong> ${article.prixMinimal} €
    </p>
    <hr>
</c:forEach>

</body>
</html>
