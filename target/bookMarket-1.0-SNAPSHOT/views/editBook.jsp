<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 08.05.2017
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BoolBook</title>
    <link rel="stylesheet" href="/resources/css/edit.css">
</head>
<body>

<header id="header">
    <div id="name1"><div id="blue">U</div><div id="yellow">A</div>Book</div>
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
<div id="main">
<form  action="/editBooks", method="post">
    <input name="bookId" id="id" type="text" value="${books.id}">
    <label for="name"></label>
    <input name="bookName" id="name" type="text" value="${books.name}">
    <label for="author"></label>
    <input name="authorName" id="author" type="text" value="${books.author.name} ${books.author.surname}">
    <label for="genre"></label>
    <input name="genreName" id="genre" type="text" value="${books.genre}">
    <label for="price"></label>
    <input name="priceName" id="price" type="text" value="${books.price}">
    <label for="description"></label>
    <input name="descriptionName" id="description" type="text" value="${books.description}">
    <label for="urlImage"></label>
    <input name="urlName" id="urlImage" type="text" value="${books.urlImage}">
    <button type="submit">Edit</button>
</form>
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
