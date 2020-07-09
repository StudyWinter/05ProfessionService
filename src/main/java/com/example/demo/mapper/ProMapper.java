package com.example.demo.mapper;

import com.example.demo.model.Profession;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProMapper {
    //增删改查

    //查找一个用户
    @Select("select * from profession where proname=#{proname}")
    Profession getprofession(String proname);

    //查找所有用户
    @Select("select * from profession")
    List<Profession> getallprofession();

    //增加专业
    @Insert("insert into profession (pid,major,proname,code) values (#{pid},#{major},#{proname},#{code})")
    void addprofession(Integer pid,String major,String proname,String code);


    //删除专业
    @Delete("delete from profession where proname=#{proname}")
    void deleteprofession(String proname);

    //修改专业信息
    @Update("update profession set major=#{major},code=#{code} where proname=#{proname}")
    void updateprofession(String major,String proname,String code);

}
