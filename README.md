# GradleMusicApi

基于 **Kotlin + Spring WebFlux** 的网易云音乐 API 代理服务，封装网易云音乐接口并提供统一的 RESTful API，支持 JWT 认证。

## 技术栈

| 类别 | 技术 |
|---|---|
| 框架 | Spring Boot 4.0.6 · Spring WebFlux |
| 语言 | Kotlin 2.2 · JDK 17 |
| 认证 | Spring Security · JJWT 0.12 |
| HTTP 客户端 | Retrofit2 3.0 · OkHttp3 5.3 |
| 序列化 | Kotlinx Serialization 1.10 |
| API 文档 | SpringDoc OpenAPI 3.0 |

## 快速开始

```bash
./gradlew bootRun
```

启动后访问 Swagger 文档：`http://localhost:8080/swagger-ui.html`

## 认证

所有接口（除登录外）需要在请求头中携带 JWT Token：

```
Authorization: Bearer <token>
```

Token 通过扫码登录流程获取，见下方登录接口。

## API 接口

### 登录

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/key` | 获取登录 Key 及二维码 |
| GET | `/login` | 扫码后获取 Token |
| GET | `/login/status` | 检查登录状态 |

### 页面聚合

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/recommend` | 推荐页数据 |
| GET | `/mine` | 我的页面数据 |

### 歌手

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/artists` | 歌手列表 |
| GET | `/artist/{id}` | 歌手详情 |
| GET | `/artist/{id}/fans` | 歌手粉丝列表 |

### 歌单

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/user/current/playlists` | 当前用户歌单 |
| GET | `/user/{userId}/playlists` | 指定用户歌单 |
| GET | `/playlist/{id}` | 歌单详情 |
| DELETE | `/playlist/{id}` | 删除歌单 |
| POST | `/playlist/{id}/subscribers` | 收藏歌单 |
| DELETE | `/playlist/{id}/subscribers` | 取消收藏 |
| GET | `/playlist/{id}/subscribers` | 歌单收藏者 |
| PATCH | `/user/current/playlist/{playlistId}/songs` | 添加歌曲到歌单 |
| DELETE | `/user/current/playlist/{playlistId}/songs/{songId}` | 从歌单移除歌曲 |
| GET | `/playlist/top` | 精品歌单列表 |
| GET | `/playlist/top/tags` | 精品歌单标签 |

### 歌曲 / 专辑 / MV

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/song/{id}` | 歌曲详情 |
| GET | `/album/{id}` | 专辑详情 |
| GET | `/mv/{id}` | MV 详情 |

### 用户

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/user/{id}` | 用户详情 |
| GET | `/user/{id}/follows` | 用户关注列表 |
| GET | `/user/{id}/followeds` | 用户粉丝列表 |
| GET | `/user/current/status` | 当前用户状态 |
| PUT | `/user/current/status` | 更新用户状态 |

### 评论 / 消息

| 方法 | 路径 | 说明 |
|---|---|---|
| GET | `/comment` | 获取评论 |
| GET | `/comment/{commentId}/child` | 获取子评论 |
| GET | `/message` | 私信列表 |
| GET | `/message/{userId}` | 与指定用户的私信 |
| GET | `/notification/comments` | 通知-评论 |
| GET | `/notification/notices` | 通知-通知 |

## 项目结构

```
src/main/kotlin/com/ke/gradlemusicapi/
├── api/            # Retrofit2 接口定义（网易云音乐 API）
├── config/         # JWT、Security、OpenAPI 配置
├── controller/     # RESTful 控制器
├── entity/
│   ├── response/   # 网易云音乐 API 原始响应 DTO
│   └── vo/         # 对外暴露的业务视图对象
└── util/           # 工具类
```
