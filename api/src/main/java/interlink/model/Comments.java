package interlink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "like")
    Integer like;

    @Column(name = "movie_id_forComm")
    Integer movie_id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id_forComm", insertable = false, updatable = false)
    private Movie movie;

    public Comments() {
    }

    public Comments(Integer like, Integer movie_id) {
        this.like = like;
        this.movie_id = movie_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
