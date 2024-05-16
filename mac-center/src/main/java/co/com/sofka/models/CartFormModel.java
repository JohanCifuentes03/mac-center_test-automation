package co.com.sofka.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartFormModel {
    private String email;
    private String id;
    private String name;
    private String lastname;
    private String direction;
    private String phone;
}
