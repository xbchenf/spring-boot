# spring-cloud

spring boot /spring cloud项目实战 之 springbcloud-springsession-redis

springbcloud 整合springsession 和 redis


1.实现session共享

样例：UserController
public Map<String, Object> firstResp (HttpServletRequest request){
    Map<String, Object> map = new HashMap<>();
    request.getSession().setAttribute("request Url", request.getRequestURL());
    map.put("request Url", request.getRequestURL());
    request.getSession().setAttribute("userId", request.getParameter("userId"));
    map.put("userId", request.getParameter("userId"));
    return map;
}
public Object sessions (HttpServletRequest request){
    Map<String, Object> map = new HashMap<>();
    map.put("sessionId", request.getSession().getId());
    map.put("userId", request.getSession().getAttribute("userId"));
    return map;
}

2.实现缓存共享

样例：UserServiceImpl
@Cacheable(cacheNames="user", key="#id")
@Override
public User getUserById(Integer id){
	
3.redis缓存客户端手工操作
样例：RedisServiceTest
redisService.set("key1", "springboot redis test");
redisService.get("key1");


4.本demo涉及的相关技术、框架：
1>.springboot
2>.springmvc
3>.mybatis
4>.druid
5>.junit
6>.swagger2
7>.springcloud
8>.feign
9>.springsession
10>.redis