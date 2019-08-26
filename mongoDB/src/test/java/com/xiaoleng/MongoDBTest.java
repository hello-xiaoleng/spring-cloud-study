package com.xiaoleng;


import com.xiaoleng.mongoDB.config.MallMongoConfig;
import com.xiaoleng.mongoDB.domain.Student;
import com.xiaoleng.mongoDB.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MallMongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void insertTest() {
        Student student = Student.builder()
                .name("chenjia")
                .age(12)
                .height(new BigDecimal("165.05"))
                .weight(new BigDecimal("120.04"))
                .build();
        mongoTemplate.insert(student);

        Teacher teacher = new Teacher();

        teacher.setJob("化学");

        teacher.setName("lison 老师");

        teacher.setAge(40);

        mongoTemplate.insert(teacher);
    }


    @Test
    public void batchInsertTest() {
        Student student = Student.builder()
                .name("chenjia")
                .age(12)
                .height(new BigDecimal("165.05"))
                .weight(new BigDecimal("120.04"))
                .build();

        Teacher teacher = new Teacher();

        teacher.setJob("化学");

        teacher.setName("lison 老师");

        teacher.setAge(100);

        List<Object> list = new ArrayList<>();
        list.add(student);
        list.add(teacher);

        mongoTemplate.insertAll(list);
    }

    @Test
    public void queryTest() {
        List<Student> allStudent = mongoTemplate.findAll(Student.class);
        allStudent.forEach(System.out::println); }

}
