package br.com.java.exploringrestwithspringboot.Services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.java.exploringrestwithspringboot.Controllers.BookControllerV1;
import br.com.java.exploringrestwithspringboot.Exceptions.BookNotFoundException;
import br.com.java.exploringrestwithspringboot.Mapper.ModelMapper;
import br.com.java.exploringrestwithspringboot.Model.Book;
import br.com.java.exploringrestwithspringboot.Repositories.BookRepository;
import br.com.java.exploringrestwithspringboot.VO.v1.BookVOv1;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    BookRepository repository;

    public List<BookVOv1> findAll(){
        logger.info("Finding all books");

        List<Book> entities = this.repository.findAll();
        List<BookVOv1> vo = ModelMapper.parseListObjects(entities, BookVOv1.class);

        vo
                .forEach(b -> b.add(
                        linkTo(
                                methodOn(BookControllerV1.class).findById(b.getId())
                        ).withSelfRel()
                ));

        logger.info("Returning all books");

        return  vo;
    }

    public BookVOv1 findById(@NotNull Long ID){
        logger.info("Searching for a book of id: " + ID);

        Book entity = this.repository.findById(ID)
                .orElseThrow(() -> new BookNotFoundException("Book not founded: " + ID));

        BookVOv1 vo = ModelMapper.parseObject(entity, BookVOv1.class);

        vo.add(
                linkTo(
                        methodOn(BookControllerV1.class).findById(vo.getId())
                ).withSelfRel()
        );

        logger.info("Returning a book of id: " + ID);

        return  vo;
    }

    public BookVOv1 create(@NotNull BookVOv1 book){
        logger.info("Creating a book: " + book);

        Book entity = ModelMapper.parseObject(book, Book.class);

        Book createdBook = this.repository.save(entity);

        BookVOv1 vo = ModelMapper.parseObject(createdBook, BookVOv1.class);

        vo.add(
                linkTo(
                        methodOn(BookControllerV1.class).findById(vo.getId())
                ).withSelfRel()
        );

        logger.info("Book created | ID: " + vo.getId());

        return  vo;
    }

    public BookVOv1 update(@NotNull BookVOv1 book){
        logger.info("Searching for a book to update | ID: " + book.getId());

        Book entity = this.repository.findById(book.getId())
                .orElseThrow(() -> new BookNotFoundException("No book records found for ID: " + book.getId()));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setTitle(book.getTitle());
        entity.setPrice(book.getPrice());

        logger.info("Updating book of ID: " + entity.getId());

        Book savedEntity = this.repository.save(entity);

        BookVOv1 vo = ModelMapper.parseObject(savedEntity, BookVOv1.class);

        vo.add(
                linkTo(
                        methodOn(BookControllerV1.class).findById(vo.getId())
                ).withSelfRel()
        );

        return vo;
    }

    public void delete(Long ID){
        logger.info("Searching book of ID: " + ID);
        Book entity = this.repository.findById(ID)
                .orElseThrow(() -> new BookNotFoundException("No book records found for ID: " + ID));

        logger.info("Deleting book of ID: " + ID);
        this.repository.delete(entity);
    }
}
