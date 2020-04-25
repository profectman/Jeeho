package com.jeeho.common.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

/**
 * 切面类  在spring-context.xml配置切面注解
 * --- <aop:aspectj-autoproxy/> ---
 * 并需要在xml文件中进行配置
 */
@Aspect
public class TestAspectJ implements Ordered {

    /**
     * 切点通配符指定
     *  ---- com.common..*
     *  ---- com.common.aspectJTest+ 匹配所有实现了aspectJTest的所有方法
     * within(com.jeeho.common.service.BaseService.aspectJTestImpl) 指定aspectJTest下的所有方法
     * within(com.jeeho.common.service.BaseService.aspectJTestImpl+) 指定aspectJTest下以及子类下的所有方法
     */
    @Pointcut("execution(* com.jeeho.common.service.BaseService.aspectJTest(..))")
    public void myPointCut(){}

    /**
     * 通知器eg:
     * before
     * return
     * afterThrowing
     * afterReturning
     * around  --- ProceedingJoinPoint 执行目标函数  结果进行返回
     */
    @Before(value = "myPointCut()")
    public void before(){
        System.out.println("前置通知器(advice).....");
    }

    @After(value = "myPointCut()")
    public void after(){
        System.out.println("后置通知器(advice).....");
    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前.....");
        Object object = joinPoint.proceed();
        System.out.println("环绕通知后.....");
        return object;
    }

    /**
     * 实现Ordered接口 对同一个连接点中的多个切面进行优先级排序
     * 返回值越小  优先度越高.
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }


    /**
     * 切面需要加载 .......
     * 在xml配置文件中配置
     * <aop:config >
     *         <aop:pointcut id="pointcut" expression="execution(* com.jeeho.common.service.BaseService.aspectJTest(..))"/>
     *         <aop:aspect id="" ref="testAspectJ">
     *             <aop:around method="around" pointcut-ref="pointcut"/>
     *         </aop:aspect>
     * </aop:config>
     */
}
