package example.day04.service;

import example.day04.model.dto.BoardDto;
import example.day04.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired private BoardMapper boardMapper;

    public int create(BoardDto boardDto){
        System.out.println("BoardService.create");
        System.out.println("boardDto = " + boardDto);

        int result = boardMapper

    }

    public List<BoardDto> readAll(){
        System.out.println("BoardService.readAll");
        System.out.println();

        List<BoardDto> result = BoardService

    }// f end

}// class end
