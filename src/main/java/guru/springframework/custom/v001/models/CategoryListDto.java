package guru.springframework.custom.v001.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryListDto {

	List<CategoryDto> categories;
}
