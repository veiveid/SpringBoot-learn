package com.veiveid.SpringBootlearn.user;

import com.veiveid.SpringBootlearn.async.Task;
import com.veiveid.SpringBootlearn.user.dao.UserMapper;
import com.veiveid.SpringBootlearn.user.dao.UserRepository;
import com.veiveid.SpringBootlearn.user.model.User2;
import com.veiveid.SpringBootlearn.user.model.User;
import com.veiveid.SpringBootlearn.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private UserService userSerivce;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Task task;

    @Autowired
    private JavaMailSender mailSender;


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

    @Test
    public void testMyBatis(){
        /*User2 u = userMapper.findByName("a");
        System.out.println(u);
        int n = userMapper.insert("张某",88);
        System.out.println("n="+n);*/
        User2 u2 = new User2(100,"张某",26L);
        userMapper.update(u2);

    }

    @Test
    public void testAsync() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while(true){
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("85083023@qq.com");
        message.setTo("85083023@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

}