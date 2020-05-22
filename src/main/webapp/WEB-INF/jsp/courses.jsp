<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<h1>${courses}</h1>
<a href="/setCookie">Set cookie</a>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            type: "POST",
            url: "/courses/add",
            contentType: "application/json",
            data: JSON.stringify({name: "web+course", duration: 52}),
            dataType: 'json'
        })
    })
</script>
</body>
</html>
