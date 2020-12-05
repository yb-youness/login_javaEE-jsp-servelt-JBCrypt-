CREATE DATABASE `login`;
USE `login`;

CREATE TABLE `user`(
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(50),
    `email` varchar(50),
    `pass` varchar(150),
    `role` varchar (50)
);

