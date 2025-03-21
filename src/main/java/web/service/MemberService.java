package web.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service// 해당 클래스가 서비스임을 주입
@RequiredArgsConstructor // final 필드에 대해서
public class MemberService {

    private  final MemberMapper memberMapper;
    private  final FileService fileService; // 파일서비스(업로드 , 다운로드 , 파일삭제) 기능 포함

    // [1] 회원가입
    public boolean sigunUp(MemberDto memberDto){
        System.out.println("MemberService.sigunUp");
        System.out.println("memberDto = " + memberDto);
        //return false;
        try {


            //(1) 만약에 첨부파일(프로필업로드)이 존재하는지 검사.
            if (memberDto.getUploadfile() == null) {// 업로드가 존재하지 않으면
            } else { //업로드가 존재하면 파일 서비스의 업로드 메소드 사용하기.
                // (2) 파일서비스내 업로드 함수 이용하여 첨부파일 업로드하기
                String filename = fileService.fileUpload(memberDto.getUploadfile());
                // (3) 업로드 된 파일명을 dto로 저장
                memberDto.setMimg(filename);
            }
            // (4) 비크립트 라이브러리 이용한 비밀번호 암호화 하기
                // 1. 비크립트 객체 생성하기, new BCryptPasswordEncoder();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                // 2. 암호화할 자료에 .encode(암호화할자료);
                String hashedPassword = passwordEncoder.encode(memberDto.getMpwd());
                System.out.println("MemberService.sigunUp");
                //3. 암호화된 값을 dto에 넣어서 db처리
                memberDto.setMpwd(hashedPassword);

            boolean result = memberMapper.sigunUp(memberDto);
            System.out.println("service문제" + result);
            System.out.println("memberDto = " + memberDto);
            return result;
            } catch (Exception e) {return false;}  // 업로드와 회원가입DB처리중 예외 발생시 false 반환

        }

    //[2] 로그인
    public MemberDto login(MemberDto memberDto){
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);
//        MemberDto result = memberMapper.login(memberDto);
            // (1) 암화된 진짜 비밀번호는 DB에 존재, 로그인에 사용된 비밀번호는 암화 하기전
            // 진짜(qwe) 비밀번호의 암호화 $2a$10$fiYrX2pIQBQmobhoNSI02ersZEcNFrPMpYmSG2jWHP3IWCYhOU/l2
            // 로그인에 입력한 비밀번호 : qwe
            // (2)로그인에서 입력받은 아이디의 암호화 비밀번호 가져오기
        String password = memberMapper.findPassword(memberDto.getMid());
        if ( password == null) return null;//조회결과가 없으면
            //(3) 로그인에서 입력받은 비밀번호와 암호화된 비밀번호 검증하기
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 1. 비크립트 객체 생성
        boolean result = passwordEncoder.matches( memberDto.getMpwd() , password); // 2. 로그인에 입력받은 자료와 DB에서 가져온 해시(암호와된)값 검증
        if ( !result ) return null; //비밀번호 검증 실패
            //(4) 로그인에서 입력한 아이디와 비밀번호가 모두 일치하면 회원정보 가져오기
        MemberDto result2 = memberMapper.login( memberDto);
        return result2;
    }

}
