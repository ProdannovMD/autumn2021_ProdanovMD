package com.example.lesson.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

// явно указываем имя таблицы, если у класса имя не соответствует
@Table("PLANET")
public class Planet {
    @Id
    private Integer id;
    // явно указываем имя столбца:
    @Column("NAME")
    private String planetName;
    private Integer solarSystemId;
    // поле которого нет в БД:
    @Transient
    private String myRuntimeField;

    public Integer getId() {
        return id;
    }

    public String getPlanetName() {
        return planetName;
    }

    public Integer getSolarSystemId() {
        return solarSystemId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public void setSolarSystemId(Integer solarSystemId) {
        this.solarSystemId = solarSystemId;
    }

    public void setMyRuntimeField(String myRuntimeField) {
        this.myRuntimeField = myRuntimeField;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", planetName='" + planetName + '\'' +
                ", solarSystemId=" + solarSystemId +
                '}';
    }
}
