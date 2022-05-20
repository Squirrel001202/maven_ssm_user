package org.example.test;

import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//启动Spring容器
@ContextConfiguration(locations = {"classpath:applicationContext_mapper.xml",
        "classpath:applicationContext_service.xml"})
public class MyTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage(null,null,5);
        list.forEach(System.out::println);
    }
    @Test
    public void testDeleteUserById(){
        int num = userService.deleteUserById("15968162087363060");
        System.out.println(num);
    }
    @Test
    public void testGetRowCount(){
        int rowCount = userService.getRowCount(null,"男");
        System.out.println(rowCount);
    }
    @Test
    public void testCreateUser(){
        int num = userService.createUser(new User("2313441234124231","身份证","543635234543534","范德萨","男","23","工人"));
        System.out.println(num);
    }
    @Test
    public void testUpdateUserById(){
        int num = userService.updateUserById(new User("1651840854451","身份证","543635234543534","范德萨","男","23","工人"));
    }
    @Test
    public void testDeleteUserByIdList(){
        List<String> userIdList = new ArrayList<>();
        userIdList.add("1651840854451");
        userIdList.add("15968953962316864");
        int num = userService.deleteUserByIdList(userIdList);
    }
}
