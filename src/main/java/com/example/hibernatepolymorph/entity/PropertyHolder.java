package com.example.hibernatepolymorph.entity;


import org.hibernate.annotations.Any;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "property_holder")
public class PropertyHolder {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property<?> getProperty() {
        return property;
    }

    public void setProperty(Property<?> property) {
        this.property = property;
    }

    @Any(
            metaDef = "PropertyMetaDef",
            metaColumn = @Column( name = "property_type" )
    )
    @JoinColumn(name = "property_id")
    private Property<?> property;

    @Override
    public String toString() {
        return new StringJoiner(", ", PropertyHolder.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("property=" + property)
                .toString();
    }
}

