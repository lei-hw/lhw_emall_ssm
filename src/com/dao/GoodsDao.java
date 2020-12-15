package com.dao;

import com.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsDao {

    @Select("select  count(*) from goods")
    public  int selectCount();

    @Select("select count(*) from goods where type_id=#{typeId}")
    public  int selectCountByTypeId(@Param("typeId")int typeId);

    @Select("select count(*) from goods g join tops t on g.id=t.good_id where t.type=#{type}")
    public int selectCountByTopType(@Param("type")byte type);

    @Select("select count(*) from goods where name like concat('%',#{name},'%')")
    public int selectCountByName(@Param("name")String name);

    @Select("select * from goods order by id desc limit #{begin}, #{size}")
    public List<Goods> selectList(@Param("begin")int begin,@Param("size")int size);

    @Select("select * from goods order by sales desc limit #{begin}, #{size}")
    public List<Goods> selectListOrderSales(@Param("begin")int begin,@Param("size")int size);

    @Select("select * from goods order by systime desc limit #{begin}, #{size}")
    public List<Goods> selectListOrderTime(@Param("begin")int begin,@Param("size")int size);

    @Select("select *from goods where type_id=#{typeid} order by id desc limit #{begin},#{size}")
    public List<Goods>selectListByTypeId(@Param("typeid")int typeid,
                                         @Param("begin")int begin ,
                                         @Param("size")int  size);

    @Select("select * from goods where id=#{id}")
    public Goods select(int id);

    @Select("select * from goods g join tops t on g.id=t.good_id where t.type=#{type} " +
            "order by t.id desc limit #{begin}, #{size}")
    public List<Goods> selectListByTopType (@Param("type")byte type, @Param("begin")int begin, @Param("size")int size);

    @Update("update goods set stock=stock-#{stock} where id=#{id}")
    public boolean updateStock(@Param("id")int id, @Param("stock") int stock);

    @Update("update goods set sales=sales+#{sales} where id=#{id}")
    public boolean updateSales(@Param("id")int id, @Param("sales") int sales);
}
