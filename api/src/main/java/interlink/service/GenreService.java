package interlink.service;

import interlink.dao.GenreDao;
import interlink.model.Comments;
import interlink.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreDao genreDao;
    public List<Genre> getAllComm(){
        return genreDao.getAllGenre();
    }

}
