package example.day11._스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //스프링 MVC 에서 resst controller알림
@RequestMapping("/day11/thread") // 공통 url
@RequiredArgsConstructor // final 필드 초기화
public class ThreadController {

    private final ThreadService threadService;

    // (1) 비동기 = 기본값
    @GetMapping("/start1")
    public void thread1(){
        System.out.println("ThreadController.thread1");
        threadService.thread1();//soutm
    }
    //(2) 동기화

    @GetMapping("/start2")
    public void thread2(){
        System.out.println("ThreadController.thread2");
        threadService.thread2();
    }
}
