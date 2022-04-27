package it.philmark.docenza.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double importo;

    private Date ordersDate;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Products> productsList;

    public Orders(Date ordersDate) {
        this.ordersDate = new Date();
    }

}
