package com.example.test.controller;

import com.example.test.service.EmpService;
import com.example.test.service.TestBoardService;
import com.example.test.service.impl.BoardCrudRepository;
import com.example.test.service.impl.BoardRepository;
import com.example.test.vo.Board;
import com.example.test.vo.Emp;
import com.example.test.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class GetAPIController {

    @Autowired
    TestBoardService testBardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardCrudRepository boardCrudRepository;

    @Autowired
    EmpService empService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/emplist")
    public ResponseEntity getRequestEmp(Model model) {
        List<EmpVO> list = empService.getEmpList();
        model.addAttribute("list", list);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/listTest")
    public ResponseEntity getRequestTest(Model model) {
        List<Board> list = testBardService.getBoardTest();
        model.addAttribute("list", list);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String getRequest(Model model, @PageableDefault(size = 2) Pageable pageable) {

        Page<Board> list = boardRepository.findAll(pageable);

        int startPage = Math.max(1,list.getPageable().getPageNumber()-2);
        int endPage = Math.max(list.getTotalPages(), list.getPageable().getPageNumber()+2);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("list", list);
        model.addAttribute("getTotalElements", list.getTotalElements());
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
