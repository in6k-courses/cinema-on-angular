package interlink.controller;

import interlink.model.Comments;
import interlink.model.Movie;
import interlink.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comm")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    List<Comments> getAllComm() {
        return commentsService.getAllComm();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    Comments addNewComm(@RequestBody()Comments comments) {
        return commentsService.addNewComm(comments);
    }
}
