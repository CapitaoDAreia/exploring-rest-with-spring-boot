package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Services.BookService;
import br.com.java.exploringrestwithspringboot.Utils.MediaType;
import br.com.java.exploringrestwithspringboot.VO.v1.BookVOv1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookControllerV1 {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{ID}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public BookVOv1 findById(@PathVariable(value = "ID") Long ID) {
        return this.service.findById(ID);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public List<BookVOv1> findAll() {
        return this.service.findAll();
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
    )
    public BookVOv1 create(@RequestBody BookVOv1 book) {
        return this.service.create(book);
    }

    @PutMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
    )
    public BookVOv1 update(@RequestBody BookVOv1 book) {
        return this.service.update(book);
    }

    @DeleteMapping(value = "/{ID}")
    public ResponseEntity<Object> delete(@PathVariable(value = "ID") Long ID) {
        this.service.delete(ID);
        return ResponseEntity.noContent().build();
    }
}
