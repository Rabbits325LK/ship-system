-- CREATE DATABASE SHIP_SYSTEM(创建数据库) --
CREATE DATABASE 'ship_system' DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
--CREATE MODULE(模块) --
DROP TABLE IF EXISTS module_info;
CREATE TABLE module_info (
module_id int(11) NOT NULL PRIMARY KEY auto_increment,
module_name varchar(50) NOT NULL,
module_type varchar(15) DEFAULT 'jsp',
module_str  varchar(255) DEFAULT NULL,
module_priority int(11) DEFAULT '0',
module_description varchar(255) DEFAULT '默认生成模块'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--CREATE MODULE END--

-- INSERT INTO MODULE --
insert into module_info(module_name,module_type,module_str,module_description) values ('root','ship','/root','超级管理员');
insert into module_info(module_name,module_type,module_str,module_description) values ('administrator','ship','/admin','管理员');
insert into module_info(module_name,module_type,module_str,module_description) values ('personnel','ship','/per','人事');
insert into module_info(module_name,module_type,module_str,module_description) values ('finacial','ship','/fin','财务');
insert into module_info(module_name,module_type,module_str,module_description) values ('planning','ship','/pla','策划');
insert into module_info(module_name,module_type,module_str,module_description) values ('waiter','ship','/waiter','客服');
insert into module_info(module_name,module_type,module_str,module_description) values ('shipowners','ship','/owners','船主');
insert into module_info(module_name,module_type,module_str,module_description) values ('captain','ship','/captain','船长');
insert into module_info(module_name,module_type,module_str,module_description) values ('averageuser','ship','/user','普通用户');
insert into module_info(module_name,module_type,module_str,module_description) values ('guest','ship','/guest','访客');
insert into module_info(module_name,module_type,module_str,module_description) values ('developers','ship','/api','开发者');
-- INSERT INTO MODULE END --

--CREATE ROLE(角色) --
DROP TABLE IF EXISTS role_infe;
CREATE TABLE role_info (
role_id int(11) NOT NULL PRIMARY KEY auto_increment,
role_name varchar(50) NOT NULL,
role_description varchar(255) DEFAULT '默认生成角色'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--CREATE ROLE END --

-- INSERT INTO　ROLE --
insert into role_info(role_name,role_description) values ('ROLE_ROOT','超级管理员');
insert into role_info(role_name,role_description) values ('ROLE_ADMIN','管理员');
insert into role_info(role_name,role_description) values ('ROLE_PER','人事管理员');
insert into role_info(role_name,role_description) values ('ROLE_FIN','财务管理员');
insert into role_info(role_name,role_description) values ('ROLE_PLA','策划管理员');
insert into role_info(role_name,role_description) values ('ROLE_WAITER','客服');
insert into role_info(role_name,role_description) values ('ROLE_OWNERS','船主');
insert into role_info(role_name,role_description) values ('ROLE_CAPTAIN','船长');
insert into role_info(role_name,role_description) values ('ROLE_USER','普通用户');
insert into role_info(role_name,role_description) values ('ROLE_GUEST','访客');
insert into role_info(role_name,role_description) values ('ROLE_DEVELOPERS','开发者');
-- INSERT INTO ROLE END --

--CREATE ROLE_MODULE(角色模块中间表) --
DROP TABLE IF EXISTS role_module;
CREATE TABLE role_module (
role_id int(11) NOT NULL,
module_id int(11) NOT NULL,
PRIMARY KEY (role_id,module_id),
KEY fk_role (role_id),
KEY fk_module (module_id),
CONSTRAINT fk_role FOREIGN KEY (role_id)
REFERENCES role_info(role_id),
CONSTRAINT fk_module FOREIGN KEY (module_id)
REFERENCES module_info(module_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
--CREATE ROLE_MODULE END --

--INSERT INTO ROLE_MODULE --
INSERT INTO role_module values (1,1);
INSERT INTO role_module values (1,2);
INSERT INTO role_module values (1,3);
INSERT INTO role_module values (1,4);
INSERT INTO role_module values (1,5);
INSERT INTO role_module values (1,6);
INSERT INTO role_module values (1,7);
INSERT INTO role_module values (1,8);
INSERT INTO role_module values (1,9);
INSERT INTO role_module values (1,10);
INSERT INTO role_module values (1,11);
INSERT INTO role_module values (2,2);
INSERT INTO role_module values (2,3);
INSERT INTO role_module values (2,4);
INSERT INTO role_module values (2,5);
INSERT INTO role_module values (2,6);
INSERT INTO role_module values (3,3);
INSERT INTO role_module values (4,4);
INSERT INTO role_module values (5,5);
INSERT INTO role_module values (6,6);
INSERT INTO role_module values (7,7);
INSERT INTO role_module values (7,9);
INSERT INTO role_module values (8,8);
INSERT INTO role_module values (9,9);
INSERT INTO role_module values (10,10);
INSERT INTO role_module values (11,11);
--INSERT INTO ROLE_MODULE END --

--CREATE USER(用户) --
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
user_id int(11) not null primary key auto_increment,
user_code varchar(32) not null,
user_pwd varchar(64) not null,
user_name varchar(32)not null,
user_nickname varchar(32),
user_gender int(4) not null,
user_idcard varchar(32),
user_address varchar(128),
user_email varchar(64),
user_tel varchar(13),
user_phone varchar(11),
user_qq varchar(32),
user_images varchar(128),
user_enabled int(4) default '1',
user_description varchar(255) DEFAULT '用户'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- CREATE USER END --

-- INSERT INTO USER --
insert into user_info(user_code,user_pwd,user_name,user_gender) values ('rabbits325@live.cn','lk13510599125','梁慷',1);
-- INSERT INTO USER END --

--CREATE USER_ROLE(用户角色中间表) --
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
user_id int(11) NOT NULL,
role_id int(11) NOT NULL,
PRIMARY KEY(user_id,role_id),
KEY ur_user (user_id),
KEY ur_role (role_id),
CONSTRAINT ur_user FOREIGN KEY (user_id)
REFERENCES user_info(user_id),
CONSTRAINT ur_role FOREIGN KEY (role_id)
REFERENCES role_info(role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- CREATE USER_ROLE END --

-- INSERT INTO USER_ROLE --
insert into user_role values (1,1);
-- INSERT INTO USER_ROLE END --