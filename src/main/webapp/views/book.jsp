<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 25.05.2017
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UA Book</title>
    <link rel="stylesheet" href="/resources/css/book.css">
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
    <div id="h"></div>
<div id="book">
    <image src="${bookPage.urlImage}" style="width:160px; height:260px; float:left"></image>
    <p><b>Назва:</b> <span class="bookdescript">${bookPage.name}</span></p>
    <p><b>Автор:</b> <span class="bookdescript">${bookPage.author.name} ${bookPage.author.surname}</span></p>
    <p><b>Жанр:</b> <span class="bookdescript">${bookPage.genre}</span></p>
    <p><b>Ціна:</b> <span class="bookdescript">${bookPage.price} грн</span></p>


    <sec:authorize access="isFullyAuthenticated()"><div><a id="add" href="/addToBusket/${bookPage.id}">В Корзину</a></div></sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')"><div><a id="edit" href="/book/edit/${bookPage.id}">Редагувати</a></div></sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')"><div><a id="delit"  href="/deleteBook/${bookPage.id}">Видалити</a></div></sec:authorize>

    <div id="description">${bookPage.description}</div>
</div>

<footer id="footer">
    <div id="networks">
        <div id="text">Приєднуйтесь до нас!</div>
        <a href="https://vk.com/rom4uk1997"><div id="icon1"></div></a>
        <a href="https://www.facebook.com"><div id="icon2"></div></a>
        <a href="https://www.instagram.com"><div id="icon3"></div></a>
    </div>
    <div id="contacts"><span id="cont">Контакти:</span><br>+380967223094<br>+380938655163</div>
</footer>
</div>
</body>
</html>
