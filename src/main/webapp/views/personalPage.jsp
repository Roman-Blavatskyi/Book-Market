<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 09.05.2017
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UA Book</title>
    <link rel="stylesheet" href="/resources/css/personalPage.css">
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
        <li><a href="/contacts">Контакти</a></li>


    </ul>

    <div id="username"><a href="/personalPage"><sec:authorize access="isAuthenticated()"><sec:authentication property="name"/></sec:authorize></a></div>
    <sec:authorize access="isAnonymous()"><div id="sign"><a href="/loginpage">Вхід</a></div></sec:authorize>
    <sec:authorize access="isAuthenticated()"><div id="logout"><a href="/logout" >Вихід</a></div></sec:authorize>

</header>

<sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/addBook" id="add"><div id="addBook">Додати книгу</div></a></sec:authorize>
<sec:authorize access="isAuthenticated()"><p><a id="buy"href="/buy">Купити</a></p></sec:authorize>
<div id="purchases">
    <c:forEach items="${purchases}" var="p">

        <c:forEach var="c" items="${p.bookList}">
            <div class="book">
                <a href="/myBook/${c.id}"> <image src="${c.urlImage}" style="width:120px; height:200px" ></image>    </a>
                <p id="nameB">${c.name}</p>
                <p id="priceB">${c.price} грн</p>
                <sec:authorize access="isAuthenticated()"><p ><a id="delit"  href="/deleteBook/${c.id}">Видалити</a></p></sec:authorize>
            </div>
        </c:forEach>

        <div id="amount">Загальна сума покупки: ${p.amount}</div>

    </c:forEach>
</div>
<footer id="footer">
    <div id="networks">
        <div id="text">Приєднуйтесь до нас!</div>
        <a href="https://vk.com/rom4uk1997"><div id="icon1"></div></a>
        <a href="https://www.facebook.com"><div id="icon2"></div></a>
        <a href="https://www.instagram.com"><div id="icon3"></div></a>
    </div>
    <div id="contacts"><div id="cont">Контакти:</div><br>+380967223094<br>+380938655163</div>
</footer>
</body>
</html>
