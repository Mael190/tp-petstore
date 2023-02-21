package epsi.b3.c1.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String number;
    private String street;
    private String zipCode;
    private String city;
}
