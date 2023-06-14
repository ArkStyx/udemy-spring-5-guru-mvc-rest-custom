package guru.springframework.custom.v001.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoArticleDto {

    private Long id;
    private String nomPhoto;
    private String extensionPhoto;
}
