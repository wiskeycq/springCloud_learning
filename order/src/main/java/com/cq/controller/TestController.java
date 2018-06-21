package com.cq.controller;

import com.cq.client.ProductClient;
import com.sun.javafx.fxml.LoadListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 13:23
 * @Description:
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;
    /**
     * 使用restTemplate+ribbon调用服务,不需要在启动类加特殊注解
     */
    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //第一种方式(直接使用RestTemplate，url写死) 缺点：硬编码，服务器地址变更都需要修改很麻烦 2，如果产品服务部署多台这种就很难处理
    /*    RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8081/msg",String.class);*/

        //第二种方式(利用loadBalancerClient通过应用名获取url，然后再使用RestTemplate) 如果产品服务部署两台，这种默认的负载均衡策略是轮询RoundRobinRule 缺点：每次这么写太麻烦
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        log.info("请求的地址={}",url);
        String response = restTemplate.getForObject(url,String.class);

       //第三种方式(利用@LoadBalanced注解，可在restTemplate里使用应用的名字)，实质和第二种方式一样，只是比较简单
        //String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        log.info("返回的数据={}",response);
        return response;
    }

    /**
     * 使用fegin调用服务，这个需要再启动类上加上注解@EnableFeignClients
     */
    @GetMapping("/getProductMsg1")
    public String getProductMsg1() {
        String response = productClient.getProductMsg();
        log.info("feign返回的数据={}",response);
        return response;
    }
}
