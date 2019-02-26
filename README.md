# SpringBoot全家桶2.0+
> 学习Sprngboot过程中积累的例子，涵盖广泛，贡献出来，共勉！
> 教程基于SpringBoot2.0+
>
> Github官方参照： [https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)

## 知识点：

* 前端模板
  - freemarker
  - thymeleaf
* servlet listener filter interceptor
  - [基础使用](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-sample)
* 数据库连接池
  - hikari
* fastjson
  - [springboot默认使用jackson来处理消息](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-fastjson)
* shiro
  - [shiro](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-shiro)
  - [springboot-shiro-multi](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-shiro-multi)
* 分布式session共享
  - @EnableRedisHttpSession
* 消息队列
  - activemq
* 持久化
  - [mybatis](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-mybatis) [mybatis多数据源](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-mybatis-datasource)
  - [jpa](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-jpa)
* redis
  - [使用Redis做缓存](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-redis)
  - [redis与mybati集成](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-mybatis-redis)
* 缓存
  - ehcache
* restful
  - [mybatis实现restful](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-restful)
  - [swagger](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-swagger)
* 注解定时任务
  - [基于quartz注解实现的定时任务](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-quartz)
  - [基于spring实现的定时任务,ThreadPoolTaskScheduler](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-schedule)
* undertow
  - 用java编写的灵活的高性能Web服务器，提供基于NIO的阻塞和非阻塞API。
  - [Enable HTTPS/HTTP2 in Undertow](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-undertow)
* lombok
* rome
* thumbnailator
  - 一个图片压缩工具
* [websocket](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-websocket)
* 语言
  - i8n
* [动态注册bean](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-dynamic-bean)
```
        ApplicationContext applicationContext = (ApplicationContext) SpringApplication.run(SpringbootDynamicBeanApplication.class, args);
        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        //创建bean信息
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 123);
        beanDefinitionBuilder.addPropertyValue("name", "名字");
        beanDefinitionBuilder.addPropertyValue("age", 18);
        beanDefinitionBuilder.addPropertyValue("sex", User.Sex.MAN);
        //动态注册bean
        defaultListableBeanFactory.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
        //获取动态注册的bean
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.toString());

        //删除bean
        defaultListableBeanFactory.removeBeanDefinition("user");
```
* 获取加载的全部bean
```
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDynamicDatasourceApplication.class, args);
        // 获取加载的全部bean
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        // 获取加载指定注解的全部bean
        String[] beanNamesForAnnotation = run.getBeanNamesForAnnotation(RestController.class);
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
```
* [基于注解实现的动态切换数据源](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-dynamic-datasource)
* [全局异常处理](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-global-exception)
* [多语言](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-i18n)


* 分布式事务(未实现)
  - atomikos
  - bitronix


> **什么是分布式事务**
> * 而随着微服务架构的普及，一个大型业务系统往往由若干个子系统构成，这些子系统又拥有各自独立的数据库。往往一个业务流程需要由多个子系统共同完成，而且这些操作可能需要在一个事务中完成。在微服务系统中，这些业务场景是普遍存在的。此时，我们就需要在数据库之上通过某种手段，实现支持跨数据库的事务支持，这也就是大家常说的“分布式事务”。
>
> **事务的四大特性ACID**
> * 原子性(Atomicity) 原子性要求，事务是一个不可分割的执行单元，事务中的所有操作要么全都执行，要么全都不执行。
> * 一致性(Consistency) 一致性要求，事务在开始前和结束后，数据库的完整性约束没有被破坏。
> * 隔离性(Isolation) 事务的执行是相互独立的，它们不会相互干扰，一个事务不会看到另一个正在运行过程中的事务的数据。
> * 持久性(Durability) 持久性要求，一个事务完成之后，事务的执行结果必须是持久化保存的。即使数据库发生崩溃，在数据库恢复后事务提交的结果仍然不会丢失。
>
>
> **分布式事务的解决方案**
> * 全局消息
> * 基于可靠消息服务的分布式事务
> * TCC（Try Confirm Cancel，它属于补偿型分布式事务）
> * 最大努力通知
>
>
> spring提供了一个`PlatformTransactionManager`接口,其有2个重要的实现类：
>
> `DataSourceTransactionManager`：用于支持本地事务，事实上，其内部也是通过操  作java.sql.Connection来开启、提交和回滚事务。
>
> `JtaTransactionManager`：用于支持分布式事务，其实现了JTA规范，使用XA协议进行两阶段提交。需要注意的是，这只是一个代理，我们需要为其提供一个JTA provider，一般是Java EE容器提供的事务协调器(Java EE server's transaction coordinator)，也可以不依赖容器，配置一个本地的JTA provider。
>
> **相关文档：**
> * [常用的分布式事务解决方案](https://juejin.im/post/5aa3c7736fb9a028bb189bca)
> * [Saga分布式事务解决方案与实践](http://servicecomb.apache.org/cn/docs/distributed-transactions-saga-implementation/)
>


## SpringBoot常用注解（关于描述查看API文档比较详细）

| 名称                     | 描述                                       |
| ------------------------ | ------------------------------------------ |
| @SpringBootApplication   |                                            |
| @EnableJpaRepositories   | Annotation to enable JPA repositories <br> |
| @EnableAutoConfiguration | 启用Spring Application Context的自动配置，尝试猜测和配置您可能需要的bean。 自动配置类通常基于您的类路径和您定义的bean来应用。 |
