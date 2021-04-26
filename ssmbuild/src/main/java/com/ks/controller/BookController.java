package com.ks.controller;

import com.ks.pojo.Books;
import com.ks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "book";
    }

    // 跳转到添加页面
    @GetMapping("/toAddBook")
    public String addPaper(){
        return "addBook";
    }

    // 添加书籍
    @PostMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @GetMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    // 跳转到修改页面, 通过url的id参数，后端query对应的book实例
    // toUpdateBook?id=xxx
    @GetMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    // 修改书籍, 前端post的参数和后端Books实体类对应
    @PostMapping("/updateBook")
    public String updateBook(Books books){ // 前端参数
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
}
