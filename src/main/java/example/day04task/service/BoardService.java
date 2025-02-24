package example.day04task.service;


import example.day04task.model.dto.BoardDto;
import example.day04task.model.mapper.BoardMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    //1 등록

    public boolean save(BoardDto boardDto) {
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.save(boardDto);

        return result;

    }

    //2. 개별조회

    public BoardDto find(int id) {
        System.out.println("BoardController.findAll");
        BoardDto result = boardMapper.find(id);

        return result;
    }//f end

    //3. 전체조회

    public List<BoardDto> findAll() {
        System.out.println("BoardController.findAll");
        System.out.println();

        List<BoardDto> result = boardMapper.findAll();
        return result;
    }
    //4. 개별수정

    public boolean update(BoardDto boardDto) {
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);

        boolean result = boardMapper.update(boardDto);
        return result;
    }
    //5. 개별삭제

    public boolean delete(int id) {
        System.out.println("BoardController.delete");
        System.out.println("id = " + id);

        boolean result = boardMapper.delete(id);

        return result;

    }

}
