package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by pragan on 25.08.2015.
 */
@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String title;

    @Column
    public String phone_number;

    @Column
    public String web;

    @Column
    public String address;

    @Column
    public String email;

    @Column
    public String type;

    @Column
    public String description;

    @OneToMany(mappedBy = "restaurant", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<Menu> menus = new ArrayList<>();
}
