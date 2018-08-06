package com.xbchen.springcloud.feign;

import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.utils.JsonResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "springcloud-service-provider1")
public interface UserFeignClient {

  @GetMapping("/user/query/{id}")
  public ResponseEntity<JsonResult> getUserById(@PathVariable(value = "id") Integer id);

  @GetMapping("/user/query/userList")
  public ResponseEntity<JsonResult> getUserList();

  @PostMapping("/user/add")
  public ResponseEntity<JsonResult> addUser(User user);

  @PostMapping("/user/delete/{id}")
  public ResponseEntity<JsonResult> deleteUser(@PathVariable(value = "id") Integer id);

  @PostMapping("/user/update")
  public ResponseEntity<JsonResult> updateUser(/*@RequestBody */User user);
}
