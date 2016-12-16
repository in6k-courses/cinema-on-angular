package interlink.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    Integer movie_id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "duration")
    Integer duration;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Comments> comm = new ArrayList();

    public Movie() {
    }

    public Movie(String name, String description, Integer duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Comments> getComm() {
        return comm;
    }

    public void setComm(List<Comments> comm) {
        this.comm = comm;
    }
}
