package interlink.service;

import interlink.dao.CommentsDao;
import interlink.dao.MovieDao;
import interlink.model.Comments;
import interlink.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsDao commentsDao;

    public List<Comments> getAllComm(){
        return commentsDao.getAllComm();
    }

    public Comments addNewComm(Comments comments) {
        return commentsDao.addNewComm(comments.getLike(),comments.getMovie_id_forComm());
    }
}
