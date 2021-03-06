package com.example.library.authors;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class AuthorController {
    
	@Autowired
	private AuthorService authorDataService;
	
	
	@ApiOperation(value = "View a list of all Authors", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@GetMapping("/getAllAuthors")
	public List<Author> getAllAuthors() {

		return authorDataService.getAllAuthors();

	}
    
	@ApiOperation(value = "Add Author")
	@PostMapping("/addAuthor")
	public String addAuthor(@RequestBody Author author) {
		return authorDataService.addAuthor(author);
		//return "added";
	}
    
	@ApiOperation(value = "Delete an Author using author ID ")
	@PostMapping("/deleteAuthor/{id}")
	public String removeAuthor( @ApiParam(value = "AuthorId of the Author To be deleted", required = true) @PathVariable Integer id) {
		return authorDataService.deleteAuthor(id);
		//return "deleted";
	}
	
	@ApiOperation(value = "Update an Author using author ID and all attributes of Author")
	@PostMapping("/updateAuthor")
	public String updateAuthor(@RequestBody Author author) {
		return authorDataService.addAuthor(author);
		//return "updated";
	}

}
