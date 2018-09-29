package com.yks.phoenix.service;

import com.yks.phoenix.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cgt on 17-12-7.
 */
@Service
public class CRUDServiceImp implements CRUDService {

    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate phoenixJdbcTemplate;
    public Result add(){

        phoenixJdbcTemplate.update("upsert into lbb.company(id,name,address) values('20','xuxiao','china')");

        return new Result(true,"数据添加成功");

    }

    public Result update(){
        int res = phoenixJdbcTemplate.update("upsert into lbb.company(id,name) values('20','yyggg')");
        return new Result(true,"数据更新成功");

    }

    public Result delete(){
        phoenixJdbcTemplate.update("delete from lbb.company where id ='20'");
        return new Result(true,"数据删除成功");

    }


    public List<Map<String, Object>> query(){
        return phoenixJdbcTemplate.queryForList("select * from lbb.company");

    }
}
