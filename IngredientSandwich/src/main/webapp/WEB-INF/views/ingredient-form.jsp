<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Quản Lý Gia Vị - Spring MVC</title>
    <style>
        body { font-family: sans-serif; padding: 20px; max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 12px; }
        .success-box { background-color: #d4edda; color: #155724; padding: 15px; border-radius: 5px; margin-top: 20px; }
        .error-box { background-color: #f8d7da; color: #721c24; padding: 15px; border-radius: 5px; margin-top: 20px; }
    </style>
</head>
<body>

<h2>Chọn các gia vị cho món ăn của bạn:</h2>

<form action="${pageContext.request.contextPath}/save" method="post">
    <div class="form-group"><input type="checkbox" name="condiment" value="Muối"> Muối</div>
    <div class="form-group"><input type="checkbox" name="condiment" value="Tiêu"> Tiêu</div>
    <div class="form-group"><input type="checkbox" name="condiment" value="Tương ớt"> Tương ớt</div>
    <div class="form-group"><input type="checkbox" name="condiment" value="Mayonnaise"> Mayonnaise</div>
    <button type="submit">Lưu Lựa Chọn (Save)</button>
</form>

<hr>

<c:if test="${not empty errorMessage}">
    <div class="error-box">
        <strong>Lỗi:</strong> ${errorMessage}
    </div>
</c:if>

<c:if test="${not empty selectedCondiments}">
    <div class="success-box">
        <strong>${successMessage}</strong>
        <p>Khay gia vị của bạn bao gồm:</p>
        <ul>
            <c:forEach var="item" items="${selectedCondiments}">
                <li>Món: ${item}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

</body>
</html>