package example.day08.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스프링 빈 등록
@RequestMapping("/day08/products") // 공통 URL 정의
public class Controller {
    @GetMapping("") //(1)
    public void  onRead(){
        System.out.println("Controller.onRead");

        return;
    }
}
