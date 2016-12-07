package interlink.controller;

import interlink.model.Genre;
import interlink.model.Movie;
import interlink.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class GenreController {
    @Autowired
    GenreService genreService;

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    @ResponseBody
    List<Genre> getAllGenre() {
        return genreService.getAllComm();
    }
}
