<!-- myForm.jsp -->

<!DOCTYPE html>
<html>
<head>
    <title>My Form</title>
</head>
<body>
    <h1>Fill out the form:</h1>
    <form action="/submitForm" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <input type="submit" value="Submit">
    </form>
</body>
