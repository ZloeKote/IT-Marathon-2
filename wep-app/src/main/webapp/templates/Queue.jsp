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
<link rel="stylesheet" href="./css/styleQueue.css">
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
<div class="tickets-title"><h1>ВСІ ЗАЯВКИ</h1></div>
<div class = "search-form">
    <div class = "search-find">
        <div class="search-title"><span>Знайти</span></div>
        <form method = "post" >
            <label>Користувач</label>
            <div class="search-button">
                <input type = "text" name = "search-user-email" placeholder = "Пошта...">
                <button type = "submit" name = "search-button" value = "search_by_email"><img src = "./img/search.png "class = "search-img"></button>
            </div>
        </form>
        <form method = "post">
            <label>Оператор</label>
            <div class="search-button">
                <input type = "text" name = "search-handler-email" placeholder = "Пошта...">
                <button type = "submit" name = "search-button" value = "search_by_email"><img src = "./img/search.png "class = "search-img"></button>
            </div>
        </form>
    </div>
    <div class = "search-sort">
        <div class="status-button">
            <span>Показати</span>
            <form method = "post"><button value = "NEW" name = "button-sort">NEW</button></form>
            <form method = "post"><button value = "INPROGRESS" name = "button-sort">INPROGRESS</button></form>
            <form method = "post"><button value = "CLOSED" name = "button-sort">CLOSED</button></form>
        </div>
    </div>
</div>
<div class = "table-wrapper">    
	    <%
	        List<Ticket> tickets = (ArrayList<Ticket>)request.getAttribute("allTickets");
	        if (tickets != null && !tickets.isEmpty()) {
	            for (Ticket t : tickets) {
	            	out.println("<div class=\"form-ticket\">");
					if (t.getStatus().equals("NEW"))
						out.println("<div class=\"form-new-ticket-wrapper\">");
					else if (t.getStatus().equals("INPROGRESS"))
						out.println("<div class=\"form-inprogress-ticket-wrapper\">");
	            	else if (t.getStatus().equals("CLOSED"))
						out.println("<div class=\"form-closed-ticket-wrapper\">");
					out.println("<div class=\"ticket-column id-status\"><div class=\"id-column\"><span>" + t.getId() + "</span></div><span>"+ t.getStatus() +"</span></div>");
					out.println("<div class=\"ticket-column username\"><span>Ім'я користувача</span><span>" + t.getUser().getName() + "</span></div>");
					out.println("<div class=\"ticket-column user-email\"><span>Пошта користувача</span><span>" + t.getUser().getEmail() + "</span></div>");
					if (t.getHandler().getName() != null && t.getHandler().getSurname() != null)
						out.println("<div class=\"ticket-column handler-name\" title = \"" + t.getHandler().getEmail() + "\"><span>Оператор</span><span>" + t.getHandler().getName() + " " + t.getHandler().getSurname() + "</span></div>");
					else if (t.getHandler().getName() != null && t.getHandler().getSurname() == null)
						out.println("<div class=\"ticket-column handler-name\" title = \"" + t.getHandler().getEmail() + "\"><span>Оператор</span><span>" + t.getHandler().getName() + "</span></div>");
					else
						out.println("<div class=\"ticket-column handler-name\"><span>Оператор</span><span>-</span></div>");
					
					if (t.getGame().getForm_name() == null)
						out.println("<div class=\"ticket-column game\"><span>Гра</span><span>" + t.getGame().getName() + "</span></div>");
					else 
						out.println("<div class=\"ticket-column game\"><span>Гра</span><span>" + t.getGame().getForm_name() + "</span></div>");
					if (t.getPet().getForm_name() == null)
						out.println("<div class=\"ticket-column pet\"><span>Тваринка</span><span>" + t.getPet().getName() + "</span></div>");
					else
						out.println("<div class=\"ticket-column pet\"><span>Тваринка</span><span>" + t.getPet().getForm_name() + "</span></div>");
					out.println("</div>");
					out.println("</div>");
	            }
	        }
	        else {
	        	out.println("<span class = \"text-not-found\">Жодної заявки не було знайдено!</span>");
	        }
	    %>

 </div>
</body>
</html>