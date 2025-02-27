package example.day06._aop과제.controller;



import example.day06._aop과제.security.Security;
import example.day06._aop과제.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06/students")
public class StudentController {

    @Autowired // (스프링 컨테이너) 에서 빈(인스턴스) 주입 받기
    private StudentService studentService;
    @Autowired
    private Security security;

    // [1] 등록
    @PostMapping("") // post , http://localhost:8080/day05/students  , { "name" : "유재석" , "kor" : "80" , "math" : "100" }
    public int save(@RequestBody HashMap< String , Object> map ){

        int result = studentService.save( map );

        return  result;
    }
    // [2] 전체조회
    @GetMapping("") // get , http://localhost:8080/day05/students
    public List<Map<String , Object >> findAll(){

        List result = studentService.findAll();

        return result;
    }


}
