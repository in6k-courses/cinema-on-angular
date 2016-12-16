package interlink.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    Integer genre_id;

    @Column(name = "name")
    String name;

    @Column(name = "rating")
    Integer rating;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public Genre(String name, Integer rating) {
        this.rating=rating;
        this.name = name;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
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
