package web.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter @Setter @ToString 등등 포함된 어노테이션
@AllArgsConstructor// 전체 생성자
@NoArgsConstructor// 빈 생성자
@Builder// 빌더패턴 지원
public class MemberDto {
    // + DB데이터 필요
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mimg;

    //+ 그외

}
