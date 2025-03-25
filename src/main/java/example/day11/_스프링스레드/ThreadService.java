package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service //  스프링 MVC에서 Service담당
public class ThreadService {

    //(1) 비동기
    @Async// [2] 멀티스레드를 적용할 메소드위에 @Async
    public void thread1(){
        String name = UUID.randomUUID().toString();
        for (int i = 1; i <= 10; i++){
            System.out.println(i +"작업스레드:"+ name);
            try {Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }//for end
    }// f end

    //(2)동기 , synchronized
    @Async
    public synchronized void thread2(){
        String name = UUID.randomUUID().toString();
        for (int i = 1; i <= 10; i++){
            System.out.println(i + "작업스레드:"+ name);
            try {Thread.sleep(1000);
            }catch (Exception e){
                System.out.println(e);
            }
        }//for end
    }
}// c end
