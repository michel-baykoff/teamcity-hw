# Домашнее задание к занятию 11 «Teamcity»

Авторизованный Teamcity agent
![alt text](image.png)

Автоматически распознанные Build Steps
![alt text](image-5.png)

Сборка с версией 0.0.1 прошла успешно
![alt text](image-2.png)
![alt text](image-3.png)
![alt text](image-6.png)

Так же файлы загрузились в nexus
![alt text](image-4.png)

Создана отдельная ветка
![alt text](image-7.png)

Метод welcomer описан в файлах java.
![alt text](image-8.png)

Сборка и запуск происходит автоматически после публикации в гите. Постоянно забывал поменять версию в pom.xml, не хотел включать перезаписывание, поэтому грузил каждый раз новый для истории
![alt text](image-9.png)

В nexus все версии так же корректно выгружа
![alt text](image-11.png)

По умолчанию артифакт не записывается в teamcity. Для его записи был прописан Artifact paths: target/*.jar => jars, после чего он так же начал выгружаться и в teamcity
![alt text](image-12.png)

