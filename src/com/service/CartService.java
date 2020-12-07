package com.service;

import com.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 购物车服务
 */
@Service
public class CartService {

    @Autowired
    private CartDao cartDao;
//    @Autowired
//    private GoodService goodService;

    /**
     * 获取购物车总数
     * @param userId
     * @return
     */
    public int getCount(int userId){
        return 0;
//        return cartDao.selectSumAmountByUserId(userId);
    }
}
