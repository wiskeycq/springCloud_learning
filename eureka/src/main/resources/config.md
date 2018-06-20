#eureka.server.enable-self-preservation	# 设为false，关闭自我保护
#eureka.server.eviction-interval-timer-in-ms # 清理间隔（单位毫秒，默认是60*1000）
#eureka.client.healthcheck.enabled	# 开启健康检查（需要spring-boot-starter-actuator依赖）
#eureka.instance.lease-renewal-interval-in-seconds	# 续约更新时间间隔（默认30秒）
#eureka.instance.lease-expiration-duration-in-seconds # 续约到期时间（默认90秒）
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
    register-with-eureka: false #不显示自己到注册中心页面
  server:
    enable-self-preservation: false  #关闭eureka自我保护提示，线上不要关闭，只用于测试环境
    #eviction-interval-timer-in-ms: 60000  #清理无效节点的时间间隔，默认是60s
spring:
  application:
    name: eureka
server:
  port: 8761