package example.day11._스케줄링과제;

import com.sun.tools.jconsole.JConsoleContext;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class TaskService {
    List<Map<String, Integer>>  tasks = new ArrayList<Map<String, Integer>>();
    public final TaskMapper taskMapper;


    @Scheduled(cron = "0 */1 * * * *")
    public void taskAll(){
         tasks = taskMapper.taskAll();
        for (int i = 0; i <= tasks.size()-1; i++){
            Map<String, Integer>list = tasks.get(i);
            System.out.println(list);

        }
    }

    @Scheduled(cron = "*/4 * * * * * ")
    public void taskDisCount(){
        tasks = taskMapper.taskAll();
        for (int i = 0; i <= tasks.size()-1; i++){
            Map<String, Integer>list = tasks.get(i);
              int lists=  list.get("stock_quantity");

        }
    }


}





