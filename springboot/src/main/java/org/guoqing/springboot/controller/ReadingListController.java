package org.guoqing.springboot.controller;

import org.guoqing.springboot.dao.ReadingListRepository;
import org.guoqing.springboot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-21
 */
@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    @Autowired
    private ReadingListRepository readingListRepository;

    @GetMapping(value = "/{reader}")
    public String readerBooks(@PathVariable String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    public String addToReadingList(@PathVariable("reader") String reader,
                                   Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}
