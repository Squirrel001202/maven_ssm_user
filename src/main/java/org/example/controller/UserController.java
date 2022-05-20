package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //在服务器端支持跨域访问
@RestController // 如果本类中全部都是ajax请求，则使用此注解，方法上的ResponseBody可以不写
@RequestMapping("/user")
public class UserController {

    public static final int PAGE_SIZE = 5;
    //一定会有业务逻辑层的对象
    @Autowired
    UserService userService;

    /*
     *   /user/selectUserPage?userName=z&userSex=男&page=null
     * */
    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName, String userSex, Integer page){
        //根据页码计算起始行
        int startRow = 0;
        if(page != null){
            startRow = (page - 1) * PAGE_SIZE;
        }
        return userService.selectUserPage(userName,userSex,startRow);
    }

    /*
    *  url  /user/getRowCount?userName=z&userSex=男
    */
    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName,userSex);
    }

    /*
     *   /user/deleteUserById?userId= 15968162087363060
     */
    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    /*
        /user/createUser
    */
    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis() + "";
        user.setUserId(userId);
        return userService.createUser(user);
    }

    /*
    url	/user/updateUserById
    */
    @RequestMapping("/updateUserById")
    public int updateUserById(User user){
        return userService.updateUserById(user);
    }
    @RequestMapping("/deleteUserByIdList")
    public int deleteUserByIdList(String userIdList){
        String[] userIds = userIdList.split(",");
        List<String> userIdList1 = new ArrayList<>();
        for (int i = 0; i < userIds.length; i++) {
            userIdList1.add(userIds[i]);
        }
        return userService.deleteUserByIdList(userIdList1);
    }
}
