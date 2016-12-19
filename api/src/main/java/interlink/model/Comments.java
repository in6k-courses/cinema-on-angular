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
    Integer movie_id_forComm;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id_forComm", insertable = false, updatable = false)
    private Movie movie;

    public Comments() {
    }

    public Comments(Integer like, Integer movie_id_forComm) {
        this.like = like;
        this.movie_id_forComm = movie_id_forComm;
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

    public Integer getMovie_id_forComm() {
        return movie_id_forComm;
    }

    public void setMovie_id_forComm(Integer movie_id_forComm) {
        this.movie_id_forComm = movie_id_forComm;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
