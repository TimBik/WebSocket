<#ftl encoding="UTF-8"/>
<#macro head value>
    <head>

        <meta charset="utf-8">
        <meta name="view-port">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="ie-edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <#--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
        <#--        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <#--        <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>-->
        <#--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>-->
        <link rel="stylesheet" href="http://localhost:8080/WEB-INF/css/style.css">
        <#--        <script src="http://localhost:8080/WEB-INF/js/chat.js"></script>-->
        <script
                src="https://code.jquery.com/jquery-3.4.1.min.js"
                integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
                crossorigin="anonymous"></script>
        <title>${value}</title>


    </head>
</#macro>



<#macro slideHeadMain>
    <li class="navbar-item">
        <a href="/main" class="nav-link">Главная</a>
    </li>
    <li class="navbar-item active">
        <a href="/finder" class="nav-link">Обмен валют</a>
    </li>
    <li class="navbar-item">
        <a href="/favourite" class="nav-link">Избранное</a>
    </li>
    <li class="navbar-item">
        <a href="/forum" class="nav-link">Чат</a>
    </li>
    <li class="navbar-item">
        <a href="/help" class="nav-link">Помощь</a>
    </li>
</#macro>


<#macro content>


</#macro>


<#macro end>
    <footer class="container-fluid">
        <div class="container-fluid">
            <div class="row padding text-center">
                <div class="col-12">
                    <h2>Наши контакты</h2>
                </div>
                <div class="col-12 social padding">
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#"><i class="fab fa-whatsapp"></i></a>
                    <a href="#"><i class="fab fa-vk"></i></a>
                </div>
            </div>
        </div>
    </footer>
</#macro>
