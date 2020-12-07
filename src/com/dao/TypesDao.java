package com.dao;

import com.entity.Types;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TypesDao {

    @Select("select * from types order by num")
    public List<Types> selectList();

    @Select("select * from types where id=#{id}")
    public Types select(int id);

    @Insert("insert into types (name,num) values (#{name},#{num})")
    @SelectKey(keyProperty = "id", statement = "SELECT LAST_INSERT_ID()",before = false, resultType = Integer.class)
    public boolean insert(Types types);

    @Update("update types set name=#{name},num=#{num} where id=#{id}")
    public boolean update(Types types);
}
