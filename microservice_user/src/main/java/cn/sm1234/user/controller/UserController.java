package cn.sm1234.user.controller;

import cn.sm1234.user.pojo.User;
import cn.sm1234.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/user")
@RestController
@Api(description = "用戶控制器")
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查詢所有用戶")
    public List<User> findAll() {
//        List<User> list = new ArrayList<>();
//        list.add(new User(1, "張三", "123456", "男", 1000.0));
//        list.add(new User(2, "李四", "123456", "女", 2000.0));
//        list.add(new User(3, "陳六", "123456", "男", 2500.0));

        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根據主鍵查詢用戶")
    public User findById(@PathVariable Integer id) {
        log.info("進入UserController的findById方法");

        System.out.println("2222");
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "添加用戶")
    public String add(@RequestBody User user) {
        userService.add(user);
        return "添加成功";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改用戶")
    public String update(@RequestBody User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @ApiOperation(value = "刪除用戶")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return "刪除成功";
    }
}
