package interlink.service;

import interlink.dao.MovieDao;
import interlink.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieDao movieDao;

    public List<Movie> getAllMovie(){
        return movieDao.getAllMovie();
    }

    public Movie addNewMovie(String name,String description,Integer duration) {
        return movieDao.addNewMovie(name,description,duration);
    }

    public Movie deleteMovie(Integer id) {
        movieDao.deleteMovie(id);
        return null;
    }
}
