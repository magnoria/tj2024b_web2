package example.day08.model.mapper;


import example.day08.model.dto.ProductDto;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
public interface ProductMapper {

    // [1] 제품등록 , dto의 멤버변수와 db테이블의 속성명은 동일하게.<권장/관례>
    @Insert("insert into productsample( name, price , comment ) values ( #{name} , #{price} , #{comment} )")
    boolean onSave(ProductDto productDto);


    //[2] 전체조회
    @Select("select * from productsample")
    List<ProductDto> onRead();

    @Update("update productsample set name = #{name} , price = #{price} , comment = #{comment} where id = #{id}")
    boolean onUpdate(ProductDto productDto);

    @Delete("delete from productsample where id = #{id}")
    boolean onDelete(int id);



}
