package example.day07.task.model.mapper;

import example.day07.task.model.dto.TaskDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {

    @Insert(" insert into practice(name ,number) values (#{name} , #{number})")
    public boolean onPost(Map<Object,String> map);

    @Select(" select * from practice")
    ArrayList<TaskDto> findAll();
}
