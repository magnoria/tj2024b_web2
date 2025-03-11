package example.day08.service;

import example.day08.model.dto.ProductDto;
import example.day08.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service// 스프링 빈 등록
public class ProductService {

    @Autowired
    ProductMapper productMapper;
    //등록
    public  boolean onSave(ProductDto productDto){
        System.out.println("ProductService.onSave");
        System.out.println("productDto = " + productDto);

        return productMapper.onSave(productDto);
    }

    //[2] 전체조회
    public List<ProductDto> onRead(){
        System.out.println("ProductService.onUpdate");

        return productMapper.onRead();
    }

    public boolean onUpdate(ProductDto productDto){
        System.out.println("ProductService.onUpdate");
        System.out.println("productDto = " + productDto);

        return productMapper.onUpdate(productDto);

    }


    public  boolean onDelete(int id){
        System.out.println("ProductService.onDelete");
        System.out.println("id = " + id);

        return productMapper.onDelete(id);
    }


}
