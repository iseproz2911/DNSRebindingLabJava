<!-- index.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DNSRebin Website</title>
    <link rel="icon" type="image/png" href="data:image/png;base64,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">
    <style>
        body {
            background-image: url('https://images4.alphacoders.com/610/610757.jpg');
            background-size: cover;
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #fff;
        }

        form {
            margin-top: 20px;
        }

        label {
            font-size: 18px;
            color: #fff;
        }

        input {
            padding: 8px;
            margin: 5px;
        }

        button {
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        h3, pre, p {
            color: #fff;
        }
    </style>
</head>
<body>
    <h2>DNSRebi Website</h2>

    <form action="FetchURLServlet" method="get">
        <label for="url">Nhập URL:</label>
        <input type="text" id="url" name="url" required>
        <button type="submit">Fetch</button>
    </form>

    <% if (request.getAttribute("content") != null) { %>
        <h3>Kết quả:</h3>
        <pre><%= request.getAttribute("content") %></pre>
    <% } else if (request.getParameter("url") != null) { %>
        <p>Không thể lấy nội dung từ URL.</p>
    <% } %>
</body>
</html>
