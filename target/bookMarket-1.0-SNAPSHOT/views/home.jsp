<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 02.05.2017
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>BoolBook</title>
    <link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>

<div id="main">
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
            <li><a href="/contacts">Контакти</a></li>


        </ul>

        <div id="username"><a href="/personalPage"><sec:authorize access="isAuthenticated()"><sec:authentication property="name"/></sec:authorize></a></div>
        <sec:authorize access="isAnonymous()"><div id="sign"><a href="/loginpage">Вхід</a></div></sec:authorize>
        <sec:authorize access="isAuthenticated()"><div id="logout"><a href="/logout" >Вихід</a></div></sec:authorize>

    </header>

    <%--<sec:authorize access="isAuthenticated()"> <p><a href="/buy">Buy all books</a></p></sec:authorize>--%>
    <div id="h"></div>
    <div class="slideShow" style="max-width:100%">
        <img class="mySlides" src="/resources/bannerImages/-15_18_05_КМsite_TOP.jpg" style="width:100%; height:350px;">
        <img class="mySlides" src="/resources/bannerImages/ФранцузькийРоман_КМsite_TOP.jpg" style="width:100%; height: 350px;">
        <img class="mySlides" src="/resources/bannerImages/TheFireman_КМsite_TOP.jpg" style="width:100%; height:350px;">
        <img class="mySlides" src="/resources/bannerImages/Middle_School_КМsite_TOP2.jpg" style="width:100%; height:350px;">
    </div>
<div id="listBooks">
    <c:forEach var="c" items="${b}">

        <div class="book">
            <a href="/myBook/${c.id}"> <image src="${c.urlImage}" style="width:170px; height:260px" ></image>    </a>
            <p id="nameB">${c.name}</p>
            <p id="priceB">${c.price} грн</p>
        </div>

    </c:forEach>
</div>
<%--    <c:forEach var="c" items="${b}" >
        <p>${c.name}</p>
        <p><a href="/book/edit/${c.id}">Edit</a></p>
        <p><a href="/addToBusket/${c.id}">Add To Busket!</a></p>

    </c:forEach>--%>


<%--<div id="proverb"><p> READER LIVES</p><br><p>A THOUSAND LIVES</p> <br><p>BEFORE HE DIES.</p> <br><p> THE MAN </p><br><p>WHO NEVER READS -  </p><br><p> THE ONLY ONE.</p></div>--%>
    <footer id="footer">
        <div id="networks">
        <div id="text">Приєднуйтесь до нас!</div>
        <a href="https://vk.com/rom4uk1997"><div id="icon1"></div></a>
        <a href="https://www.facebook.com"><div id="icon2"></div></a>
        <a href="https://www.instagram.com"><div id="icon3"></div></a>
        </div>
        <div id="contacts"><div id="cont">Контакти:</div><br>+380967223094<br>+380938655163</div>
    </footer>
</div>

<%--
<script>
    var genre = window.location.url;
    function getBooksFromGenre(){
        var e = document.getElementsByName("genre");
        genre = e.options[e.selectedIndex].value;
        window.location.href = "/getBooksByGenre/"+genre;
    }

    function setSelectValue() {
        genre = decodeURIComponent(window.location.href);
        document.getElementById("selectId").value = genre.split("/")[genre.split("/").length-1];
    }
    setSelectValue()
</script>--%>
<%--<select  onchange="getBooksFromGenre()" id = "selectId">
                      option id = "genre1">Roman</option><
                      <option id = "genre2">Roman</option>
                      <option id = "genre3">Поезія</option>
                      <option id="genre4">Драма</option>
                  </select>--%>
<script>
    function myFunction() {
        var input, filter, ul, li, a, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL");
        li = ul.getElementsByTagName("li");
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("a")[0];
            if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";

            }
        }
    }
</script>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 3000); // Change image every 2 seconds
    }
</script>

</body>
</html>
