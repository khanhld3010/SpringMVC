<%--
  Created by IntelliJ IDEA.
  User: luudu
  Date: 6/17/2026
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Từ điển Anh - Việt</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f9f9f9;
        }

        .container {
            background-color: white;
            border: 1px solid #ccc;
            padding: 30px;
            width: 450px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .result-box {
            margin-top: 20px;
            padding: 15px;
            border-radius: 5px;
            background-color: #e7f3fe;
            color: #31708f;
            border: 1px solid #bce8f1;
            font-weight: bold;
        }

        input[type="text"] {
            width: 80%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            padding: 9px 15px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Tra cứu Từ điển</h2>

    <%-- Form tìm kiếm: Gửi request lên Controller với đường dẫn /search --%>
    <form action="${pageContext.request.contextPath}/search" method="POST">
        <label for="engWordInput">Nhập từ tiếng Anh:</label><br><br>
        <%-- Thuộc tính name="engWord" bắt buộc phải khớp với @RequestParam("engWord") --%>
        <input type="text" id="engWordInput" name="engWord" required placeholder="Ví dụ: hello, goodbye...">
        <button type="submit">Tìm kiếm</button>
    </form>

    <%-- JSTL kiểm tra: Chỉ hiển thị khối kết quả nếu biến "message" được Controller truyền sang --%>
    <c:if test="${not empty message}">
        <div class="result-box">
                ${message}
        </div>
    </c:if>
</div>
</body>
</html>
