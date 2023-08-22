package org.example.controllers;

import jakarta.persistence.PostUpdate;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.dto.category.CategoryCreateDTO;
import org.example.dto.category.CategoryItemDTO;
import org.example.dto.category.CategoryUpdateDTO;
import org.example.entities.CategoryEntity;
import org.example.mappers.CategoryMapper;
import org.example.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // рест контролер який може видавати дані
@AllArgsConstructor // якщо в класі будуть приватні змінні, то він створить клас автоматично
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @GetMapping("/")
    public ResponseEntity<List<CategoryItemDTO>> index() {
        var categories = categoryRepository.findAll();
        var result = (ArrayList<CategoryItemDTO>) categoryMapper.listCategoriesToItemDTO(categories);
        return new ResponseEntity<>(result, HttpStatus.OK);

//        var result = new ArrayList<CategoryItemDTO>();
//        var item = new CategoryItemDTO();
//        item.setId(1);
//        item.setName("Шоколад");
//        item.setImage("chocolate.jpg");
//        item.setDescription("Шоколад для усіх");
//        result.add(item);
//        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/category")
    public CategoryEntity create(@RequestBody CategoryCreateDTO dto) {
        CategoryEntity cat = CategoryEntity
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .build();
        categoryRepository.save(cat);
        return cat;
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний Id категорії: " + id));
        categoryRepository.delete(category);
        return new ResponseEntity("Категорія видалена по Id: " + id, HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public  ResponseEntity update(@PathVariable("id") Integer id, @RequestBody CategoryUpdateDTO dto) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний Id категорії: " + id));

        category = CategoryEntity
                .builder()
                .id(id)
                .name(dto.getName())
                .description(dto.getDescription())
                .image((dto.getImage()))
                .build();

        categoryRepository.save(category);
        return new ResponseEntity("Категорія під #" + id + " була успішно обновлена", HttpStatus.OK);
    }
}
