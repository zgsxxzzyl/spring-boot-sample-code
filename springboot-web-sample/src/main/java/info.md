* servlet 流程是短的，url传来之后，就对其进行处理，之后返回或转向到某一自己指定的页面。它主要用来在 业务处理之前进行控制.

* filter 流程是线性的， url传来之后，检查之后，可保持原来的流程继续向下执行，被下一个filter, servlet接收等，而servlet 处理之后，不会继续向下传递。filter功能可用来保持流程继续按照原来的方式进行下去，或者主导流程，而servlet的功能主要用来主导流程。filter可用来进行字符编码的过滤，检测用户是否登陆的过滤，禁止页面缓存等

* servlet,filter都是针对url之类的，而listener是针对对象的操作的，如session的创建，session.setAttribute的发生，在这样的事件发生时做一些事情。可用来进行：Spring整合Struts，为Struts的action注入属性，web应用定时任务的实现，在线人数的统计等；

* interceptor拦截器，类似于filter，不过在struts中配置，不是在web.xml,并且不是针对url的而是针对action的，当页面提交时，进行过滤操作；