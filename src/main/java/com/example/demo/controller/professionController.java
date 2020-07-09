package com.example.demo.controller;

import com.example.demo.mapper.ProMapper;
import com.example.demo.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class professionController {
    @Autowired
    private ProMapper proMapper;


    //得到一个用户
    @RequestMapping("/rest/getprofession")
    public Profession getprofession(String proname)
    {
        Profession profession = proMapper.getprofession(proname);
        return profession;
    }

    //查询所有用户
    @RequestMapping("/rest/getallprofession")
    public List<Profession> getallprofession()
    {
        List<Profession> list = proMapper.getallprofession();
        return list;
    }

    //添加用户，专业名称proname和code不能相同
    @RequestMapping("/rest/addprofession")
    public String addprofession(Integer pid,String major,String proname,String code)
    {
        Profession profession = proMapper.getprofession(proname);
        if(profession!=null)     //有该专业，不可用添加
        {
            return "fault";
        }
        else               //没有该专业，可以添加
        {
            proMapper.addprofession(pid,major,proname,code);
            return "add";
        }
    }

    //删除专业
    @RequestMapping("/rest/deleteprofession")
    public String deletefrofession(String proname)
    {
        Profession profession = proMapper.getprofession(proname);
        if(profession!=null)   //有该专业，可以删除
        {
            proMapper.deleteprofession(proname);
            return "delete";
        }
        else
        {
            return "fault";
        }
    }

    //修改专业信息
    @RequestMapping("/rest/updateprofession")
    public String updateprofession(String major,String proname,String code)
    {
        Profession profession = proMapper.getprofession(proname);
        if(profession!=null)    //有该专业，可以修改
        {
            proMapper.updateprofession( major, proname, code);
            return "update";
        }
        else
        {
            return "fault";
        }
    }


}
