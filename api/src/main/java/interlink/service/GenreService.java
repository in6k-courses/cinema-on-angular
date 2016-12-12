package interlink.service;

import interlink.dao.GenreDao;
import interlink.model.Comments;
import interlink.model.Genre;
import interlink.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreDao genreDao;

    public List<Genre> getAllGenres(){
        List<Genre> list = genreDao.getAllGenre();
        return list;
    }

    public Genre addNewGenre(String name) {
        return genreDao.addNewGenre(name);
    }

    public Genre deleteGenre(Integer id) {
        return genreDao.deleteGenre(id);
    }
}
