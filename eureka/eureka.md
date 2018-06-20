一. eureka程序构成【eureka-server注册中心，eureka-client服务注册】
1. 是纯正的 servlet 应用，需构建成war包部署 
2. 使用了 Jersey 框架实现自身的 RESTful HTTP接口 
3. peer之间的同步与服务的注册全部通过 HTTP 协议实现 
4. 定时任务(发送心跳、定时清理过期服务、节点同步等)通过 JDK 自带的 Timer 实现 
5. 内存缓存使用Google的guava包实现

二.
1.客户端向注册中心注册的实例是在内存中完成的，没有后端缓存
2.client端启动会向eureka注册中心立马注册一次，客户端每30s向注册中心发送一次心跳保持长连接，如果心跳超时（90s），则把该实例从注册中心中移除掉。
3.client端从eureka注册中心发现服务的时候，Eureka Client对已经获取到的注册信息也做了30s缓存。即服务通过eureka客户端第一次查询到可用服务地址后会将结果缓存，下次再调用时就不会真正向Eureka发起HTTP请求了。
4.eureka自我保护机制
Eureka还有一种自我保护机制，如果在15分钟内超过85%的节点都没有正常的心跳，那么Eureka就认为客户端与注册中心出现了网络故障，此时会出现以下几种情况： 
1）. Eureka不再从注册列表中移除因为长时间没收到心跳而应该过期的服务 
2）. Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可用) 
3）. 当网络稳定时，当前实例新的注册信息会被同步到其它节点中
5.spring cloud服务发现注解之@EnableDiscoveryClient与@EnableEurekaClient
  spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
  其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。

三.eureka高可用 集群
1.eureka服务端部署多台，需要两两之间互相注册
2.eureka客户端需要向所有的服务端进行注册
