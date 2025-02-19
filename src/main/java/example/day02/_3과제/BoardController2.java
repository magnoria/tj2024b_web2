package example.day02._3과제;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 컨테이너 등록 을 까먹음 + @Component 포함
public class BoardController2 {


    @Autowired // 싱글톤 호출 대신에 .getInstance() 대용
    BoardDao boardDao;

        //생성자 만드는것
    public BoardController2(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    //http://192.168.40.18:8080/day02/task2/board 확인용
    @PostMapping("/day02/task2/board")
    public boolean tast1(@RequestBody BoardDto boardDto ){ // 2.body 값을 함수 매개변수로 매핑한다.

        boolean result = BoardDao.method1(boardDto);


        return true;
    } // f end


    @GetMapping("/day02/task2/board")
    public List<BoardDto> tast2(){
        List<BoardDto> result = BoardDao.method2();
        return result;
    } // F END

    @GetMapping("/day02/task2/board/view")
    public static BoardDto tast3( @RequestParam( name = "bno") int bno ){

        BoardDto result =BoardDao.method3(bno);

        return result;
    } // F END

    @PutMapping("/day02/task2/board")
    public boolean tast4( @RequestBody BoardDto boardDto ){

        boolean result = BoardDao.method4(boardDto);

        return result;
    } // f end

    @DeleteMapping("/day02/task2/board")
    public boolean tast5( @RequestParam( name = "bno") int bno ){

        boolean result = BoardDao.mehtod5(bno);

        return result;
    } // f end


}//class end
