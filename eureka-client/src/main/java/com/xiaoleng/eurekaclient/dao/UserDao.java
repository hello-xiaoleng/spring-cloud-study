package com.xiaoleng.eurekaclient.dao;

import com.xiaoleng.eurekaclient.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User> {


    /***
     * 锁用户
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    User loadAndLock(@Param("id") Integer id);

}
