package guru.springframework.custom.v001.controllers;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springframework.custom.v001.models.CategorieDto;
import guru.springframework.custom.v001.services.CategorieService;

public class CategorieControllerTest {

	private static final String API_V1_FULL_URL = "/api/v1/categories";
	
	private static final Long ID_01 = 1L;
	private static final Long ID_02 = 2L;
	
	private static final String NOM_01 = "Fruits";
	private static final String NOM_02 = "Legumes";
	
	@Mock
	CategorieService categoryService;
	
	@InjectMocks
	CategorieController categoryController;
	
	MockMvc mockMvc;
	
    @BeforeEach
    public void setUp() throws Exception {
    	MockitoAnnotations.openMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }
    
    @Test
    public void getCategories() throws Exception {

    	/* Mockito Standard - Given */
    	CategorieDto categorie01 = new CategorieDto();
    	categorie01.setId(ID_01);
    	categorie01.setNom(NOM_01);

    	CategorieDto categorie02 = new CategorieDto();
    	categorie02.setId(ID_02);
    	categorie02.setNom(NOM_02);
    	
    	List<CategorieDto> listeCategorieDto = new ArrayList<>();
    	listeCategorieDto.add(categorie01);
    	listeCategorieDto.add(categorie02);
    	
    	/* Mockito Standard - When */
    	Mockito.when(categoryService.recupererListeDesCategories()).thenReturn(listeCategorieDto);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.get(API_V1_FULL_URL)
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());
    	
    	verify(categoryService, times(1)).recupererListeDesCategories();
    }
    
    @Test
    public void getCategoryById() throws Exception {
    	
       	/* Mockito Standard - Given */
    	CategorieDto categorie01 = new CategorieDto();
    	categorie01.setId(ID_01);
    	categorie01.setNom(NOM_01);

    	/* Mockito Standard - When */
    	Mockito.when(categoryService.recupererCategorieParId(anyLong())).thenReturn(categorie01);
    	
    	/* Mockito Standard - Then */
    	mockMvc.perform(
    				MockMvcRequestBuilders.get(API_V1_FULL_URL + "/1")
    				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
    			)
    			.andExpect(status().isOk());

    	verify(categoryService, times(1)).recupererCategorieParId(anyLong());
    }
    
}
