package org.example.dto.category;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CategoryCreateDTO {
    private String name;
    private MultipartFile image; // MultipartFile - значить що сюди треба передавати файл
    private String description;
}
