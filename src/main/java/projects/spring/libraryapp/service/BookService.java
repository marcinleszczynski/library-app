package projects.spring.libraryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.spring.libraryapp.model.Book;
import projects.spring.libraryapp.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public String addBook(Book book) {
        try {
            bookRepository.save(book);
            return "Book was added succesfuly";
        } catch(Exception e) {
            return "Error occured :( book was not added";
        }
    }

    public String deleteBook(Integer id) {
        try {
            bookRepository.deleteById(id);
            return "book was deleted";
        } catch(Exception e) {
            return "book was not deleted";
        }
    }

    public Book getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }
}
