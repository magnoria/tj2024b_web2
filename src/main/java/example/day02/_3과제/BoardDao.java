package example.day02._3과제;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component //싱글톤 대신 사용
public class BoardDao {
    private static final List<BoardDto> list = new ArrayList<>();
    private static int auto_increment = 1;



    // 1. POST 매핑주소를 만든다.

    public static boolean method1(BoardDto boardDto){ // 2.body 값을 함수 매개변수로 매핑한다.
        boardDto.setBno( auto_increment ); // 3. boardDto의 bno를 넣어준다.
        list.add( boardDto ); // 4. 리스트에 boardDto를 넣어준다.
        auto_increment++; // 5. auto_increment 증가한다.
        return true; // 6. 리턴한다.
    } // f end


    public static List<BoardDto> method2(){
        return list;
    } // F END



    public static BoardDto method3( int bno ){
        for( int index = 0 ; index <= list.size()-1 ; index++ ){
            BoardDto boardDto = list.get(index);
            if( boardDto.getBno() == bno ){ return boardDto; } // 찾았으면 찾은 DTO 반환
        }
        return null; // 없으면
    } // F END


    public static boolean method4(BoardDto boardDto ){
        for( int index = 0 ; index <= list.size()-1 ; index++ ){
            BoardDto boardDto2 = list.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                list.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end


    //http://localhost:8080/day02/task2/board/view&bno=1
    public static boolean mehtod5( int bno ){
        for( int index = 0 ; index <= list.size()-1 ; index++  ){
            BoardDto boardDto2 = list.get(index);
            if( boardDto2.getBno() == bno ){
                list.remove( index );
                return true;
            }
        }
        return false;
    } // f end


}// class end
