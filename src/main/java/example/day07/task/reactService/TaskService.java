package example.day07.task.reactService;


import example.day07.task.model.dto.TaskDto;
import example.day07.task.model.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public boolean onPost(Map<Object, String> map){
        System.out.println("TaskService.onPost");
        System.out.println("map = " + map);
        return taskMapper.onPost(map);
    }

    public ArrayList<TaskDto> findAll(){
        System.out.println("TaskService.findAll");

        return taskMapper.findAll();
    }


}
