package cn.sm1234.movie.controller;

import cn.sm1234.movie.client.UserController;
import cn.sm1234.movie.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/movie")
@RestController
@Api(description = "電影核心Api")
public class MovieController {

    //    @Resource
//    private RestTemplate restTemplate;
//    @Resource
//    private DiscoveryClient discoveryClient;
    //    @Resource
//    private LoadBalancerClient loadBalancerClient;
    private static final Log log = LogFactory.getLog(MovieController.class);
    @Resource
    private UserController userController;

//    @RequestMapping(value = "/order", method = RequestMethod.POST)
//    public String order() {
//        Integer id = 2;
//
//        System.out.println("正在購票...");
//        User user = restTemplate.getForObject("http://localhost:9001/user/" + id, User.class);
//
//        return user.getUsername() + "購票成功";
//    }

//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order() {
//        Integer id = 2;
//
//        //到Eureka發現用戶微服務
//        //返回值為什麼是List集合呢？ 獲取到所有同名的微服務
//        List<ServiceInstance> instances = discoveryClient.getInstances("microservice-user");//參數: 需要發現的微服務名稱
//        //沒有使用負載平衡只能獲取第一個服務
//        ServiceInstance serviceInstance = instances.get(0);
//
//        System.out.println("正在購票...");
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
//
//        System.out.println(user + "正在購票...");
//
//        return "購票成功";
//    }

//    /**
//     * 購票方法(使用Ribbon附載均衡組件)
//     * @return
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    public String order() {
//        Integer id = 2;
//
//        //使用Ribbon幫助我們選擇一個合適的服務實例(默認算法:輪詢)
//        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-user");
//
//        System.out.println(serviceInstance.getPort());
//        System.out.println("正在購票...");
//        User user = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id, User.class);
//
//        System.out.println(user + "正在購票...");
//
//        return "購票成功";
//    }

//    /**
//     * 購票方法(使用Ribbon附載均衡組件)
//     */
//    @RequestMapping(value = "/order", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String order() {
//        Integer id = 2;
//
//        //使用Ribbon幫助我們選擇一個合適的服務實例(默認算法:輪詢)
//        User user = restTemplate.getForObject("http://microservice-user/user/" + id, User.class);
//
//        System.out.println(user + "正在購票...");
//
//        return "購票成功";
//    }

//    /**
//     * 熔斷回滾方法
//     */
//    public String fallback(){
//        return "服務暫時不可用, 發生熔斷...";
//    }

    /**
     * 購票方法(使用OpenFeign組件來簡化調用代碼)
     */
    @ApiOperation(value = "遠程方法: 根據用戶的ID查詢用戶的分法")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        log.info("開始調用order方法...");

        Integer id = 2;

        User user = userController.findById(id);
        System.out.println(user + "==正在購票...");
        return "購票成功";
    }
}
