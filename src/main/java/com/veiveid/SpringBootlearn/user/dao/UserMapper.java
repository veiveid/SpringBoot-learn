package com.veiveid.SpringBootlearn.user.dao;

import com.veiveid.SpringBootlearn.user.model.User2;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User2 findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User2 user2);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}