package com.reda.gestionStockR1.services.Implementation;

import com.reda.gestionStockR1.dto.CategoryDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.InvalidEntityException2;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.repository.CategoryRepository;
import com.reda.gestionStockR1.services.CategoryService;
import com.reda.gestionStockR1.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiseImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiseImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("L(Objet category n'est pas valid");
            throw new InvalidEntityException2("La Category n'est pas valid",
                    ErrorsCode.CATEGORY_NOT_FOUND,
                    errors);
        }

        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id ");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity).orElseThrow(()->
                        new NotFoundException("La category avec l'd " + id +" n'existe pas ",
                                ErrorsCode.CATEGORY_NOT_FOUND));

    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id ");
            return ;
        }
        categoryRepository.deleteById(id);

    }
}
