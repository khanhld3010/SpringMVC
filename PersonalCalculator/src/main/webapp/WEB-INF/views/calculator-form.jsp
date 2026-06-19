<%--
  Created by IntelliJ IDEA.
  User: luudu
  Date: 6/19/2026
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Ứng Dụng Máy Tính - Spring MVC</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f6;
            padding: 40px;
        }

        .calculator-card {
            max-width: 450px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
            color: #555;
        }

        input[type="number"], select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        .result-box {
            background-color: #d4edda;
            border-left: 5px solid #28a745;
            color: #155724;
            padding: 15px;
            border-radius: 4px;
            margin-top: 25px;
            font-size: 18px;
            text-align: center;
        }

        .error-box {
            background-color: #f8d7da;
            border-left: 5px solid #dc3545;
            color: #721c24;
            padding: 15px;
            border-radius: 4px;
            margin-top: 25px;
            font-size: 16px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="calculator-card">
    <h2>🧮 Máy Tính Spring MVC</h2>

    <form action="${pageContext.request.contextPath}/cal" method="post">

        <div class="form-group">
            <label for="num1">Số thứ nhất (num1):</label>
            <input type="number" id="num1" name="num1" step="any" required placeholder="Nhập số thứ nhất">
        </div>

        <div class="form-group">
            <label for="operator">Phép tính (operator):</label>
            <select id="operator" name="operator" required>
                <option value="+">Cộng (+)</option>
                <option value="-">Trừ (-)</option>
                <option value="*">Nhân (*)</option>
                <option value="/">Chia (/)</option>
            </select>
        </div>

        <div class="form-group">
            <label for="num2">Số thứ hai (num2):</label>
            <input type="number" id="num2" name="num2" step="any" required placeholder="Nhập số thứ hai">
        </div>

        <button type="submit">Tính toán</button>
    </form>

    <c:if test="${not empty error}">
        <div class="error-box">
            ⚠ ${error}
        </div>
    </c:if>

    <c:if test="${not empty result}">
        <div class="result-box">
            📊 Kết quả: <strong>${result}</strong>
        </div>
    </c:if>
</div>

</body>
</html>