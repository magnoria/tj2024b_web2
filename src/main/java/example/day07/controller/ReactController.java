package example.day07.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // 빈등록
@RequestMapping("day07/react") // 공통URL http://localhost:8080/day07/react
@CrossOrigin("http://192.168.40.63:5173") // CORS 정책 허용 ,  특정  url만 허용 가능하도록 한다.
public class ReactController {

    //(샘플데이터 저장하는 리스트 )
    private List<Map<Object,String>> boards = new ArrayList<>();


    //[1] POST {"writer" : "3","content" : "test1", "pwd" : "v123456"}
    @PostMapping("")//http://localhost:8080/day07/react   //{"writer" : "3","content" : "test1", "pwd" : "v123456"}
    public boolean onPost(@RequestBody Map<Object ,String> map){
        System.out.println("ReactController.omPost");
        System.out.println("map = " + map);
        boards.add(map);
        return true;
    }//f end

    //[2] GET
    @GetMapping("")
    public List<Map<Object,String>> onFindAll(){
        System.out.println("ReactController.onFindAll");
        return boards;
    }


}
