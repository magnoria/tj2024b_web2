package example.day02._2의존성;

/*
* [스프링 방법3 : IOC 와 DI]

* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//[1] 서비스 클래스
@Component // 1. 스프링 컨테이너(메모리)에 빈(인스턴스) 등록
    // bean : 스프링 컨테이너(메모리) 에서 관리하는 인스턴스/객체 , IOC
    // IOC (제어역전) : 개발자가 인스턴스(new) 생성하지 않고 스프링이 대신 생성/관리 해준다
class SampleService3 {

    void method() {
        System.out.println("SampleService3.method");
    }

}// f end
//[2] 컨트롤러 클래스
class sampleContoroller3 {

    @Autowired // 2. 스프링 컨테이너(메모리)에 등록된 빈(인스턴스) 주입한다. DI(dependency Injection)
    private sampleContoroller3 sampleContoroller3;
}// f end

public class Example3 {
}
