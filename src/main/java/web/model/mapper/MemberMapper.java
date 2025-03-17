package web.model.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

@Mapper
public interface MemberMapper {

    // [1] 회원가입 -> 입력받은 자료를 등록 -> INSERT
    // 추상메소드 이므로 {}구현부가 필요없다.
    @Insert("insert into member(mid, mpwd , mname, mimg) values ( #{mid}, #{mpwd} , #{mname} , #{mimg} )")
    public boolean sigunUp(MemberDto memberDto);

    //[2] 로그인 -> 입력받은 아이디와 비밀번호 확인/검증 -> SELECT
    @Select("select mno, mid, mname, mimg from member where mid = #{mid} and mpwd = #{mpwd}")
    //  public boolean login(MemberDto memberDto); // boolean : select 결과가 있으면 true ,  없으면 null 이라서 오류 발생할 수 있다. //예외처리 해야함
    public MemberDto login(MemberDto memberDto); // MemberDto : select 결과가 있으면 memberDto , 없으면 null



}
