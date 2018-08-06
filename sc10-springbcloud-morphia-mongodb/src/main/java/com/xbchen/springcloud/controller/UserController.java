package com.xbchen.springcloud.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.mongodb.dao.UserMongodbDao;
import com.xbchen.springcloud.service.IUserService;
import com.xbchen.springcloud.utils.JsonResult;
import com.xbchen.springcloud.utils.JsonUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xbchen on 2018/06/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @ApiOperation(value="设置session", notes="用于session共享测试")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/session1")
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();

        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());

        request.getSession().setAttribute("userId", request.getParameter("userId"));
        map.put("userId", request.getParameter("userId"));
        return map;
    }

    @ApiOperation(value="读取session", notes="用于session共享测试")
    @GetMapping("/session2")
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("userId", request.getSession().getAttribute("userId"));
        return map;
    }
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
        logger.info("服务消费者1：UserController>>getUserById>>id:"+id);
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
            logger.info("服务消费者1：UserController>>getUserList:"+ JsonUtil.obj2String(user));
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            // e.printStackTrace();
            logger.error("error:"+e.getMessage());
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
        logger.info("服务消费者1：UserController>>getUserList");
        JsonResult r = new JsonResult();
        try {
            List<User> userList = userService.getUserList();
            r.setResult(userList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            //e.printStackTrace();
            logger.error("error:"+e.getMessage());
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
            userService.addUser(user);
            r.setResult(user.getId());
            r.setStatus("ok");
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
            userService.deleteUser(id);
            r.setResult(id);
            r.setStatus("ok");
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
            userService.updateUser(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 修改用户信息-- 测试事务
     * @param user
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PostMapping("/update2/{id}")
    public ResponseEntity<JsonResult> updateUser2(@PathVariable(value = "id") Integer id,User user) {
        JsonResult r = new JsonResult();
        try {
            userService.updateUser2(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
}
