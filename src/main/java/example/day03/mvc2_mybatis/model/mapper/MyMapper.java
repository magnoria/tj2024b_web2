package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {
        //Mapper 변화가 있는 레코드수 의 개수를 반환한다

        //[1] 등록 SQL 처리하는 매퍼 추상메소드
        int save (MyDto myDto); // 추상메소드 매핑 구현

        //[2] 전체조회 SQL 처리하는 매퍼
        List<MyDto> findAll();

        //[3] 개별조회 SQL 처리하는 매퍼
        MyDto find(int id);

        //[4] 개별 수정 SQL 처리하는 매퍼
        int update(MyDto myDto);

        //[5] 개별삭제 SQL 처리하는 매퍼
        int delete(int id);

}//f end
