package interlink.dao;

import interlink.model.Comments;
import interlink.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Transactional
@Repository
public class MovieDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<Movie> getAllMovie() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Movie.class);
        List<Movie> movies = (List<Movie>) criteria.list();
        for(Movie movie:movies){
            movie.getName();
            movie.getComm().forEach(Comments::getLike);
        }
        return movies;
    }

    public Movie addNewMovie(String name,String description,Integer duration) {
        Movie movie= new Movie(name,description,duration);
        sessionFactory.getCurrentSession().save(movie);
        return movie;
    }

    public Movie deleteMovie(Integer id) {
        Movie movie = (Movie) sessionFactory.getCurrentSession().createCriteria(Movie.class)
            .add(eq("id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(movie);
        return null;
    }

    public Movie getMovieById(Integer id) {
        Movie movie=(Movie) sessionFactory.getCurrentSession().createCriteria(Movie.class)
                .add(eq("id",id))
                .uniqueResult();
        movie.getComm().forEach(Comments::getLike);
        return movie;
    }
}
