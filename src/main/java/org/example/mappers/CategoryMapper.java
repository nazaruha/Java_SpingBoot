package org.example.mappers;

import org.example.dto.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryItemDTO categoryToItemDTO(CategoryEntity category); // CategoryEntity - CategoryItemDTO
    List<CategoryItemDTO> listCategoriesToItemDTO(List<CategoryEntity> list); // з ліста в ліста
}
