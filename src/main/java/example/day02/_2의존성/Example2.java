package example.day02._2의존성;

/*
*  [고전적인 방법2 : 싱글톤 생성]
*   스프링 없이 객체(인스턴스)를 직접 생성하여 메소드를 사용한다.
*   -이유 프로그램내 인스턴스(객체)가 하나만 필요할때 사용한다.
* */

//[1] 서비스 클래스
class SampleService2{
    // 싱글톤 만들기
    private static SampleService2 instance =  new SampleService2();
    private SampleService2(){}
    public static SampleService2 getInstance(){return instance;}



}// c end

//[2] 컨트롤러 클래스

class SampleController2{
    SampleService2 sampleService2 = SampleService2.getInstance();
    void method(){
        System.out.println("SamleService2.method");
    }

}


public class Example2 {
}
