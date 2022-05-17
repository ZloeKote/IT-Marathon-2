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
<link rel="stylesheet" href="./css/styleAdmin.css">
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

<div class="admin-title"><h1>МЕНЮ АДМІНА</h1></div>
	<div class = "table-wrapper">    
		<div class = "table-games">
			<table>
				<tr>
					<th>Id</th>
					<th>Value</th>
					<th>Назва у формі</th>
		
				</tr>
			    <%
			        List<Game> games = (ArrayList<Game>)request.getAttribute("allGames");
			        if (games != null && !games.isEmpty()) {
			            for (Game g : games) {
			            	out.println("<tr>");
			                out.println("<td>" + g.getId() + "</td>");
			                out.println("<td>" + g.getName() + "</td>");
			                out.println("<td>" + g.getForm_name() + "</td>");
			                out.println("</tr>");
			            }
			        }
			    %>
			</table>
	</div>
	<div class = "table-pets">
		<table>
			<tr>
				<th>Id</th>
				<th>Value</th>
				<th>Назва у формі</th>
			</tr>
			<%
			        List<Pet> pets = (ArrayList<Pet>)request.getAttribute("allPets");
			        if (pets != null && !pets.isEmpty()) {
			            for (Pet p : pets) {
			            	out.println("<tr>");
			                out.println("<td>" + p.getId() + "</td>");
			                out.println("<td>" + p.getName() + "</td>");
			                out.println("<td>" + p.getForm_name() + "</td>");
			                out.println("</tr>");
			            }
			        }
			    %>
		</table>
	</div>
 </div>
 
<div class="form">
    <div class="form-wrapper">
        <div class = "form-title"><span>Додати нову гру</span></div>
        <div class = "form-do form-add-game-wrapper">
            <form method="post">
            <label>Value:</label>
            <input type ="text" name= "value" placeholder = "Введіть value" required>
            <label>Назва у формі:</label>
            <input type ="text" name = "form_name" placeholder = "Введіть назву у формі" required>
            <button type = "submit" name = "button" value = "add_game">Додати</button>
            </form>
        </div>
        
        <div class = "form-title"><span>Додати нову тваринку</span></div>
        <div class="form-add-pet-wrapper">
        <div class = "form-do form-add-pet">
            <form method="post">
            <label>Value:</label>
            <input type ="text" name= "value" placeholder = "Введіть value" required>
            <label>Назва у формі:</label>
            <input type ="text" name = "form_name" placeholder = "Введіть назву у формі" required>
            <button type = "submit" name = "button" value = "add_pet">Додати</button>
            </form>
        </div>
        </div>
        
        <div class = "form-title"><span>Видалити гру</span></div>
        <div class="form-delete-game-wrapper">
        <div class = "form-do form-delete-game">
            <form method="post">
            <label>Value:</label>
            <input type ="text" name= "value" placeholder = "Введіть value" required>
            <button type = "submit" name = "button" value = "delete_game">Видалити</button>
            </form>
        </div>
        </div>
        
        <div class = "form-title"><span>Видалити тваринку ;(</span></div>
        <div class="form-delete-pet-wrapper">
        <div class = "form-do form-delete-pet">
            <form method="post">
            <label>Value:</label>
            <input type ="text" name= "value" placeholder = "Введіть value" required>
            <button type = "submit" name = "button" value = "delete_pet">Видалити</button>
            </form>
        </div>
        </div>
    </div>
 </div>

<footer class="footer">
        <span class="footer-credentials">
            Copyright © 2022 CatGames. Всі права захищені.
        </span>
    </footer>
</body>
</html>