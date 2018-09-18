# shiro介绍
> Apache Shiro 是一个强大易用的 Java 安全框架，提供了认证、授权、加密和会话管理等功能，对于任何一个应用程序，Shiro 都可以提供全面的安全管理服务。并且相对于其他安全框架，Shiro 要简单的多。


> 用户组 => 用户 => 角色 => 权限 => 资源
## `t_sys_user `
| 字段名   | 类型    | 说明         |
| -------- | ------- | ------------ |
| id       | int     |              |
| name     | varchar | 用户名       |
| password | varchar | 密码         |
| salt     | varchar | 盐           |
| locked   | tinyint | 账户是否锁定 |

## `t_sys_role`
| 字段名      | 类型    | 说明     |
| ----------- | ------- | -------- |
| id          | int     |          |
| name        | varchar |          |
| available   | tinyint | 是否可用 |
| description | varchar | 描述     |

## t_sys_group
| 字段名      | 类型    | 说明     |
| ----------- | ------- | -------- |
| id          | int     |          |
| name        | varchar |          |
| parentid    | int     |          |
| available   | tinyint | 是否可用 |
| description | varchar | 描述     |

## t_sys_permission
| 字段名      | 类型    | 说明       |
| ----------- | ------- | ---------- |
| id          | int     |            |
| name        | varchar |            |
| permission  | varchar | 权限字符串 |
| available   | tinyint | 是否可用   |
| description | varchar | 描述       |

| 类型 | 字符串 |
| ---- | ------ |
| 增   | 0001   |
| 删   | 0010   |
| 改   | 0100   |
| 查   | 1000   |


## `t_sys_resource`
| 字段名      | 类型 | 说明     |
| ----------- | ---- | -------- |
| id          | int  |          |
| url         |      |          |
| type        |      |          |
| priority    |      | 排序     |
| parentid    | int  | 父节点id |
| available   |      | 是否可用 |
| description |      | 描述     |
