<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Выбор комнаты</title>
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

    <script>
        function goToPage(room) {
            document.location.href = 'index/' + room;
        }
    </script>
</head>
<body>
<div>
    <label for="room">Название комнаты</label>
    <input name="room" id="room" placeholder="название">
    <button onclick="goToPage($('#room').val())">перейти</button>
</div>
</body>
</html>