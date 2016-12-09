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

    public void addNewMovie(String name,String description,Integer duration) {
        movieDao.addNewMovie(name,description,duration);
    }
}
