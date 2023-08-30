package br.com.java.exploringrestwithspringboot.Controllers;

import br.com.java.exploringrestwithspringboot.Utils.MediaType;
import br.com.java.exploringrestwithspringboot.VO.v1.PersonVOv1;
import br.com.java.exploringrestwithspringboot.Services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "Endpoints to manage people")
public class PersonController {

    @Autowired
    private PersonServices service;

    @CrossOrigin(origins = {"http://localhost:8080"})
    @GetMapping(value = "/{ID}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find a person", description = "Find a person", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PersonVOv1.class))}),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

    })
    public PersonVOv1 findById(@PathVariable(value = "ID") Long ID) {
        return service.findById(ID);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all people", description = "Find all people", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PersonVOv1.class))
                    )
            }),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),

    })
    public List<PersonVOv1> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Create one person", description = "Define the request content type choosing between yml, json or xml", tags = {"People"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {@Content(schema = @Schema(implementation = PersonVOv1.class))}),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public PersonVOv1 create(@RequestBody PersonVOv1 person) {
        return service.create(person);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Update one person", description = "Update one person", tags = {"People"}, responses = {
            @ApiResponse(description = "Updated", responseCode = "200", content = {@Content(schema = @Schema(implementation = PersonVOv1.class))}),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public PersonVOv1 update(@RequestBody PersonVOv1 person) {
        return service.update(person);
    }

    @CrossOrigin(origins = {"http://localhost:8080"})
    @DeleteMapping(value = "/{ID}")
    @Operation(summary = "Delete one person", description = "Delete one person", tags = {"People"}, responses = {
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<Object> delete(@PathVariable(value = "ID") Long ID) {
        service.delete(ID);
        return ResponseEntity.noContent().build();
    }
}

