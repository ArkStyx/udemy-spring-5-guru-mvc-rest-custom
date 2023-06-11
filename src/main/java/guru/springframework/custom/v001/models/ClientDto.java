package guru.springframework.custom.v001.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private String prenom;
    private String nomDeFamille;

    // TODO CA FAIT QUOI CONCRETEMENT ?
    @JsonProperty("customer_url")
    private String urlClient;
}
