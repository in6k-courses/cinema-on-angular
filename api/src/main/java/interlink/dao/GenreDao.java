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
        List<Genre> genreList = (List<Genre>) criteria.list();
        for(Genre genre:genreList){
            genre.getRating();
            for (Movie movie:genre.getMovie()){
                movie.getName();
                for (Comments comments:movie.getComm()){
                    comments.getLike();
                }
            }
        }
        return genreList;
    }

    public Genre addNewGenre(String name) {
        Genre genre = new Genre(name);
        sessionFactory.getCurrentSession().save(genre);
        return genre;
    }

    public Genre deleteGenre(Integer id) {
        Genre genre = (Genre) sessionFactory.getCurrentSession().createCriteria(Genre.class)
                .add(eq("genre_id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(genre);
        return null;
    }
}
