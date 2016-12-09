package interlink.controller;

import interlink.model.Movie;
import interlink.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StartController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @ResponseBody
    List<Movie> getAllMovies() {
        return movieService.getAllMovie();
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    @ResponseBody
    void addNewMovie(@RequestBody String name,@RequestBody String description,@RequestBody Integer duration){
        movieService.addNewMovie(name,description,duration);
    }
}
