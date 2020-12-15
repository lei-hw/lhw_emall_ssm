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
    public long getCount() {return usersDao.selectCount();}

    /**
     *添加
     */
    public boolean add(Users user){
        user.setPassword(SafeUtil.encode(user.getPassword()));
        return usersDao.insert(user);
    }

    /**
     * 通过id获取
     * @param id
     * @return
     */
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

    /**
     * 更新
     * @param id
     * @param password
     * @return
     */
    public boolean updatePassword(int id, String password){
        return usersDao.updatePassword(id,SafeUtil.encode(password));
    }

    /**
     * 更新
     * @param id
     * @param name
     * @param phone
     * @param address
     * @return
     */
    public boolean up (int id, String name, String phone, String address){
        Users user = new Users();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        return usersDao.update(user);
    }
}
