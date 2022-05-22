package cn.sm1234.user.service;

import cn.sm1234.user.dao.UserDao;
import cn.sm1234.user.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    public void add(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
}
