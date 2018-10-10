# MQ(Message Queue)

> [ActiveMQ RabbitMQ KafKa对比](https://blog.csdn.net/vtopqx/article/details/76382934)

# ActiveMQ

> 官网：[http://mq.activemq.apache.org/]()
>
> 相关文章 [https://www.e-learn.cn/content/java/487993]() 

* 调试 [http://127.0.0.1:8161/admin/](http://127.0.0.1:8161/admin/)

## 两种传递类型

* 点对点（point-to-point，简称PTP）Queue消息传递模型：一个生产者和一个消费者一一对应

* 发布/订阅（publish/subscribe，简称pub/sub）Topic消息传递模型：一个生产者产生消息并进行发送后，可以由多个消费者进行接收