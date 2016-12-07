package interlink.controller;

import interlink.model.Movie;
import interlink.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class StartController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    @ResponseBody
    List<Movie> home() {
        return movieService.getAllMovie();
    }
}
