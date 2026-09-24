CREATE DATABASE IF NOT EXISTS campus_express DEFAULT CHARACTER SET utf8mb4;
USE campus_express;
-- JPA 启动时会自动创建/更新表；以下 SQL 可用于初始化基础结构
CREATE TABLE IF NOT EXISTS sys_user (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(100) NOT NULL, nickname VARCHAR(100), phone VARCHAR(30), role VARCHAR(20), created_at DATETIME);
CREATE TABLE IF NOT EXISTS notice (id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(200), content VARCHAR(2000), created_at DATETIME);
CREATE TABLE IF NOT EXISTS package_item (id BIGINT PRIMARY KEY AUTO_INCREMENT, tracking_no VARCHAR(100) NOT NULL, company VARCHAR(100), receiver_name VARCHAR(100), receiver_phone VARCHAR(30), shelf_code VARCHAR(50), status VARCHAR(20), stored_at DATETIME, picked_at DATETIME, owner_id BIGINT NOT NULL, CONSTRAINT fk_package_owner FOREIGN KEY(owner_id) REFERENCES sys_user(id));
INSERT INTO sys_user(username,password,nickname,role,created_at) SELECT 'demo','123456','演示用户','STUDENT',NOW() WHERE NOT EXISTS (SELECT 1 FROM sys_user WHERE username='demo');
INSERT INTO notice(title,content,created_at) SELECT '绿色寄递倡议','请使用可循环快递袋，取件后及时完成取件确认，共建绿色校园。',NOW() WHERE NOT EXISTS (SELECT 1 FROM notice);
