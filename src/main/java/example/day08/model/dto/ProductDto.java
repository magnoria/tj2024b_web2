package example.day08.model.dto;


import lombok.*;
import org.apache.ibatis.annotations.Select;

@Getter@Setter
@ToString@Builder
@AllArgsConstructor@NoArgsConstructor
public class ProductDto {

    private int id;
    private String name;
    private int price;
    private String comment;


}
