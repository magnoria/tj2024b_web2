package example.day06._aop과제.model.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    // [1] 등록
    // 선택 .xml vs @어노테이션
    // @Insert( " insert into student( name , kor , mata ) values( #{ 매개변수 } , #{ 매개변수 } , #{ 매개변수 } ) ")
    @Insert( " insert into student( name , kor , math ) values( #{ name } , #{ kor } , #{ math } ) ")
    @Options( useGeneratedKeys = true , keyProperty = "sno" )
    int save( HashMap< String , Object> map );

    // [2] 전체조회
    // @Select( "select * from student")                        : native 쿼리 제공 : 순수한 SQL 작성
    @Select( "<script> select * from student </script> ")      // 동적 쿼리 제공 : 순수한 SQL에 mybatis의 추가적인 쿼리 제공 // XML형식
    List<Map<String , Object >> findAll();




}
