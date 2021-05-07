package com.ks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询数据库所有信息
    // 没有实体类,取数据库
    @GetMapping("/userlist")
    public List<Map<String, Object>> userlist(){
        String sql = "select * from user";
        List<Map<String, Object>> listMaps = jdbcTemplate.queryForList(sql);
        return listMaps;
    }

    // 新增
    @GetMapping("/addUser")
    public String addUser(){ // 不用传值,因为用了sql直接插入
        String sql = "insert into mybatis.user(id, name, pwd) values (4, '小明', '123456')";
        jdbcTemplate.update(sql);
        return "a";
    }
    // 修改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.user set name=?, pwd=?  where id=" + id;
        Object[] object = new Object[2];
        object[0] = "花2";
        object[1] = "2222222";
        jdbcTemplate.update(sql, object);
        return "c";
    }
    // 删除
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=" + id;
        jdbcTemplate.update(sql);

        // 预编译方式
        //String sql2 = "delete from mybatis.user where id=?";
        //jdbcTemplate.update(sql, id);  // int id , 是个object
        return "d";
    }



}
