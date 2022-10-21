package com.tdnhat.bookstore.book.boudary;

import com.tdnhat.bookstore.book.entity.Category;
import com.tdnhat.bookstore.book.entity.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public Response findAll() {
        return Response.ok().entity(categoryRepository.findAll()).build();
    }

    @GetMapping("/categories/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return Response.ok().entity(categoryRepository.findById(id)).build();
    }

    @GetMapping("/categories/{id}/books")
    public Response findBooksByCategoryId(@PathVariable("id") Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return Response.ok().entity(category.get().getBooks()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Not found books for category id").build();
        }
    }

    @PutMapping("/categories")
    public Response add(Category category) {
        this.categoryRepository.save(category);
        return Response.ok().build();
    }

    @DeleteMapping("/categories")
    public Response delete(Category category) {
        this.categoryRepository.delete(category);
        return Response.ok().build();
    }

    @DeleteMapping("/categories/{id}")
    public Response deleteById(@PathVariable("id") Long id) {
        this.categoryRepository.deleteById(id);
        return Response.ok().build();
    }
}
