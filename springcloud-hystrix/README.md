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