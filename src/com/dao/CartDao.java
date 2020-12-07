package com.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartDao {

    @Select("select count(*) from carts where user_id=#{userId}")
    int selectCountByUserId(@Param("userId")int userId);

    @Select("select ifnull(sum(amount),0) from carts user_id=#{userId}")
    int selectSumAmountByUserId(@Param("userId")int userId);

//    @Select("select * form carts where user_id=#{userId}")
//    List<Carts> selectListByUserId(@Param("userId")int userId);
//
//    @Select("select * from carts where id=#{id}")
//    Carts select(@Param("id") int id);
}
