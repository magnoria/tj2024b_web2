package example.day04task.model.mapper;

import example.day04task.model.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    //[1]
    @Insert("insert into day04board( title, content )values( #{ title }, #{ content } )")
    public boolean save( BoardDto boardDto);

    //[2]
    @Select(" select * from day04board where bno = #{bno}")
    public BoardDto find( int bno);

    //[3]
    @Select(" select * from day04board")
    public List<BoardDto> findAll();

    //[4]
    @Update(" update day04board set title = #{ title } , content = #{ content } where bno = #{ bno }")
    public boolean update( BoardDto boardDto);

    //[5]
    @Delete("delete from day04board where bno = #{bno}")
    public boolean delete(int bno);

}// f end
