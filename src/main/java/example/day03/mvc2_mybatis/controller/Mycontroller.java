package example.day03.mvc2_mybatis.controller;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import example.day03.mvc2_mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. HTTP servlet 매핑 지원@Controller // 2. ResponseBody 포함 //3. 컨테이너 빈 등록 @Component
public class Mycontroller {

    // * 스프링 컨테이너에서 서비스 객체/인스턴스를 주입
    @Autowired private MyService myService;

    // (1) PostMapping
    @PostMapping("/day03/save")//[POST] http://192.168.40.18:8080/day03/svae
    public int save( @RequestBody MyDto myDto){
        System.out.println("Mycontroller.save"); //soutm 자동완성 : 메소드명
        System.out.println("myDto = " + myDto); // soutp 자동완성 : 매개변수 출력

        // 컨트롤러가 유저로부터 받은 데이터를 서비스에게 전달하고 응답받는다.
        int result = myService.save(myDto);
        return result;
    }

    //(2) GetMapping
    @GetMapping("/day03/findall")
    public List<MyDto> findall(){
        System.out.println("Mycontroller.findall"); //soutm 자동��성 : 메소드명

        //컨트롤러에서 서비스에게 전달하고 응답받기
        List<MyDto> result = myService.findAll();
        return result;
    }

    //(3)GetMapping
    @GetMapping("/day03/find")
    public  MyDto find(@RequestParam("id")int id){
        System.out.println("Mycontroller.find");
        System.out.println("id = " + id);
        //컨트롤러에서 서비스에게 전달하고 응답받기
        MyDto result = myService.find(id);
        return result;
    }
    //(4)PutMapping
    @PutMapping("/day03/update")
    public int update(@RequestBody MyDto myDto){
        System.out.println("Mycontroller.update");
        System.out.println("myDto = " + myDto);
        int result = myService.update(myDto);
        return result;
    }

    //(4)DeleteMapping
    @DeleteMapping("/day03/delete")
    public int delete(@RequestParam("id")int id){
        System.out.println("Mycontroller.delete");
        System.out.println("id = " + id);

        int result = myService.delete(id);
        return result;
    }




}// class end
