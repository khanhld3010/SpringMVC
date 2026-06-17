<%--
  Created by IntelliJ IDEA.
  User: luudu
  Date: 6/17/2026
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quy đổi tiền tệ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }

        .container {
            border: 1px solid #ccc;
            padding: 20px;
            width: 400px;
            border-radius: 8px;
        }

        .result {
            color: green;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Hệ thống Quy đổi USD sang VND</h2>
        <form action="${pageContext.request.contextPath}/convert" method="post">
            <label for="usdInput">Nhập số tiền (USD):</label><br><br>
            <input type="number" id="usdInput" name="usd" step="any" required placeholder="Ví dụ: 100">
            <button type="submit">Quy đổi</button>
        </form>
        <c:if test="${not empty vnd}">
            <div class="result">Kết quả quy đổi: ${vnd} VND</div>
        </c:if>
    </div>
</body>
</html>
