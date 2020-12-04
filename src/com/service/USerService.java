package com.service;

import com.dao.UsersDao;
import com.entity.Users;
import com.util.SafeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 */
@Service
public class USerService {
    @Autowired
    private UsersDao usersDao;

    /**
     * 总数
     */
//    public long getCount() {return usersDao.selectCount();}

    /**
     *添加
     */
    public boolean add(Users user){
        user.setPassword(SafeUtil.encode(user.getPassword()));
        return usersDao.insert(user);
    }

    public Users get(int id) {return  usersDao.select(id);}

    /**
     * 通过用户名获取
     */
    public Users getByUsername(String username){
        return usersDao.selectByUsername(username);
    }

    /**
     * 通过用户名和密码获取
     */
    public Users getByUsernameAndPassword(String username, String password){
        return usersDao.selectByUsernameAndPassword(username, SafeUtil.encode(password));
    }
}
