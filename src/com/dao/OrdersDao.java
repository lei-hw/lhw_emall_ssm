package com.dao;

import com.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface OrdersDao {

    @Select("select * from orders where id=#{id}")
    public Orders select(int id);

    @Insert("insert into orders (total,amount,status,paytype,name,phone,address,systime,user_id) " +
            "values (#{total},#{amount},#{status},#{paytpe},#{name},#{phone},#{address},now(),#{userId})")
    @SelectKey(keyProperty = "id", statement = "SELECT LAST_INSERT_ID()", before = false, resultType = Integer.class)
    public boolean insert(Orders order);

    @Update("update orders set status=#{status},paytype=#{paytype}, " +
            "name=#{name},phone=#{phone},address=#{address} where id=#{id}")
    public boolean update(Orders order);
}
