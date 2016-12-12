package interlink.controller;

import interlink.model.Genre;
import interlink.model.Movie;
import interlink.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    List<Genre> getAllGenre() {
        return genreService.getAllGenres();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    Genre addNewMovie(@RequestBody Genre genre){
        return genreService.addNewGenre(genre.getName());
    }
}
