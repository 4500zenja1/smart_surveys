# Smart Surveys


## Задание

Разработать систему для проведения опросов мнения пользователей. В системе должна быть возможность создания единоразовых опросов и повторяющихся опросов (один раз в месяц, один раз в месяц до определенного числа и т.д), голосования опросов и просмотра результатов, а также должна быть возможность генерации отчетов в формате pdf. В приложении должно существовать разделение пользователей по ролям:  пользователь, имеющий доступ только к голосованию, пользователь, который может создать опрос и посмотреть результаты, а также  предоставить возможность другому пользователю просмотреть результаты голосования, и администратор, который может управлять пользователями. Система должна иметь документированный API (Swagger).

#### Желательно
Cистема должна иметь графический интерфейс для голосования,  создания опросов и просмотра результатов голосований, управления пользователями (React). 

#### Опционально
Cхема БД должна генерироваться с помощью миграций (использовать Flyway), приложение должно быть обернуто в докер (написать Dockerfile).


## Технологии
Java 17, Spring 6, Spring Boot 3, Spring Security, Gradle/Maven, Spring Doc, React, Flyway, Lombok, Docker, Git


## Замечания
После каждого этапа разработки должен быть коммит (создал проект,  создать миграцию, добавил кнопку и т.д) с пометкой соответствующего номера задания (`#<номер задания> - <описание коммита>`).
