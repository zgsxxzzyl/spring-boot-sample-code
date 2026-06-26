com.公司名.项目名/
├── common/ # 全局公共通用模块
│ ├── constant/ # 全局系统常量、状态码、公共配置常量
│ ├── util/ # 通用工具类（日期、加密、JSON、校验等）
│ ├── exception/ # 全局自定义异常、统一异常处理器
│ ├── response/ # 统一返回结果、分页结果封装
│ └── config/ # 全局公共配置
├── module/ # 核心业务领域模块（按业务域拆分）
│ └── xxx(领域名)/ # 单业务领域（user/order/product/pay等）
│ ├── interfaces/ # 接口层（对外入口，仅请求接收、参数校验、数据封装）
│ │ ├── controller/ # HTTP接口控制器、Web入口
│ │ ├── dto/ # 请求/响应数据传输对象
│ │ ├── assembler/ # DTO与领域模型转换转换器
│ │ └── facade/ # 领域防腐对外接口，解耦跨领域调用
│ ├── application/ # 应用层（业务编排、事务控制、事件调度）
│ │ ├── service/ # 应用服务（组装领域能力、串联业务流程）
│ │ └── event/ # 领域事件发布、订阅、消费处理
│ ├── domain/ # 领域层（DDD核心，纯业务规则、无外部依赖）
│ │ ├── model/ # 领域模型
│ │ │ ├── aggregate/ # 聚合根（领域边界、业务入口）
│ │ │ ├── entity/ # 领域实体（有唯一标识、有状态）
│ │ │ └── vo/ # 值对象（无标识、不可变、只读）
│ │ ├── repository/ # 仓储接口（定义数据操作规范，无实现）
│ │ ├── service/ # 领域服务（跨实体复杂业务规则）
│ │ ├── event/ # 领域事件定义
│ │ └── enums/ # 领域专属业务枚举
│ └── infrastructure/ # 领域专属基础设施（仅当前领域生效）
│ ├── repository/ # 仓储接口具体实现类
│ ├── mapper/ # MyBatis数据映射、DAO层
│ ├── client/ # 第三方、微服务远程调用客户端
│ └── config/ # 当前领域专属配置
├── infrastructure/ # 全局基础设施层（通用技术支撑、无业务属性）
│ ├── persistence/ # 全局数据源、事务、持久化配置
│ ├── cache/ # 缓存通用配置与实现
│ ├── mq/ # 消息队列公共组件
│ ├── rpc/ # 远程调用全局配置
│ └── log/ # 全局日志组件
├── api/ # 对外微服务接口层（可选，仅定义、无实现）
│ ├── feign/ # 对外Feign接口定义
│ ├── dto/ # 跨服务传输DTO
│ └── constant/ # 对外公共常量
└── start/ # 项目启动入口
├── XxxApplication.java # SpringBoot启动主类
└── 全局自动配置类
