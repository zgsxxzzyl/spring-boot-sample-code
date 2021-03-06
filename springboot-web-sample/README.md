* `@Controller`配合视图解析器InternalResourceViewResolver返回视图jsp、html
* `@RestController`相当于@ResponseBody ＋ @Controller返回是字符串或者json


# Listener

---

* HttpSessionListener(用来监控session的创建，销毁等)

* ServletRequestListener(用于监控servlet上下文request)

* ServletRequestAttributeListener(用于监控request中的attribute的操作)



---

# Filter

```
@Configuration
public class MyConfig {
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new Myfilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("Myfilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
```
```
@WebFilter(urlPatterns = "/*")
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        filterChain.doFilter(new XssHttpServletRequestWrapperNew((HttpServletRequest) servletRequest), servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

```

---

# Servlet
> * `< url-pattern>/</url-pattern>`  会匹配到/login这样的路径型url，不会匹配到模式为`*.jsp`这样的后缀型url
> * `< url-pattern>/*</url-pattern>` 会匹配所有url：路径型的和后缀型的url(包括`/login`,`*.jsp`,`*.js`和`*.html`等)

```
@WebServlet(urlPatterns = "/*")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service HttpServletRequest");
        super.service(req, resp);
    }
```

---

# Interceptor

```
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
```

```
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login/**");

    }
}
```

>*  `/*` 指文件夹下的所有文件（不包括子文件夹）
>* `/**` 指文件夹下的所有文件（包括子文件夹）



# 配置文件解析
*application.properties*文件内容：
```
com.dudu.name="嘟嘟MD"
com.dudu.want="祝大家鸡年大吉吧"
```

```
@RestController
public class UserController {

    @Value("${com.dudu.name}")
    private  String name;
    @Value("${com.dudu.want}")
    private  String want;

    @RequestMapping("/")
    public String hexo(){
        return name+","+want;
    }
}
```
