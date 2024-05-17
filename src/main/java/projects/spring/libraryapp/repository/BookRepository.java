package projects.spring.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.spring.libraryapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}
