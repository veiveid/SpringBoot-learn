package com.veiveid.SpringBootlearn.user;

import com.veiveid.SpringBootlearn.user.dao.UserRepository;
import com.veiveid.SpringBootlearn.user.model.User;
import com.veiveid.SpringBootlearn.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private UserService userSerivce;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        User u = userRepository.findByName("a");
        System.out.println(u);
    }




    @Test
    public void add() throws Exception {
        // 插入5个用户
        userSerivce.create("a", 1);
        userSerivce.create("b", 2);
        userSerivce.create("c", 3);
        userSerivce.create("d", 4);
        userSerivce.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers().intValue());
    }

    @Test
    public void testDel(){
        // 删除两个用户
        //userSerivce.deleteByName("d");

        System.out.println("==============================>");
        Assert.assertEquals(4, userSerivce.getAllUsers().intValue());
        System.out.println("----------------------->");
    }
}