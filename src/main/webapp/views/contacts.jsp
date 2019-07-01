<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 26.05.2017
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UA Book</title>
    <link rel="stylesheet" href="/resources/css/contact.css">
</head>
<body>

<header id="header">
    <div id="name"><span id="blue">U</span><span id="yellow">A</span>Book</div>
    <div id="logo"></div>
    <ul id="navbar">
        <li><a href="/">Головна</a></li>
        <li><a href="/">Автор</a>
            <ul>
                <li><a href="/bookByAuthor/Дешнер">Дешнер</a></li>
                <li><a href="/bookByAuthor/Вейр">Вейр</a></li>
                <li><a href="/bookByAuthor/Ріплі">Ріплі</a></li>
                <li><a href="/bookByAuthor/Джеймс">Джеймс</a></li>
                <li><a href="/bookByAuthor/Назарук">Назарук</a></li>
                <li><a href="/bookByAuthor/Крайтон">Крайтон</a></li>
                <li><a href="/bookByAuthor/Крауч">Крауч</a></li>
                <li><a href="/bookByAuthor/Вандермеєр">Вандермеєр</a></li>
            </ul>
        </li>
        <li><a href="#">Жанр</a>
            <ul id="books">
                <li> <a href="/getBooksByGenre/Роман">Роман</a></li>
                <li><a href="/getBooksByGenre/Фантастика">Фантастика</a></li>
                <li><a href="/getBooksByGenre/Детектив">Детектив</a></li>
                <li><a href="/getBooksByGenre/Триллер">Триллер</a></li>
                <li><a href="/getBooksByGenre/Біографія">Біографія</a></li>
                <li><a href="/getBooksByGenre/Мемуари">Мемуари</a></li>
                <li><a href="/getBooksByGenre/Публіцистика">Публіцистика</a></li>
            </ul>
        </li>
        <li><a href="#">Контакти</a></li>


    </ul>

    <div id="username"><a href="/personalPage"><sec:authorize access="isAuthenticated()"><sec:authentication property="name"/></sec:authorize></a></div>
    <sec:authorize access="isAnonymous()"><div id="sign"><a href="/loginpage">Вхід</a></div></sec:authorize>
    <sec:authorize access="isAuthenticated()"><div id="logout"><a href="/logout" >Вихід</a></div></sec:authorize>

</header>
<div class="clear"></div>
<h2>Контакти:</h2>
<div id="container">

    <h4>ІНТЕРНЕТ-МАГАЗИН</h4>
    <h4>телефони:</h4>
    <p>+38(093)8655163</p>
    <br>
    <p>+38(096)7223094</p>
    <br>
    <p>skype: Роман Блавацький</p>
    <br>
    <p>mail: blavatskuj15@gmail.com</p>
    <img src="/resources/images/contactus.png" alt="" style="width: 200px;height: 200px;margin-left: 580px">
    <p> Ми завжди готові відповісти на Ваші питання і допомогти оформити замовлення.</p>
</div>

<div id="googleMap" style="width: 1070px;height:400px;margin-left: 150px;"></div>

<footer id="footer">
    <div id="networks">
        <div id="text">Приєднуйтесь до нас!</div>
        <a href="https://vk.com/rom4uk1997"><div id="icon1"></div></a>
        <a href="https://www.facebook.com"><div id="icon2"></div></a>
        <a href="https://www.instagram.com"><div id="icon3"></div></a>
    </div>
    <div id="contacts"><span id="cont">Контакти:</span><br>+380967223094<br>+380938655163</div>
</footer>
<script>
    function myMap() {
        var mapProp= {
            center:new google.maps.LatLng(49.841145 ,24.022615),
            zoom:17,
        };
        var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDr32e8uQhbtMlGRBuUzAAay-tkOKIYzZs&callback=myMap"></script>


</body>
</html>
