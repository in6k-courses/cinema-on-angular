package interlink.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "duration")
    Integer duration;

    @Column(name = "comm_id")
    Integer comm_id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Comments> comm = new ArrayList();

    public Movie() {
    }

    public Movie(String name, String description, Integer duration, Integer comm_id) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.comm_id = comm_id;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getComm_id() {
        return comm_id;
    }

    public void setComm_id(Integer comm_id) {
        this.comm_id = comm_id;
    }

    public List<Comments> getComm() {
        return comm;
    }

    public void setComm(List<Comments> comm) {
        this.comm = comm;
    }
}
