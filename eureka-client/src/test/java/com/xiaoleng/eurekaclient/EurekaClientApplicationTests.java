package com.xiaoleng.eurekaclient;

import com.xiaoleng.eurekaclient.domain.entity.User;
import com.xiaoleng.eurekaclient.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class EurekaClientApplicationTests {

    @Autowired
    private UserService userService;

    private static final List<String> FIRST_NAMES = Arrays.asList("家", "和", "三", "四", "六", "大爷");

    private static final List<String> LAST_NAMES = Arrays.asList("陈", "赵", "张", "王", "孙", "周");

    private static final Random RANDOM = new Random(new Date().getTime());


    @Test
    public void contextLoads() {
        System.out.println(userService.getUserById(2));
    }

    @Test
    public void insertData() {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(this::batchInsert);
            threadList.add(thread);
        }
        threadList.forEach(Thread::start);
        threadList.forEach(e -> {
            try {
                e.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void batchInsert() {
        for (int i = 0; i < 1000000; i++) {
            int index = RANDOM.nextInt(5);
            User user = User.builder()
                    .name(LAST_NAMES.get(index) + FIRST_NAMES.get(index))
                    .age(20 + index)
                    .build();
            Optional<User> optionalUser = userService.insertUser(user);
            if (!optionalUser.isPresent()) {
                throw new RuntimeException("插入失败");
            }
        }
    }


    @Test
    public void loadAndLockUser() {
        userService.loadAndLock(12);
    }

}
