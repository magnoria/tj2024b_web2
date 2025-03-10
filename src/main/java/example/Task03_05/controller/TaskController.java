package example.Task03_05.controller;


import example.Task03_05.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController extends TaskService {


    //4.atuowird 방법
   @Autowired
   private static TaskService taskService;



    //1. 상속 메소드 사용
    @Override
    public void method1(){};


    @PostMapping("")
    public static void main(String[] args) {


        //2. 생성자 만들어서 사용
       // TaskService task = new TaskService();
        //task.method1();


        // atuowird 방법
        //taskService.method1();

        //3. 싱글톤
       // TaskService.getInstance().method1();

    }

    //4.







}
