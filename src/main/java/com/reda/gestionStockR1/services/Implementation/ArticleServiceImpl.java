package com.reda.gestionStockR1.services.Implementation;


import com.reda.gestionStockR1.dto.ArticleDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.InvalidEntityException2;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.repository.ArticleRepository;
import com.reda.gestionStockR1.services.ArticleService;
import com.reda.gestionStockR1.validator.ArticleValidator;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collector;

@Service
@Slf4j // pour le login , fourni un logger
public class ArticleServiceImpl implements ArticleService {


    ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("L'objet article n'est pas valid !!");
            throw new InvalidEntityException2("Article n'est pas valid", ErrorsCode.ARTICLE_NOT_FOUNT,errors);
        }

        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Long id) {
        if (id == null){
            log.error("L'id ne doit pas etre null !! ");
        }
        return articleRepository.findById(id)
                .map(ArticleDto::fromEntity).orElseThrow(() ->
                        new NotFoundException("l'article avec l'id " + id + "n'existe pas",
                                ErrorsCode.ARTICLE_NOT_FOUNT));
        //return articleDto;

    }

    @Override
    public ArticleDto findArticleByNom(String nom) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {

        return  articleRepository.findAll()
                .stream().map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id ");
            return ;
        }
        articleRepository.deleteById(id);
    }
}
