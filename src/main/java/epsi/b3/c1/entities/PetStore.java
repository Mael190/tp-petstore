package epsi.b3.c1.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PetStore {
    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;
    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "petStores")
    private Set<Product> products = new HashSet<Product>();

    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;

    public void addProduct(Product product) {
        products.add(product);
        product.getPetStores().add(this);
    }

}
