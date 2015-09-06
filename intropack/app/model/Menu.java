package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by pragan on 25.08.2015.
 */
@Entity
public class Menu {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public Integer day;

    @Column
    public Integer price;

    @ManyToOne
    public Restaurant restaurant;
}
