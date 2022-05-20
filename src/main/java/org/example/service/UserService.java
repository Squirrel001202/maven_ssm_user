package org.example.service;

import org.example.pojo.User;

import java.util.List;

public interface UserService {
    /*url
     *  /user/selectUserPage?userName=z&userSex=男&page=null*/
    List<User> selectUserPage(String userName, String userSex, int startRow);
    /*url
        /user/createUser*/
    int createUser(User user);
    /*
    * /user/deleteUserById?userId= 15968162087363060
    */
    int deleteUserById(String userId);
    /*
    url	/user/getRowCount?userName=z&userSex=男
    */
    int getRowCount(String userName,String userSex);
    /*
    url	/user/updateUserById
    */
    int updateUserById(User user);

    int deleteUserByIdList(List<String> userIdList);
}
