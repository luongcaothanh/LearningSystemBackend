# Learning System

## 1. Introduction

This project implements a learning system for a university. This will be a staff and student management system of this university. Users can log in and perform tasks depending on their role. There are 4 roles:
- Trainning department.
- Faculty management.
- Lecturer.
- Student.

## 2. Prerequisites

Before you continue, ensure you meet the following requirements:
- You must have installed the latest version of Java 11 on your PC.
- You must have installed the latest version of Node 18 on your PC.
- You must have installed the latest version of MariaDB on your PC.
- You can use any IDE, but I recommend Intellij for Java and Visual Studio Code for Javascript. In addition, you can use GUI for MariaDB database (recommended to use MySQL Workbench).

## 3. Install

After you have met the above requirements, you can continue to follow the instructions below: 

#### 3.1. Database

- Open MySQL Workbench and create a new database (the database name is whatever you like).
- You can download [Sample data](https://drive.google.com/drive/folders/1GsALl5AvYZBFe4mY4VlxI0sGcWBOBgQv?usp=share_link) for better visualization.
- After you have downloaded the sample data, add it to the database you just created in the order `Table.sql` -> `Data.sql` -> `Procedures.sql`.
- Also, please remember the database username and password because they will be used later.

#### 3.2. Backend

- Clone the [Backend project](https://github.com/luongcaothanh/LearningSystemBackend) into Intellij, then Intellij will automatically install the dependencies for you.
- Next, you need to reconfigure the database information, open the file `application.properties` and change it to yours.

```
spring.datasource.url=jdbc:mariadb://localhost:3306/{my_database_name}
spring.datasource.username={my_username}
spring.datasource.password={my_password}
```

#### 3.3. Frontend

- Clone the [Frontend project](https://github.com/luongcaothanh/LearningSystemFrontend) into Visual Studio Code, then run `npm install` in terminal to install dependencies.

## 4. How to use

After you complete the installation step, now, you can start the project and see the results.

- For the Backend, you can run it in Intellij using the `run icon` in the upper right corner or `Shift + F10`.
- For the Frontend, you can run it in VS Code with the command `npm start` in the terminal.

Wait a few seconds and you will see the following result:

![image](https://user-images.githubusercontent.com/89692376/215098506-8272846d-0f9a-43d5-b747-77cfb1f8e3cb.png)

Now, you can use sample accounts to sign in, for example:
- Trainning department: aao1, 123456.
- Faculty management: manager1, 123456.
- Lecturer: lecturer05, 123456.
- Student: student02, 123456.

## 5. List of features

For this project, I implement features for each specific user group:
- Trainning department: view information of staff, students, subjects, faculties. Create accounts for staff, students, ...
- Faculty management: view information of staff, students, subjects of my faculty, ...
- Lecturer: view my class, list student of class, ...
- Student: registered subjects. View the list of registered subjects, ...

## 6. Some pictures

- Homepage

![image](https://user-images.githubusercontent.com/89692376/215102130-d01db591-8ed1-405b-bde9-0f295d2cb005.png)

- AAO profile

![image](https://user-images.githubusercontent.com/89692376/215102658-6620e217-d3bb-42cc-9187-ec8721188cdc.png)

- Lecturer profile

![image](https://user-images.githubusercontent.com/89692376/215104483-5d4e46ab-1819-4c67-a0c8-2a329dc9745f.png)

- Student profile

![image](https://user-images.githubusercontent.com/89692376/215103150-7da1159e-3e05-4ba4-9eb2-7178b2093091.png)

- List of faculties

![image](https://user-images.githubusercontent.com/89692376/215103276-4e7720a6-8174-45a4-9a54-d9e0a3ba773d.png)

- List of students

![image](https://user-images.githubusercontent.com/89692376/215103549-5a051f28-537f-40c9-8c05-83897ad853c7.png)

- Modal create new account for student

![image](https://user-images.githubusercontent.com/89692376/215104054-8474540d-dd14-46be-aa75-e8a8d7518f84.png)

- List of staff

![image](https://user-images.githubusercontent.com/89692376/215103641-e82734dd-1d51-4fbc-9866-988a42af0312.png)

- List of subjects

![image](https://user-images.githubusercontent.com/89692376/215103761-0457166a-14fe-467f-a4bb-94b839a75374.png)

- Register subject

![image](https://user-images.githubusercontent.com/89692376/215104206-3ab14600-6fb7-4b95-baef-4160b636ee09.png)