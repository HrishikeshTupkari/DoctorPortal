<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Data</title>
</head>
<body>
    <h1>Welcome To Doctor Portal</h1>
    <p>
        Message: ${apiResponse.message}<br>
        Patient Name: ${apiResponse.patientDTO.name}<br>
        Patient Email: ${apiResponse.patientDTO.email}<br>
        Patient cell: ${apiResponse.patientDTO.cell}<br>        
        <!-- Add more attributes from your API response class as needed -->
    </p>
</body>
</html>