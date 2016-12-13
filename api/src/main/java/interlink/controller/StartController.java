package interlink.controller;

import interlink.model.Movie;
import interlink.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/movie")
public class StartController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    Movie addNewMovie(@RequestBody Movie movie) {
        return movieService.addNewMovie(movie);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    Movie deleteMovie(@PathVariable("id") Integer id) {
        return movieService.deleteMovie(id);
    }
}
