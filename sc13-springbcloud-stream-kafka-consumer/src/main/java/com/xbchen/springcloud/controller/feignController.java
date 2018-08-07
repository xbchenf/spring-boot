package com.xbchen.springcloud.controller;


import com.xbchen.springcloud.feign.UserFeignClient;
import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.service.IUserService;
import com.xbchen.springcloud.utils.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
@RestController
@RequestMapping("/feign")
public class feignController {

    @Autowired
    UserFeignClient userFeignClient;

    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/query/{id}")
    public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            ResponseEntity<JsonResult> result = userFeignClient.getUserById(id);
            return result;
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping("/query/userList")
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult r = new JsonResult();
        try {
            ResponseEntity<JsonResult> result = userFeignClient.getUserList();
            return result;
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping("/add")
    public ResponseEntity<JsonResult> addUser(User user) {
        JsonResult r = new JsonResult();
        try {
            ResponseEntity<JsonResult> result = userFeignClient.addUser(user);
            return result;
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @PostMapping("/delete/{id}")
    public ResponseEntity<JsonResult> deleteUser(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            ResponseEntity<JsonResult> result = userFeignClient.deleteUser(id);
            return result;
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value="更新信息", notes="更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    @PostMapping("/update")
    public ResponseEntity<JsonResult> updateUser(/*@RequestBody */User user) {
        JsonResult r = new JsonResult();
        try {
            ResponseEntity<JsonResult> result = userFeignClient.updateUser(user);
            return result;
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
