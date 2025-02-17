package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;


class SuperClass{ // 상위 클래스 // 부모
    public  void  method1(){}
}

class Subclass extends SuperClass{ //하위클래스 //자식 // extends 보모클래스{}


    @Override // 부모 클래스로 부터 물려받은 메소드를 재정의(내부코드 수정) 한다. @어노테이션 // 부모 클래스를 재정의 한다는걸 알림
    public void method1() {
        super.method1();
    }// f end

    @Deprecated // 더이상 사용하지 않는 코드 임을 알림
    public void method2(){}

}// class end

//[1] 어노테이션 만들기
@Retention(RetentionPolicy.RUNTIME) //런타임까지 유지 한다는 뜻
@Target(ElementType.METHOD) // 해당 어노테이션은 메소드에만 적용 한다는 뜻
@interface  Annotation1{
    //추상메소드
    String value1();

}//i end


//[2] 어노테이션 사용하기
class TestClass{
    @Annotation1(value1 = "value1 값 저장") // 실행중에 주입
    public  void  method3(){
        // value1 이라는 값 사용할 수 있다.(내부적으로)
        //System.out.println(value1); // sout
        // 어노테이션은 동적으로 실행되기때문에 콘솔로는 확인할 수 없다.


    }
    
}//c end



public class Example1 {
    public static void main(String[] args) { //
        Subclass subclass = new Subclass();
        // 기본 어노테이션 사용
        subclass.method1(); // 오버라이딩된 메소드
        subclass.method2(); // 비권장(더이상 사용하지 않는) 메소드
        // [3] 리플렉션 된 클래스 정보 확인
        try {
            Method method = TestClass.class.getMethod("method3");
            Annotation1 annotation1 = method.getAnnotation(Annotation1.class);
            System.out.println(annotation1.value1());
        }catch (Exception e){
            System.out.println(e);
        }
    }// main end
}//class end



/*
    [1] 인텔리제이 자동완성 (대소문자 구별)
        1. 자동완성 할 문자 몇개 입력하면 자동으로 아래에 여러가지 추천 코드가 나온다
        2. 본인이 자동 완성 할 코드를 키모드 방향키로 이동후 [엔터]
    [2] TabNine 플러그인 자동완성(한글지원 x)
        1. 코드 작성후 tap 치면 자동으로 완성

 */