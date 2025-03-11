package example.day08.controller;

import example.day08.model.dto.ProductDto;
import example.day08.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //스프링 빈 등록
@RequestMapping("/day08/products") // 공통 URL 정의
@CrossOrigin("http://192.168.40.63:5173/") //리액트 포트 도메인을 허용해야한다.
public class ProductController {

    @Autowired
    ProductService productService;


    //[1] 제품 등록
    @PostMapping("")
    public boolean onSave(@RequestBody ProductDto productDto){
        System.out.println("ProductController.onSave");

        return productService.onSave(productDto);
    }




    //[2] 전체조회
    @GetMapping("") //(1) http://192.168.40.63:8080/day08/products
    public List<ProductDto> onRead(){   //(2) 매개타입
        System.out.println("Controller.onRead"); //(3)리턴타입 구성

        return productService.onRead(); // 샘플
    }

    //[3] 제품 수정
    @PutMapping("") // { "id" : "1" , "name" : "제로콜라" , "price" : "2000" , "comment" :"신제품 제로콜라"}
    public boolean onUpdate(@RequestBody ProductDto productDto){
        System.out.println("ProductController.onUpdate");

        return productService.onUpdate(productDto);
    }

    //[4] 제품삭제
    @DeleteMapping
    public boolean onDelete(@RequestParam("id") int id){
        System.out.println("ProductController.onDelete");

        return productService.onDelete(id);
    }




}
