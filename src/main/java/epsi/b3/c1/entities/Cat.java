package epsi.b3.c1.entities;

import javax.persistence.*;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Cat extends Animal {
    private String chipId;

    public Cat(LocalDate birth, String color, PetStore petStore, String chipId) {
        super(birth, color, petStore);
        this.chipId = chipId;
    }
}
