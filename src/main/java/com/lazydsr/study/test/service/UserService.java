package com.lazydsr.study.test.service;

import com.github.pagehelper.Page;
import com.lazydsr.study.test.common.Response;
import com.lazydsr.study.test.entity.User;

import java.util.List;

/**
 * @author daisenrong
 */
public interface UserService {

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    public User get(Integer id);

    /**
     * 用户list
     *
     * @param ids id集合
     * @return 用户list
     */
    public List<User> list(List<Integer> ids);

    /**
     * 分页查询
     *
     * @param pageSize 分页大小
     * @param pageNum  当前页
     * @return 分页数据
     */
    public Response<List<User>> page(Integer pageSize, Integer pageNum);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 用户
     */
    public User add(User user);

    /**
     * 更新用户 根据主键id
     *
     * @param user 用户
     * @return 更新行数
     */
    public Integer update(User user);
}
