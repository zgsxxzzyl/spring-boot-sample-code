# springcloud-hystrix

*hystrix.contrib.javanica.exception.FallbackDefinitionException: fallback method wasn't found*

```java
@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloError")
    public String getOrder(Integer a, Integer b){
        return restTemplate.getForObject("http://customer-business-service/show?a="+a+"&b="+b, String.class);
    }
    public String helloError(){
        return "error";
    }
}
```
应该为：
```java
@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloError")
    public String getOrder(Integer a, Integer b){
        return restTemplate.getForObject("http://customer-business-service/show?a="+a+"&b="+b, String.class);
    }
    public String helloError(Integer a, Integer b){
        return "error page. params:a="+a+", b="+b;
    }
}
```

## @EnableEurekaClient与@EnableDiscoveryClient区别

意思也就是spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。

