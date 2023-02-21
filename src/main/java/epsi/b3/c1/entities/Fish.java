package epsi.b3.c1.entities;

import javax.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    private FishLivEnv fishLivEnv;

    public Fish(LocalDate birth, String color, PetStore petStore, FishLivEnv livEnv) {
        super(birth, color, petStore);
        this.fishLivEnv = livEnv;
    }
}
