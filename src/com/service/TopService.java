package com.service;

import com.dao.TopsDao;
import com.entity.Tops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品推荐服务
 */
@Service
public class TopService {
    @Autowired
    private TopsDao topDao;
    /**
     * 通过商品ID和类型获取
     * @param goodId
     * @param type
     * @return
     */
    public Tops getByGoodIdAndType(int goodId, byte type){
        return topDao.selectByGoodIdAndType(goodId,type);
    }
}
