package example.Task03_05;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
   // private static TaskService instance = new TaskService();
   // private  TaskService(){}
   // public static TaskService getInstance(){return instance;}



    @interface tast{
        String method();
    }


   public void  method1(){}
    //static 으로 만들어도 불러올수 있다.

}
