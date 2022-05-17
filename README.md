# IT-Marathon-2
Початкова сторінка
![image](https://user-images.githubusercontent.com/72159857/168828201-b33d9d69-8c80-40d8-bd64-5048fd2ff1fb.png)
Сторінка з операторами
![image](https://user-images.githubusercontent.com/72159857/168828625-e124b738-226f-4ebb-a46b-8b53b595cb4c.png)
Додаємо заявку
![image](https://user-images.githubusercontent.com/72159857/168828972-67a515e7-2805-43e3-8699-3da9ad750067.png)
Бачимо, що заявка автоматично присвоїлася оператору
![image](https://user-images.githubusercontent.com/72159857/168829050-9dfe2f94-2002-46a7-a7e5-4a4ea2f21037.png)
Та в меню операторів також бачимо id заявки та пошту користувача
![image](https://user-images.githubusercontent.com/72159857/168829253-d0d4dc4a-15e1-42c9-93a2-75807cb317dd.png)
Додаємо ще дві заявки та бачимо, що одна заявка присвоїлася оператору, а інша знаходиться у стані NEW
![image](https://user-images.githubusercontent.com/72159857/168829657-f7ee61ac-35a2-42e0-8f56-aaec60191dca.png)
Додаємо одного оператора, та бачимо, що нова заявка автоматично присвоїлася новому оператору
![image](https://user-images.githubusercontent.com/72159857/168829975-f9148be3-1194-4db4-9dd7-0f714153a409.png)
![image](https://user-images.githubusercontent.com/72159857/168830137-ba59284b-d7de-4cce-b575-119147577cda.png)
Додаємо ще одну заявку та закриваємо одну із заявок у першого оператора, бачимо, що автоматично цьому оператору присвоїлася нова заявка, а закрита змінила свій стан
![image](https://user-images.githubusercontent.com/72159857/168830707-caebc0e6-be46-4a2d-82a3-616e7dba471e.png)
![image](https://user-images.githubusercontent.com/72159857/168830751-a9f4aaf3-fa96-4dce-b9b4-7c138f360816.png)
Переходимо в меню адміна
![image](https://user-images.githubusercontent.com/72159857/168830916-2a80c7bf-723c-46cd-8d8b-ce1dbda8e9fb.png)
Додаємо нову гру та тваринку до списків, в яких користувач обирає при створенні заявки
![image](https://user-images.githubusercontent.com/72159857/168831394-11220c46-df5b-4bb9-8688-1bdf864c4bda.png)
![image](https://user-images.githubusercontent.com/72159857/168831467-877bf79a-8688-4924-b5db-bc2633b88412.png)
![image](https://user-images.githubusercontent.com/72159857/168831511-aa01d886-0d10-4e46-8aba-222997c5178a.png)

Додаємо заявку із тільки що створеними варіантами
![image](https://user-images.githubusercontent.com/72159857/168831800-547e07cf-8952-487e-9027-dc680c13cf06.png)
Видаляємо тільки що створені варіанти в меню адміна і в черзі бачимо, що результат (при видаленні очищується поле назви, що показана у випадаючому списку при створенні заявки, а так як при отриманні даних із БД для виводу черги ми виводимо у грі саме цю назву, а в тваринці value, то значення у першого видалилося, а у другого ні)
![image](https://user-images.githubusercontent.com/72159857/168832193-ddfafc67-6235-48f1-8749-bd60e53c2902.png)
Додамо двох нових операторів
![image](https://user-images.githubusercontent.com/72159857/168833282-793d5e8d-b1ee-4c38-bf22-2cd6babff31a.png)
А потім видалимо одного і побачимо, що заявка, яку обробляв видалений оператор, перейшла до вільного
![image](https://user-images.githubusercontent.com/72159857/168833499-6f29d363-78ea-450a-8469-9a16343873ce.png)
Закриємо одну заявку 
![image](https://user-images.githubusercontent.com/72159857/168833723-2731265e-897e-40e9-95bf-235629ad42c9.png)
І створимо ще дві
![image](https://user-images.githubusercontent.com/72159857/168833939-aceef436-0476-4b03-95cf-775daa512362.png)
![image](https://user-images.githubusercontent.com/72159857/168833990-43964ef4-2488-401a-ab23-ed8b6bd00ce0.png)
Перевіримо чи можна створити заявку з поштою, яку раніше вказували. Бачимо, що ні :)
![image](https://user-images.githubusercontent.com/72159857/168834454-84b81f7f-4ffa-4e21-b548-aba6b028ba9c.png)

Виконаємо пошук заявок по пошті користувача та по пошті оператору
![image](https://user-images.githubusercontent.com/72159857/168834727-e9b26f13-2557-427a-a16d-6f1f0188312a.png)
![image](https://user-images.githubusercontent.com/72159857/168834838-b82e84d9-3ded-4523-8e8c-7b7fa9a758d0.png)
Знайдемо всі заявкі, які мають конкретний статус NEW, INPROGRESS або CLOSED
![image](https://user-images.githubusercontent.com/72159857/168835045-3ee9bdc8-3166-4b5d-87b8-25deea679be8.png)
![image](https://user-images.githubusercontent.com/72159857/168835089-f7134f7b-a66b-4812-804e-6a0bd7e8eaad.png)
![image](https://user-images.githubusercontent.com/72159857/168835133-0d2a4941-35c9-467b-97fa-196e7f144775.png)
Щоб дізнатися пошту оператора для введення в пошук, можна навести на його ім'я і побачити цю пошту
![image](https://user-images.githubusercontent.com/72159857/168835525-2fe710e1-3238-4403-afbc-cd4660c53615.png)
При видаленні оператору, яких вже виконував заявки (тобто вже мають статус CLOSED), його ім'я видалиться при перегляді таких заявок
![image](https://user-images.githubusercontent.com/72159857/168836843-404f4f72-7fc2-448c-bcc7-269b0bd51ab5.png)
