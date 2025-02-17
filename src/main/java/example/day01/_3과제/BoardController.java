package example.day01._3과제;

import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/day01")
public class BoardController {

    //1. 글쓰기
    @PostMapping("/task/board")
    public boolean board1(){return true;}

    //2. 전체 글 조회
    @GetMapping("/task/board")
    public List<Map<String,String>> board2(){
        List<Map<String,String>> list = new ArrayList< >();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }//f end

    //3. 개별 글 조회
    @GetMapping("/task/board/view")
    public Map< String, String> board3(){
        Map< String , String> map1 = new HashMap<>();
        map1.put("bno", "1");
        map1.put("btitle", "제목1");
        return map1;
    }//f end

    //4. 개시글 수정
    @PutMapping("/task/board")
    public boolean board4(){
        return true;
    }//f end

    //5. 개별 글 삭제
    @DeleteMapping("task/board")
    public int board5(){
        return 3;
    }//f end



}// class end
