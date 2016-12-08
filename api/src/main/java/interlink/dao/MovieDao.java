package interlink.dao;

import interlink.model.Comments;
import interlink.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            for (Comments comments:movie.getComm()){
                comments.getLike();
            }
        }
        return movies;
    }
}
