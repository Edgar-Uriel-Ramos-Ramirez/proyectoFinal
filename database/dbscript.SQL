CREATE TABLE `user`(
                       `id` INTEGER NOT NULL,
                       `username` varchar(30) NOT NULL,
                       `password` varchar(30) NOT NULL,
                       `user_root` BOOLEAN NOT NULL,
                       CONSTRAINT user_username_uk UNIQUE(username),
                       PRIMARY KEY(`id` AUTOINCREMENT)
);

INSERT INTO user(USERNAME, PASSWORD, user_root) VALUES('admin','admin',1);
INSERT INTO user(USERNAME, PASSWORD, user_root) VALUES('marco','1234',0);

SELECT * FROM user;

SELECT * FROM user WHERE user_root = 0;