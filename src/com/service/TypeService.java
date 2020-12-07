package com.service;

import com.dao.TypesDao;
import com.entity.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 类型服务
 */
@Service
public class TypeService {

    @Autowired
    private TypesDao typesDao;

    /**
     * 获取列表
     */
   public List<Types> getList(){
       return typesDao.selectList();
   }

    /**
     * 通过id查询
     */
    public Types get(int id){
        return typesDao.select(id);
    }
}
