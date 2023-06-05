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
public class CustomerDto {

    private String firstName;
    private String lastName;

    // TODO CA FAIT QUOI CONCRETEMENT ?
    @JsonProperty("customer_url")
    private String customerUrl;
}
