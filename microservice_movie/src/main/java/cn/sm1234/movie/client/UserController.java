package cn.sm1234.movie.client;

import cn.sm1234.movie.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用戶微服務遠程接口
 * 三個注意事項
 * 1.使用FeignClient
 * 2.檢查@RequestMapping註解, value值(路徑)是否完整
 * 3.@PathVariable註解的value不能省略的
 */
@FeignClient(value = "microservice-user", fallback = UserControllerImpl.class)
public interface UserController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable(value = "id") Integer id);
}
