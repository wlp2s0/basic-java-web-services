CREATE TABLE IF NOT EXISTS `books` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(255) NOT NULL,
    `author` varchar(255) NOT NULL,
    `rating` INT NOT NULL

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
