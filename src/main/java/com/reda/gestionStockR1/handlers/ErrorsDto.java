package com.reda.gestionStockR1.handlers;

import com.reda.gestionStockR1.exception.ErrorsCode;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorsDto {

    private Integer httpCode;

    private ErrorsCode errorsCode;

    private String message;

    private List<String> errorsList;
}
