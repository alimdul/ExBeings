package by.pivovarevich.ex_beings.entity;

import java.io.Serializable;
import java.util.Objects;

public class Alien implements Entity, Serializable {

    private int id;
    private String name;
    private String place;
    private String food;
    private String dangers;
    private String appearance;
    private String feature;
    //picture

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDangers() {
        return dangers;
    }

    public void setDangers(String dangers) {
        this.dangers = dangers;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;

        result = result * prime + id;
        result = result * prime + ((name == null) ? 0 : name.hashCode());
        result = result * prime + ((place == null) ? 0 : place.hashCode());
        result = result * prime + ((food == null) ? 0 : food.hashCode());
        result = result * prime + ((dangers == null) ? 0 : dangers.hashCode());
        result = result * prime + ((appearance == null) ? 0 : appearance.hashCode());
        result = result * prime + ((feature == null) ? 0 : feature.hashCode());
        //picture

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alien alien = (Alien) obj;
        return Objects.equals(id, alien.id) &&
                Objects.equals(name, alien.name) &&
                Objects.equals(place, alien.place) &&
                Objects.equals(food, alien.food) &&
                Objects.equals(dangers, alien.dangers) &&
                Objects.equals(appearance, alien.appearance) &&
                Objects.equals(feature, alien.feature);
        //picture
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name=" + name +
                ", place=" + place +
                ", food=" + food +
                ", dangers=" + dangers +
                ", appearance=" + appearance +
                ", feature=" + feature +
                '}';
    }
}
