package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController  //dla json
@RequestMapping("/books")
public class BookController {
    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/memoryBooks")
    public List<Book> memoryBooks() {
        List<Book> list = memoryBookService.getList();
        return list;
    }

    //7.1:
    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable long id) {
        Book result = memoryBookService.getBook(id);
        return result;
    }

    //7.2:
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){
       memoryBookService.addBook(book);
       // book zbierany z formularza, lub z jsona (gdyby uzyc JavaScript)
    }

    //8.1:
    @PutMapping("/changeBook")
    public void changeBook(@RequestBody Book book) {
        memoryBookService.changeBook(book);
    }

    //8.2:
    @PutMapping("/deleteBook")
    public void deleteBook(@RequestParam long id) {
        memoryBookService.deleteBook(id);
    }
}
