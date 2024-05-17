package projects.spring.libraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projects.spring.libraryapp.model.Book;
import projects.spring.libraryapp.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/getBook")
    public ResponseEntity<Book> getBook(@RequestParam("id") Integer id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        String saved = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam("id") Integer id) {
        String deleted = bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
