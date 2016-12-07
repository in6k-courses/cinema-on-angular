package interlink.dao;

import interlink.model.Comments;
import interlink.model.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenreDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Genre> getAllGenre() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Genre.class);
        return (List<Genre>) criteria.list();
    }


}
