package com.shopme.common.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;
//this is the first entity class in the project

@Entity // use @Entity annotation from JPA to indicate that this java class will map to the table in the database
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  // to tell hibernate that and the values of this field will be generated automatically
    private Integer id;
    // nullable = false meaning that underlying colum in the database is not null
    //unique = true meaning that no two roles o have the same name
    @Column(length = 40, nullable = false,unique = true)

    private String name;

    @Column(length = 150, nullable = false)

    private String description;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
