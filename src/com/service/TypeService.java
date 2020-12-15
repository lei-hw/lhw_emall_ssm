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

    @Autowired//自动获取
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

    /**
     * 添加
     * @param type
     * @return
     */
    public boolean add(Types type){ return typesDao.insert(type);}
}
