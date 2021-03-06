package interlink.model;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "rating")
    Integer rating;

    public Genre() {
    }

    public Genre(String name,Integer rating) {
        this.rating=rating;
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
