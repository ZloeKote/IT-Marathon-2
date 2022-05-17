const animal = document.getElementById('select-pet');
const game = document.getElementById('select-game');
const reg_button = document.querySelector('.form-button'); 
const title_pet = document.getElementById('title-pet');
const title_image = document.querySelector('.title-under-image');
const big_img = document.getElementById('main-img');
const mobile_text = document.querySelector('.add-text');
const mobile_menu = document.querySelector('.menu-button-wrapper');
const opened_mobile_menu = document.querySelector('.opened-menu');

window.onresize = function() {
    if (document.documentElement.scrollWidth <= 720) {
        if(game.value) mobile_text.style.display = 'inline';
    }
    else {
        mobile_text.style.display = 'none';
    }
}

mobile_menu.addEventListener('click', function() {
    if (opened_mobile_menu.style.display === '') {
        opened_mobile_menu.style.display = 'block';
        mobile_menu.style.backgroundColor = 'var(--background-color-nav-hover)';
    }
    else {
        opened_mobile_menu.style.display = '';
        mobile_menu.style.backgroundColor = 'var(--background-color-nav)';
    }
});

//animal.addEventListener('change', function() {
//    if (animal.value === 'cat') {
//        reg_button.removeAttribute('disabled');
//        title_pet.style.textDecoration = "none";
//        title_pet.style.color = 'white';
//        reg_button.style.backgroundColor = 'var(--background-color-button)';
//        reg_button.style.cursor = 'pointer';
//        
//    }
//    else {
//        reg_button.setAttribute('disabled', 'disabled');
//        title_pet.style.textDecoration = 'underline';
//        title_pet.style.color = 'red';
//        reg_button.style.cursor = "default";
//    }
//});

game.addEventListener('change', function() {
    switch(game.value) {
        case 'dota 2':
            if (document.documentElement.scrollWidth <= 720) {
                mobile_text.style.display = 'inline';
                mobile_text.textContent = '* Сторінка гри в Steam';
                mobile_text.style.fontSize = '18px';
                mobile_text.href = 'https://store.steampowered.com/app/570/Dota_2/';
            }
            title_image.textContent = 'Розрахована на багато користувачів командна комп\'ютерна гра в жанрі MOBA, розроблена і видана корпорацією Valve. Гра є продовженням DotA — картки-модифікації для гри Warcraft III: Reign of Chaos і доповнення до неї Warcraft III: The Frozen Throne. Гра зображає бій на карті особливого виду; у кожному матчі беруть участь дві команди по п\'ять гравців, які управляють «героями» - персонажами з різними наборами здібностей. Для перемоги у матчі команда повинна знищити особливий об\'єкт-«фортеця», що належить ворожій стороні, та захистити від знищення власну «фортецю». Dota 2 працює за моделлю free-to-play з елементами мікроплатежів.';
            title_image.style.width = '1000px';
            title_image.style.fontSize = '22px';
            title_image.style.backgroundColor = 'rgba(44,40,40,0.8)';
            title_image.style.border = '2px solid #605F5F';
            big_img.src = './img/dota_2.jpeg';
            big_img.style.border = '2px solid #605F5F';
            big_img.style.height = 'auto';
            big_img.style.width = '1000px';
            document.body.style.backgroundImage = 'url(./img/dota_2_img.jpg)';
            document.body.style.backgroundRepeat = "no-repeat";
            document.body.style.backgroundSize = 'cover';
            break;
        case 'csgo':
            if (document.documentElement.scrollWidth <= 720) {
                mobile_text.style.display = 'inline';
                mobile_text.textContent = '* Сторінка гри в Steam';
                mobile_text.style.fontSize = '18px';
                mobile_text.href = 'https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/';
            }
            title_image.textContent = 'Розрахована на багато користувачів комп\'ютерна гра, розроблена компаніями Valve і Hidden Path Entertainment. Випуск гри для персональних комп\'ютерів на операційних системах Windows та macOS, а також ігрових приставках Xbox 360 та PlayStation 3 відбувся 21 серпня 2012 року. Версія гри для Linux була випущена в 2014 [1], а в 2016 році гра, в рамках програми зворотної сумісності стала доступна на Xbox One[3]. У вересні 2018 року була випущена безкоштовна версія з можливістю гри з реальними гравцями та з ботами. Пізніше, у грудні цього року гра стала повністю бесплатной.';
            title_image.style.width = '1000px';
            title_image.style.fontSize = '22px';
            title_image.style.backgroundColor = 'rgba(44,40,40,0.8)';
            title_image.style.border = '2px solid #605F5F';
            big_img.src = './img/csgo.jpg';
            big_img.style.border = '2px solid #605F5F';
            big_img.style.height = 'auto';
            big_img.style.width = '1000px';
            document.body.style.backgroundImage = 'url(./img/csgo_img.jpg)';
            document.body.style.backgroundRepeat = "no-repeat";
            document.body.style.backgroundSize = 'cover';
            break;
        case 'brawlhalla':
            if (document.documentElement.scrollWidth <= 720) {
                mobile_text.style.display = 'inline';
                mobile_text.textContent = '* Сторінка гри в Steam';
                mobile_text.style.fontSize = '18px';
                mobile_text.href = 'https://store.steampowered.com/app/291550/Brawlhalla/';
            }
            title_image.textContent = 'free-to-play-файтинг розроблений і випущений Blue Mammoth Games для Microsoft Windows, MacOS, PlayStation 4, Xbox One, Nintendo Switch, Android, iOS. У більшості ігрових режимах Brawlhalla мета полягає в тому, щоб збити суперника з арени, як у Super Smash Bros. Це можна зробити завдаючи шкоди ньому. Втрату можна побачити навколо іконки персонажа опонента, колір якої змінюється з білої на червону в міру отримання втрат. Чим ближче колір до червоного тим далі гравець відлітатиме від ударів, поки він зрештою не вилетить з арени. Якщо вас виштовхнули за край арени, то в результаті ви втрачаєте життя або окуляри. Гравець який залишився останній або той у кого на кінець матчу було найбільше очок перемагає.';
            title_image.style.width = '1000px';
            title_image.style.fontSize = '22px';
            title_image.style.backgroundColor = 'rgba(44,40,40,0.8)';
            title_image.style.border = '2px solid #605F5F';
            big_img.src = './img/brawlhalla_img.jpg';
            big_img.style.border = '2px solid #605F5F';
            big_img.style.height = 'auto';
            big_img.style.width = '1000px';
            document.body.style.backgroundImage = 'url(./img/brawlhalla.jpg)';
            document.body.style.backgroundRepeat = "no-repeat";
            document.body.style.backgroundSize = 'cover';
            break;
        default:
            title_image.textContent = 'CatGames';
            title_image.style.width = '100%';
            title_image.style.fontSize = '128px';
            title_image.style.background = 'none';
            title_image.style.border = 'none';
            big_img.src = './img/boycat_c.png';
            big_img.style.border = 'none';
            big_img.style.height = '690px';
            big_img.style.width = '605px';
            document.body.style.backgroundImage = 'none';
            mobile_text.style.display = 'none';
    }
});