package example.day04task.controller;

import example.day04task.model.dto.BoardDto;
import example.day04task.service.BoardService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/task/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    //1. 입력
    @PostMapping("")
    public boolean save(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.save");
        System.out.println("boardDto = " + boardDto);


        return boardService.save(boardDto);

    }

    //2. 개별조회
    @GetMapping("/view")
    public BoardDto find(@RequestParam("bno") int bno){
        System.out.println("BoardController.findAll");

        return boardService.find(bno);
    }//f end

    //3. 전체조회
    @GetMapping("")
    public List<BoardDto> findAll(){
        System.out.println("BoardController.findAll");
        System.out.println();

        return boardService.findAll();
    }
    //4. 개별수정
    @PutMapping("")
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        return boardService.update(boardDto);
    }
    //5. 개별삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam("bno")int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);

        return  boardService.delete(bno);

    }// f end




}
