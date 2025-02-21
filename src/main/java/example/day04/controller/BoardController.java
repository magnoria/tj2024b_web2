package example.day04.controller;


import example.day04.model.dto.BoardDto;
import example.day04.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BoardController {
    @Autowired private BoardService boardService;

    @PostMapping("/day03/board")
    public int create(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.create");
        System.out.println("boardDto = " + boardDto);

        int result = boardService.create(boardDto);

        return result;
    }

    @GetMapping("/day03/board")
    public List<BoardDto> readAll(){
        System.out.println("BoardController.read");
        System.out.println();

        List<BoardDto> result = BoardService.re

    }// class end


}// class end
