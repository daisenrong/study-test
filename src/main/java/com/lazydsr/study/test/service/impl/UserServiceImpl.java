package com.lazydsr.study.test.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lazydsr.study.test.common.Response;
import com.lazydsr.study.test.common.ResponseUtils;
import com.lazydsr.study.test.dao.UserMapper;
import com.lazydsr.study.test.entity.User;
import com.lazydsr.study.test.entity.UserExample;
import com.lazydsr.study.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return 用户
     */
    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 用户list
     *
     * @param ids id集合
     * @return 用户list
     */
    @Override
    public List<User> list(List<Integer> ids) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        return userMapper.selectByExample(example);
    }

    /**
     * 分页查询
     *
     * @param pageSize 分页大小
     * @param pageNum  当前页
     * @return 分页数据
     */
    @Override
    public Response<List<User>> page(Integer pageSize, Integer pageNum) {
        UserExample example = new UserExample();
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        userMapper.selectByExample(example);
        Response<List<User>> response = ResponseUtils.success(page.getResult());
        response.setPageInfo(new Response.PageInfo(pageSize, pageNum, (int) page.getTotal()));
        return response;
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return 用户
     */
    @Override
    public User add(User user) {
        userMapper.insertSelective(user);
        return user;
    }

    /**
     * 更新用户 根据主键id
     *
     * @param user 用户
     * @return 更新行数
     */
    @Override
    public Integer update(User user) {
        if (Objects.isNull(user) || Objects.isNull(user.getId())) {
            throw new RuntimeException("userId is null");
        }
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
