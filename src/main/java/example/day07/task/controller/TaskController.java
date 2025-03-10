package example.day07.task.controller;


import example.day07.task.model.dto.TaskDto;
import example.day07.task.reactService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/day07/task")
@CrossOrigin("http://192.168.40.63:5173")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("")
    public boolean onPost(@RequestBody Map<Object , String> map){
        System.out.println("TaskController.onPost");
        System.out.println("map = " + map);

        return taskService.onPost(map);
    }
    @GetMapping("")
    public ArrayList<TaskDto> inFindAll(){
        System.out.println("TaskController.inFindAll");
        return taskService.findAll();
    }


}
