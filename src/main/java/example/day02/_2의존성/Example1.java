package example.day02._2의존성;

/*
    스프링 없이 객체(인스턴스)를 직접 생성하여 메소드를 사용한다.
    - 단점 : 강한 결합으로 유지보수가 어려워진다.
*/

//[1] 서비스 클래스
class SampleService1{
    void  method(){
        System.out.println("SampleService1.method");//soutm


    }// f end

}// class end

//[2] 컨트롤러 클래스
class sampleContoroller1{
    // 컨트롤러에서 서비스 클래스의 메소드 호출, 고전적인 방법1 : 인스턴스 생성
    SampleService1 sampleService1 = new SampleService1();

    public void  method(){
        sampleService1.method(); //서브스 클래스의 메소드 호출
    }

}// class end

public class Example1 { }// class end


