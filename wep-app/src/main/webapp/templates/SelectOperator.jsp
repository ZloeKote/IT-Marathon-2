<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Queue</title>
<link rel="stylesheet" href="./css/styleOperator.css">
</head>
<body>
 <header class="header">
        <nav class="nav-bar">
            <div class="nav-bar-wrapper">
                <div class="nav-logo-wrapper">
                    <a href="#" class="nav-link"><i class="nav-logo"></i></a>
                    <a href="/wep-app" class="nav-link"><span class="nav-title">CatGames</span></a>
                </div>
                <div class="nav-menu-wrapper">
                    <a href="./queue" class="nav-link"><span class="nav-menu-item">Черга</span></a>
                    <a href="./operatormenu" class="nav-link"><span class="nav-menu-item">Меню операторів</span></a>
                    <a href="./adminmenu" class="nav-link"><span class="nav-menu-item">Адмін</span></a>
                </div>
                <div class="menu-markup">
                    <div class="menu-button-wrapper">
                        <div class="menu-button"></div>
                    </div>
                    <div class="opened-menu">
                        <a href="#" class="opened-menu-link"><span class="opened-menu-item">Черга</span></a>
                        <a href="#" class="opened-menu-link"><span class="opened-menu-item">Меню операторів</span></a>
                        <a href="#" class="opened-menu-link"><span class="opened-menu-item">Адмін</span></a>
                    </div>
                </div>
            </div>
        </nav>
    </header>

<div class="operator-title"><h1>МЕНЮ ОПЕРАТОРІВ</h1></div>
<div class="table-wrapper">
	<table>
		<tr>
			<th>Id</th>
			<th>Ім'я</th>
			<th>Прізвище</th>
			<th>Пошта</th>
			<th></th>
			<th>Id заявки</th>
			<th>Пошта користувача</th>
			<th></th>
		</tr>
			<%
			 List<Handler> handlers = (ArrayList<Handler>)request.getAttribute("allHandlers");
	        if (handlers != null && !handlers.isEmpty()) {
	            for (Handler h : handlers) {
	            	out.println("<tr>");
	                out.println("<td>" + h.getId() + "</td>");
	                out.println("<td>" + h.getName() + "</td>");
	                out.println("<td>" + h.getSurname() + "</td>");
	                out.println("<td>" + h.getEmail() + "</td>");
	                out.println("<td><form method = \"post\"><button class = \"button-delete\" name = \"button-delete\" value = \"" + h.getEmail() + "\">Видалити</button></form></td>");
	                if (h.getIdticket() == 0)
	                	out.println("<td></td>");
	                else
	                	out.println("<td>" + h.getIdticket() + "</td>");
	                if (h.getUserEmail() == null)
	                {
	                	out.println("<td></td>");
	                	out.println("<td></td>");
	                }
	                else
	                {
	                	out.println("<td>" + h.getUserEmail() + "</td>");
	                	out.println("<td><form method = \"post\"><button class = \"button-done\" name = \"button-done\" value = \"" + h.getIdticket() + "\">Виконано</button></form></td>");
	                }
	                out.println("</tr>");
	            }
	        }
			%>
	</table>
</div>

<div class="form-add">
    <div class="form-add-wrapper">
	    <div class = "form-title"><span>Додати нового оператора</span></div>
        <div class = "form">
            <form method="post">
            <label>Ім'я:</label>
            <input type ="text" name= "name" placeholder = "Enter name" required>
            <label>Прізвище:</label>
            <input type ="text" name = "surname" placeholder = "Enter surname">
            <label>Пошта:</label>
            <input type = "email" name = "email" placeholder = "Enter email" required>
            <button type = "submit" name = "button" value = "add">Додати</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>