package com.service;

import com.dao.GoodsDao;
import com.entity.Goods;
import com.entity.Tops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 商品服务
 */
@Service
public class GoodService {
    @Autowired
    private GoodsDao goodDao;//商品服务
    @Autowired
    private TopService topService;//今日推荐
    @Autowired
    private TypeService typeService;//类型

    public int getCount(){
        return goodDao.selectCount();
    }

    public long getCounByType(int typeId){
        return typeId > 0 ? goodDao.selectCountByTypeId(typeId) : this.getCount();
    }

    /**
     * 获取数量
     * @param type
     * @return
     */
    public long getCountByTopType(byte type){
        return goodDao.selectCountByTopType(type);
    }

    /**
     * 通过分类搜索
     * @param typeId
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByType(int typeId,int page,int size){
        return typeId >0 ? packGood(goodDao.selectListByTypeId(typeId,size * (page-1),size)) : null;//this.getList(page,size);
    }

    /**
     * 通过推荐搜索
     * @param type
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByTopType(byte type,int page,int size){
        return packGood(goodDao.selectListByTypeId(type,size * (page-1), size));
    }

    /**
     * 通过id获取
     * @param id
     * @return
     */
    public Goods get(int id){
        return packGood(goodDao.select(id));
    }

    /**
     * 添加
     * @param good
     * @return
     */
//    public boolean add(Goods good){ return  goodDao.insert(good);}

    /**
     * 获取新品上市列表
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getList(int page, int size){
        return packGood(goodDao.selectList(size * (page-1),size));
    }

    /**
     * 获取热销排行列表
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListOrderSales(int page,int size){
        return packGood(goodDao.selectListOrderSales(size * (page-1),size));
    }

    /**
     * 封装商品
     * @param list
     * @return
     */
    private List<Goods> packGood(List<Goods> list){
        for (Goods good : list){
            good = packGood(good);
        }
        return list;
    }

    /**
     * 封装商品
     * @param good
     * @return
     */
    private Goods packGood(Goods good){
        if(good != null){
            good.setType(typeService.get(good.getTypeId()));//类目信息
            good.setTop(Objects.nonNull(topService.getByGoodIdAndType(good.getId(), Tops.TYPE_TODAY)));
        }
        return good;
    }

    /**
     * 修改库存
     * @param id
     * @param stock
     * @return
     */
    public boolean updateStock(int id, int stock){
        return goodDao.updateStock(id, stock);
    }

    /**
     * 修改销量
     * @param id
     * @param sales
     * @return
     */
    public boolean updateSales(int id, int sales){ return goodDao.updateSales(id, sales);}
}
