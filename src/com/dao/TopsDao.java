package com.dao;

import com.entity.Tops;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TopsDao {
    @Select("select good_id from tops where type=#{type}")
    public List<String> selectGoodIdsByType(byte type);

    @Select("select * from tops where good_id=#{goodId} and type=#{type}")
    public Tops selectByGoodIdAndType(@Param("goodId") int goodId, @Param("type")byte type);

    @Insert("insert into tops (type,good_id) values (#{type},#{goodId})")
    @SelectKey(keyProperty = "id",statement = "SELECT LAST_INSERT_ID()",
        before = false,resultType = Insert.class)
    public boolean insert(Tops top);

    @Update("delect from tops where id=#{id}")
    public boolean delete(int id);
}
