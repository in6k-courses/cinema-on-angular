package interlink.dao;

import interlink.model.Comments;
import interlink.model.Genre;
import interlink.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Transactional
@Repository
public class GenreDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Genre> getAllGenre() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Genre.class).addOrder(Order.desc("rating"));
        return (List<Genre>) criteria.list();
    }


    public Genre addNewGenre(String name) {
        Genre genre= new Genre(name);
        sessionFactory.getCurrentSession().save(genre);
        return genre;
    }

    public Genre deleteGenre(Integer id) {
        Genre genre = (Genre) sessionFactory.getCurrentSession().createCriteria(Genre.class)
                .add(eq("id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(genre);
        return null;
    }
}
