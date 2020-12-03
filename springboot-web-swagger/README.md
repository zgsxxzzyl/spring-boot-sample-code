官方文档：https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

https://my.oschina.net/zzuqiang/blog/793606
https://www.cnblogs.com/paddix/p/8204916.html

@ApiOperation，整个接口属性配置：

　　　　value：接口说明，展示在接口列表。

　　　　notes：接口详细说明，展示在接口的详情页。

　　　　tags：接口的标签，相同标签的接口会在一个标签页下展示。

　　　　httpMethod：支持的HTTP的方法。

　　@ApiImplicitParams，@ApiImplicitParam的容器，可包含多个@ApiImplicitParam注解

　　@ApiImplicitParam，请求参数属性配置：

　　　　name：参数名称

　　　　value：参数说明

　　　　required：是否必须

　　　　dataType：数据类型　　

　　@ApiResponses，@ApiResponse容器，可以包含多个@ApiResponse注解

　　@ApiResponse，返回结果属性配置：

　　　　code：返回结果的编码。

　　　　message：返回结果的说明。

　　　　response：返回结果对应的类。　　　　