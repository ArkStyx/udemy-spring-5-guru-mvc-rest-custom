package guru.springframework.custom.v001.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String name;
    private String quantity;
    private String barCode;
}
