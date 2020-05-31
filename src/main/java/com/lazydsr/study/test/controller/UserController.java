package com.lazydsr.study.test.controller;

import com.github.pagehelper.Page;
import com.lazydsr.study.test.common.Response;
import com.lazydsr.study.test.common.ResponseUtils;
import com.lazydsr.study.test.entity.User;
import com.lazydsr.study.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户 controller", description = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    @ApiOperation("获取用户")
    public Response get(Integer id) {
        return ResponseUtils.success(userService.get(id));
    }

    @GetMapping("list")
    @ApiOperation("用户list")
    public Response<List<User>> list(List<Integer> ids) {
        return ResponseUtils.success(userService.list(ids));
    }

    @GetMapping("page")
    @ApiOperation("分页查询")
    public Response<List<User>> page(@RequestParam(defaultValue = "100") Integer pageSize, @RequestParam(defaultValue = "1") Integer pageNum) {
        return userService.page(pageSize, pageNum);
    }

    @PostMapping("add")
    @ApiOperation("添加用户")
    public Response<User> add(@RequestBody User user) {
        return ResponseUtils.success(userService.add(user));
    }

    @PostMapping("update")
    @ApiOperation("更新用户")
    public Response<Integer> update(@RequestBody User user) {
        return ResponseUtils.success(userService.update(user));
    }
}
