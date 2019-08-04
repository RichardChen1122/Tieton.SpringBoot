package com.siemens.kpiscriptengine.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {

    @Around("execution(public com.siemens.kpiscriptengine.utils.JsonResult com..*.controller..*.*(..))")
    public JsonResult handleControllerMethod(ProceedingJoinPoint pjp) {
        JsonResult result;
        try {
            System.out.println("执行Controller开始: " + pjp.getSignature() + " 参数：" + pjp.getArgs().toString());
            result = (JsonResult) pjp.proceed(pjp.getArgs());
            System.out.println("执行Controller结束: " + pjp.getSignature() + "， 返回值：" + result.toString());
        } catch (Throwable throwable) {
            result = handlerException(pjp, throwable);
        }

        return result;
    }

    private JsonResult handlerException(ProceedingJoinPoint pjp, Throwable e) {
        JsonResult result = null;
        if (e instanceof RuntimeException) {
            System.out.println("RuntimeException{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常："
                    + e.getMessage() + "}" + e.getMessage());
            result = JsonResult.buildError(e.getMessage());
        } else {
            System.out.println("异常{方法：" + pjp.getSignature() + "， 参数：" + pjp.getArgs() + ",异常：" + e.getMessage() + "}"
                    + e.getMessage());
            result = JsonResult.buildError(e.getMessage());
        }

        return result;
    }
}
