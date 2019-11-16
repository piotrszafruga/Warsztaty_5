package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;
    private static long number;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
        number = list.size() + 1;
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

    //7.1:
    public Book getBook(long id) {

        Book result = list
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        return result;
    }

    //7.2:
    public void addBook(Book book) {
        if (book.getId() == 0) {
            book.setId(number);
            number += 1;
        }
        list.add(book);
    }

    //8.1:
    public void changeBook(Book book) {
        Book oldBook = getBook(book.getId());
        if (oldBook != null) {
            list.remove(oldBook);
            list.add(book);
        }
    }

    public void deleteBook(long id) {
        Book result = getBook(id);
        if (result != null) {
            list.remove(result);
        }
    }


}
