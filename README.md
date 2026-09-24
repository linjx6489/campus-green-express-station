# 校园绿色快递驿站

Spring Boot + JPA + MySQL 后端与微信原生小程序示例项目。

## 快速启动

1. 创建数据库并执行 `database/schema.sql`。
2. 修改 `backend/src/main/resources/application.yml` 中的数据库账号密码。
3. 使用 JDK 17、Maven 运行：`mvn spring-boot:run`。
4. 在微信开发者工具导入 `miniprogram`，将 `app.js` 中的 `baseUrl` 改为本机可访问地址。

## 演示账号

首次启动会自动创建演示用户：`demo` / `123456`。接口返回 JWT，前端保存在本地缓存中。

## 主要接口

- `POST /api/auth/login` 登录
- `GET /api/express/packages` 查询我的快递
- `POST /api/express/packages` 创建入库记录
- `POST /api/express/packages/{id}/pickup` 取件
- `GET /api/notices` 公告列表
