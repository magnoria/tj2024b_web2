package web.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController // @ResponseBody 포함하며 restApi 지원하는 컨트롤러 빈 등록
@RequestMapping("/api/member")// 클래스내 http 매핑 주소의 공통 url을 정의할때 사용
// -> 개발하는 사람들이 페이지 매핑과 REST 매핑을 구분하기 위한 방법
// 1. 페이지 url : - member/signup
// 2. REST url : 1. /member/signup.do : 뒤에 do 를 붙이는 경우(관례 : 과거)
//               2. /api/member/signup : 앞에 api를 붙이는 경우(관례 : 최근)

@RequiredArgsConstructor // final 멤버변수에 대해서 자동 생성자를 자동으로 지원한다.
//final 필드에 대해서 자동으로 생성자를 지원하므로 @Autowired 주입 생성을 생략해도 된다.
public class MemberController {

    //1.
    @Autowired
    private MemberService memberService;

//    //2. Spring 공식 권장 방법
//    private MemberService memberService;
//
//    @Autowired
//    public MemberController(MemberService memberService){
//        this.memberService = memberService;
//    } 위의 방법을 쓰면 이걸 생략할수 있다. @RequiredArgsConstructor

    // [1]  회원가입
    // http://localhost:8080/api/member/singup
    //Content-Type : application/json
    //{ "mid":"test1" , "mpwd" :"1234 ", "mname": "유재석"}
    @PostMapping("/signup")
   // public boolean sigunUp(@RequestBody MemberDto memberDto) { //JSON @RequestBody 명시
    public boolean sigunUp(MemberDto memberDto) { // multipart/form-data 사용시 @RequestBody 생략
        System.out.println("MemberController.sigunUp");
        System.out.println("memberDto = " + memberDto);
        //return false;
        boolean result = memberService.sigunUp(memberDto);
        return result;
    }

    // [2] 로그인 +세션(서버내 저장소 = 주로 로그인된 회원정보)
    //http://localhost:8080/api/member/login
    //Content-Type : application/json
    //{ "mid":"test1" , "mpwd" :"1234 ", "mname": "유재석"}
    @PostMapping("/login")
    public boolean login(@RequestBody MemberDto memberDto, HttpServletRequest req) {
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);
        MemberDto result = memberService.login(memberDto);
        System.out.println("result = " + result);
        if (result == null) {
            return false;
        } // 서비스 결과가 null 이면 로그인 실패
        else {// 서비스 결과가 null이 아니면 로그인 성공 => 세션에 로그인 성공한 dto를 저장
            HttpSession session = req.getSession(); // 세션 호출
            session.setAttribute("loginDto", result); // 세션 객체내 새로운 속성 추가, 로그인성공한 결과를 'loginDto' 라는 이름으로 저장
            session.setMaxInactiveInterval(60 * 10); // 세션 유지시간[초] : 60 *10 => 10분
            return true; //로그인 성공 처리
        }//else end

    }//f end

    // [3] 로그아웃 + 세션 삭제 [ https://github.com/itdanjalog/tj2024b_web1/blob/master/tj2024b_web1/src/main/webapp/정리폴더/8.세션.txt ]
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        HttpSession session = request.getSession();// 1. 세션 호출
        if (session == null) return false;
        //session.invalidate(); // 2. 세션내 전체 속성 초기화 한다.
        session.removeAttribute("loginDto"); // 2. 세션내 특정 속성만 초기화 한다.
        return true;
    } // f end

    // [4] 로그인 상태 확인 , 내정보보기(마이페이지)
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request) {
        HttpSession session = request.getSession();// 1. 세션호출
        if (session == null) return null; // 2. 만약에 세션이 존재하지 않으면 null 반환
        Object object = session.getAttribute("loginDto"); // 3. 로그인 성공시 저장한 loginDto 의 로그인정보를 꺼낸다.
        MemberDto memberDto = (MemberDto) object; // 4. 세션에 저장된 자료들은 모두 Object 타입 이므로 타입변환한다.
        return memberDto;// 5. 로그인된 정보 반환

    }
}