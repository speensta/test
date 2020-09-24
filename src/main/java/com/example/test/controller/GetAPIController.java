package com.example.test.controller;

import com.example.test.service.TestBoardService;
import com.example.test.service.impl.BoardCrudRepository;
import com.example.test.service.impl.BoardRepository;
import com.example.test.vo.BoardType;
import com.example.test.vo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/board")
public class GetAPIController {

    @Autowired
    TestBoardService testBardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardCrudRepository boardCrudRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String getRequest(Model model) {
        List<Board> list = boardRepository.findAll();
        model.addAttribute("list", list);
        return "board/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/form/{id}", "/form"})
    public String form(Model model, @PathVariable(required = false) Long id) {
        Board view = new Board();
        if(id != null) {
            boardCrudRepository.updateHit(id);
            view = boardRepository.findById(id).orElse(new Board());
        }
        model.addAttribute("view", view);
        return "board/write";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public String create(Board board, @PathVariable(required = false) Long id) {
        boardRepository.save(board);
        return "redirect:/board/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/update/{id}")
    public String update(Board board, @PathVariable Long id) {
        boardCrudRepository.update(board);
        return "redirect:/board/list";
    }

}
