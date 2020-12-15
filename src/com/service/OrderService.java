package com.service;

import com.config.ExceptionConfig;
import com.dao.ItemsDao;
import com.dao.OrdersDao;
import com.entity.Carts;
import com.entity.Items;
import com.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 商品订单服务
 */
@Service
public class OrderService {
    @Autowired
    public OrdersDao ordersDao;
    @Autowired
    private ItemsDao itemDao;
    @Autowired
    private GoodService goodService;
    @Autowired
    private CartService cartService;
    @Autowired
    private USerService uSerService;

    /**
     * 获取某用户全部订单
     * @param userId
     * @param page
     * @param size
     * @return
     */
    public List<Orders> getListByUserid(int userId, int page, int size){
        return pack(ordersDao.selectListByUserid(userId,size*(page-1),size));
    }

    /**
     * 通过id获取
     * @param id
     * @return
     */
    public Orders get(int id){
        return pack(ordersDao.select(id));
    }

    /**
     * 封装
     * @param list
     * @return
     */
    private List<Orders> pack(List<Orders> list){
        if (Objects.nonNull(list) && !list.isEmpty()){
            for (Orders order : list){
                order = pack(order);
            }
        }
        return list;
    }

    /**
     * 保存订单
     * @param userId
     * @return
     * @throws ExceptionConfig.MyException
     */
    @Transactional
    public int save(int userId) throws ExceptionConfig.MyException{
        List<Carts> cartsList = cartService.getList(userId);
        if (Objects.isNull(cartsList) || cartsList.isEmpty()){
            throw new ExceptionConfig.MyException("购物车没有商品");
        }
        //验证库存
        for (Carts cart : cartsList){
            if (cart.getGood().getStock() < cart.getAmount()){//验证库存
                throw new ExceptionConfig.MyException("商品["+ cart.getGood().getName()+" ] 库存不足");
            }
            goodService.updateStock(cart.getGood().getId(), cart.getAmount());//减库存
            goodService.updateSales(cart.getGood().getId(), cart.getAmount());//加销量
        }
        int total = 0; //订单总价
        for (Carts cart : cartsList){
            total += cart.getGood().getPrice() * cart.getAmount();
        }
        Orders order = new Orders();
        order.setUserId(userId);
        order.setTotal(total);
        order.setAmount(cartsList.size());
        order.setStatus(Orders.STATUS_UNPAY);
        order.setSystime(new Date());
        ordersDao.insert(order);
        int orderId = order.getId();
        for (Carts cart : cartsList){
            Items item = new Items();
            item.setOrderId(orderId);
            item.setGoodId(cart.getGoodId());
            item.setPrice(cart.getGood().getPrice());
            item.setAmount(cart.getAmount());
            itemDao.insert(item);
        }
        //清空购物车
        cartService.clean(userId);
        return orderId;
    }
}
