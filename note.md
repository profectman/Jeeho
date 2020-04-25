一.数据库连接池的配置 (eg: https://www.cnblogs.com/JavaSubin/p/5294721.html)
1.基本配置  driverClass  url   username   password
2.关键配置  middle(最小连接数)  initialSize(连接池初始化时建立的连接数量)
           maxActive(最大连接数量) maxWait(前提：当前来接数量达到最大连接数时(maxActive),等待连接的最大时间)
3.性能配置
          预缓存配置  (单个连接connection中预加载游标(preparedstatements)的数量) poolpreparedStatement(开启缓存功能) maxOpenPreparedStatements(单个连接拥有的最大连接的数量)
          连接有效性检测设置 testOnBorrow(申请连接检测) testOnReturn(归还连接检测) --->开启影响性能  testWhileIdle(断网导致的连接失效检测)
          超时关闭连接 removeAbandoned(开启超时连接关闭)  removeAbandonedTimeOut(超时连接关闭时间)  logAbandoned(是否记录日志)



二.spring-test 测试框架：


三.加密算法 ：

    场景：

    1.BASE64

    2.对称加密

    3.非对称加密

    4.信息摘要加密

四.Spring MVC 注``解配置

    spring MVC理解图：
      
      ....

    1.请求参数绑定注解
        <1>.目录：
                @Controller 
                处理request body 部分的注解： @RequestParam  @RequestBody
                处理requesy uri  部分的注解:  @PathVariable
                处理request head 部分的注解： @RequestHeader @CookieValue
                处理Attribute    部分的注解： @SessionAttributes @ModelAttributes
                
        <2>.ModelAttribute的使用  & @SessionAttribute
            1.注解在void 方法上  2.注解在带有返回值类型的方法上  (在具体的请求映射方法上可以model  )
            3.可以在BaseController中使用ModelAttributes 继承了该类的方法都将调用此方法  (类似与拦截器Intecepter)
            
        <3>.@RequestHeader的使用(5种使用情况，返回值存放在requestScope中,${requestScope.xxx})
            @RequestHeader(value = "User-Agent") String userAgent
            @RequestHeader(value = "Accept") String[] accpet
            
        <4>.@CookieValue的使用
            @CookieValue(value = "JESSIONID" ,defaultValue = "") String sessionId  (当前会话得ID)
    2.信息转换
        <1>.HttpMessageConverter接口
            HandlerAdapter --->  RequestMappingHandlerAdapter ---> HttpMessageConverter --->  一系列信息转换器
            <mvc:annotation-driven/>   ----->RequestMappingHandlerAdapter
            <mvc:default-servlet-handler/> ----->  (使用默认得Servlet来响应静态资源文件)
        <2>.配置使用自定义JSON格式转换JAR驱动fastJson  
               <mvc:annotation-driven>    
                    <mvc:message-converter register-defaults="false">
                            <bean id="fastJson.....">           【配置alibaba的fastJson转换接口】
                                <property id="supportMediaTypes">
                                    <list>
                                        <value>text/html;charset=UTF-8</value>
                                        <value>application/json;charset=UTF-8</value>
                                    </list>
                                </property>
                            </bean>
                    </mvc:message-converter>
               </mvc:annotation-driven>
               
               publuc void getJson( @RequestBody Book book){   ----->将对应得Book类型得JSON数据转换为 Book类型得数据
                     response.setContextType("text/html;charset=UTF-8");
                     response.getWriter.println(JSONObject.toJSONString("book"));
               }       
        
    3.数据绑定，转换，格式化，数据校验
      <1>.在Spring MVC中，请求消息到达正真的处理方法的过程中----> 信息转换，数据转换，数据格式化，数据校验等一系列操作。
      <2>.Spring MVC中数据转换  ---->RequestMappingHandlerAdapter -----> conversionServiceFactoryBean ------> T extends converter
      <3>.spring mvc数据格式化  ---->RequestMappingHandlerAdapter -----> FormattingConvrionServiceFactoryBean --> Formatter
      <4>.spring mvc数据校验 --> 自定义数据校验注解标签
      
    4.spring 文件的上传 ----- 下载
        
    5.spring mvc 静态资源文件处理: (https://blog.coding.net/blog/spring-static-resource-process)
      <1>.使用<mvc:default-servlet-handler/>  将原本的需Dispatch请求交给默认的Servlet处理资源文件的获取
      <2>.使用<mvc:resources localtion="/static/**" mapping="/static/" /> 将资源文件的由Spring mvc自己处理  localtion 源文件地址  mapping 映射之后的请求路径
        
五.Mybatis使用整合

    

六.Spring Aop使用

七.Redis使用
    spring整合redis数据库作为缓存
      