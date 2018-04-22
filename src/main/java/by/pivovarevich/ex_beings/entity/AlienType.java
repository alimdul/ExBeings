package by.pivovarevich.ex_beings.entity;

import java.io.Serializable;
import java.util.Objects;

public class AlienType implements Entity, Serializable {

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = result * prime + id;
        result = result * prime + ((name == null) ? 0 : name.hashCode());
        result = result * prime + ((description == null) ? 0 : description.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AlienType type = (AlienType) obj;
        return Objects.equals(id, type.id) &&
                Objects.equals(name, type.name) &&
                Objects.equals(description, type.description) ;
    }

    @Override
    public String toString() {
        return "Alien type{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                '}';
    }
}
