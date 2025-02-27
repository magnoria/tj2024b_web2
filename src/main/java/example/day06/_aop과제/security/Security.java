package example.day06._aop과제.security;


import example.day06._aop과제.controller.StudentController;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

import java.util.HashMap;



    // 내가 처음 만든것 처음에 너무 상세하게 생각했고 그다음은 controller를 중심으로 적용했음


@Aspect
@Component
public class Security {
/*
    @Before("execution( * example.day06._aop과제.controller.StudentController.*(..)) && args(param)" )
    public void security(Object param){
        System.out.println("메소드 실행전 : StudentController.save");
        System.out.println("매개변수 = " + param);



    }

    @AfterReturning(value = "execution( * example.day06._aop과제.controller.StudentController.*(..))", returning = "result")
    public  void  security2(Object result){
        System.out.println("메소드 실행후 확인");
        System.out.println("result = " + result);

    }


    @Around("execution( * example.day06._aop과제.controller.StudentController.*(..))")
    public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable{


        System.out.println(joinPoint.getArgs()); // 지정한 메소드의 매개변수 반환 (배열타입)
        System.out.println(joinPoint.getSignature()); // 지정한 메소드의 시그니처 (실행된 메소드이 리턴타입 , 함수명 ,매개변수 반환)
        System.out.println( joinPoint.getTarget()); // 지정한 메소드를 실행한 객체(StudentController 객체)
        System.out.println(joinPoint.getThis()); // 지정한 메소드를 실행한 객체(StudentController 객체)




        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();
        System.out.println("결과 확인 :" + result);

        long endTime = System.currentTimeMillis();

        long timeMs = endTime - startTime;

        System.out.println("save 메소드가 실행에 걸린시간 :" + timeMs + "ms");

        return result;

    }





*/




}




