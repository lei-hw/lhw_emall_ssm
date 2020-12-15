package com.service;

import com.dao.CartDao;
import com.entity.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 购物车服务
 */
@Service
public class CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private GoodService goodService;

    /**
     * 获取购物车总数
     * @param userId
     * @return
     */
    public int getCount(int userId){
        return cartDao.selectSumAmountByUserId(userId);
    }

    /**
     * 获取总金额
     * @param userId
     * @return
     */
    public int getTotal(int userId){
        int total = 0;
        List<Carts> cartsList = this.getList(userId);
        if(Objects.nonNull(cartsList) && ! cartsList.isEmpty()){
            for(Carts cart : cartsList){
                total += cart.getGood().getPrice() * cart.getAmount();
            }
        }
        return total;
    }

    /**
     * 获取购物车列表
     * @param userId
     * @return
     */
    public List<Carts> getList(int userId){
        return pack(cartDao.selectListByUserId(userId));
    }

    /**
     * 添加购物车
     * @param goodId
     * @param userId
     * @return
     */
    public boolean save(int goodId, int userId){
        Carts cart = cartDao.selectByUserIdAndGoodId(userId,goodId);
        if (Objects.nonNull(cart)){//如果存在记录 数量+1
            return cartDao.updateAmonut(cart.getId(),1);
        }
        cart = new Carts();
        cart.setGoodId(goodId);
        cart.setUserId(userId);
        cart.setAmount(1);//默认数量1
        return cartDao.insert(cart);
    }

    /**
     * 清空购物车
     * @param userId
     * @return
     */
    public boolean clean(Integer userId){
        return cartDao.deleteByUserId(userId);
    }

    /**
     * 封装
     * @param list
     * @return
     */
    private List<Carts> pack(List<Carts> list){
        for (Carts cart : list){
            cart = pack(cart);
        }
        return list;
    }

    private Carts pack(Carts cart){
        if(Objects.nonNull(cart)){
            cart.setGood(goodService.get(cart.getGoodId()));
            cart.setTotal(cart.getAmount() * cart.getGood().getPrice());
        }
        return cart;
    }
}
