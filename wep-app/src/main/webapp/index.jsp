<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import = "entity.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CatGames</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/javasc.js" defer></script>
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

    <div class="page-wrapper">
        <section class="registration-section">
            <div class="registration-form-wrapper">
                <div class="registration-form-image">
                    <img src="./img/boycat_c.png" alt="Lovely cat" id="main-img">
                    <span class="title-under-image">CatGames</span>
                </div>
                
                <div class="form-card">
                    <div class="form-wrapper">
                        <h2 class="form-title">Реєстрація на безкоштовне отримання ключу від гри</h2>
                        <div class="registration-form">
                            <form class="registration-form" method = "post">
                                <label for="name" class="label-nickname">Ім'я або нікнейм</label>
                                <input type="text" class="form-input" name = "name" placeholder="Введіть ім'я" required>

                                <label for="email" class="label-email">Електронна пошта</label>
                                <input type="email" class="form-input" name = "email" placeholder="Введіть пошту" required>

                                <label for="game" class="label-game">Гра</label>
                                <select id="select-game" class="form-input form-select" name = "game" required>
                                    <option value="">Обери гру</option>
                                    <%
								        List<Game> games = (ArrayList<Game>)request.getAttribute("allGames");
								        if (games != null && !games.isEmpty()) {
								            for (Game g : games) {
								            	out.println("<option value =\"" + g.getName() + "\">" + g.getForm_name() + "</option>");
								            }
								        }
								    %>
                                </select>
                                <a href='#' class="add-text"></a>
                                
                                <label for="pet" class="label-pet" id="title-pet">Улюблена тварина</label>
                                <select class="form-input form-select" id="select-pet" name = "pet" required>
                                    <%
								        List<Pet> pets = (ArrayList<Pet>)request.getAttribute("allPets");
								        if (pets != null && !pets.isEmpty()) {
								            for (Pet p : pets) {
								            	out.println("<option value =\"" + p.getName() + "\">" + p.getForm_name() + "</option>");
								            }
								        }
								    %>
                                </select>

                                <button class="form-button" type="submit">Отримати</button>
                                
                            </form>
                        </div>
                    </div>
                </div>
             </div>
        </section>
    </div>
    
    <footer class="footer">
        <span class="footer-credentials">
            Copyright © 2022 CatGames. Всі права захищені.
        </span>
    </footer>
    
</body>
</html>