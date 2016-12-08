package interlink.dao;

import interlink.model.Comments;
import interlink.model.Movie;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CommentsDao {
    @Autowired
    SessionFactory sessionFactory;

    public List<Comments> getAllComm() {
        Criteria criteria = sessionFactory.getCurrentSession().
                createCriteria(Comments.class);
        List<Comments> commentses = (List<Comments>) criteria.list();
        for (Comments comments:commentses){
            comments.getLike();
            comments.getMovie().getDescription();
        }
        return commentses;
    }
}
