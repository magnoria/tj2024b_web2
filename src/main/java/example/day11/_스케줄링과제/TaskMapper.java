package example.day11._스케줄링과제;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {

    @Select("select * from day11products")
    public List<Map<String, Integer>>taskAll();


}
