# SpringBoot全家桶
> 学习Sprngboot过程中积累的例子，涵盖广泛，贡献出来，共勉！
> 教程基于SpringBoot2.0+
>
> Github官方参照： [https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples)

## 知识点：

* servlet
* listener
* filter
* interceptor
* shiro
* activemq
* mybatis
* quartz
* restful
* redis
* hikari
* undertow
  - 用java编写的灵活的高性能Web服务器，提供基于NIO的阻塞和非阻塞API。
  - [Enable HTTPS/HTTP2 in Undertow](https://github.com/HumanNature/spring-boot-sample-code/tree/master/springboot-undertow)
* jpa
* freemarker
* lombok
* ehcache
* rome
* thumbnailator
* i8n


## SpringBoot常用注解

| 名称                     | 描述 |
| ------------------------ | ---- |
| @SpringBootApplication   |      |
| @EnableAutoConfiguration |      |
| @ComponentScan           |      |
| @Configuration           |      |
| @RestController          |      |
| @Controller              |      |
| @RequestMapping          |      |
| @ResponseBody            |      |
| @Service                 |      |
| @Repository              |      |
| @Import                  |      |
| @ImportResource          |      |
| @Autowired               |      |
| @Bean                    |      |
| @Value                   |      |
| @Qualifier               |      |
| @Inject                  |      |


# SpringCloud（Finchley版本）

## 服务的注册与发现（Eureka）
* ### [spring-cloud-starter-netflix-eureka-server](https://github.com/zgsxxzzyl/spring-boot-sample-code/tree/master/springcloud-eureka-server)
> 提供服务注册的平台
* ### [spring-cloud-starter-netflix-eureka-client](https://github.com/zgsxxzzyl/spring-boot-sample-code/tree/master/springcloud-eureka-client)
> 注册的服务

## 服务的消费者（REST+ribbon、Feign）
> Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。
>
> ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。

* ### [spring-cloud-starter-netflix-ribbon](https://github.com/zgsxxzzyl/spring-boot-sample-code/tree/master/springcloud-ribbon)

## 断路器（Hystrix）
> 在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。为了解决这个问题，业界提出了断路器模型

* ### [spring-cloud-starter-netflix-hystrix](https://github.com/zgsxxzzyl/spring-boot-sample-code/tree/master/springcloud-hystrix)

## 路由网关（Zuul）

* ### [spring-cloud-starter-netflix-zuul](https://github.com/zgsxxzzyl/spring-boot-sample-code/tree/master/springcloud-zuul)
未完待续。。。
