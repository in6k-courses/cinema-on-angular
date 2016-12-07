package interlink.dao;

import interlink.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MovieDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Movie> getAllMovie() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Movie.class);
        return (List<Movie>) criteria.list();
    }
}
