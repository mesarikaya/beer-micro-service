package com.mes.beermicroservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by mesar on 2/11/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @Null
    private UUID id;

    @Null
    private Long version;

    @Null
    @JsonFormat(pattern = "yyyy-MM--dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @Null
    @JsonFormat(pattern = "yyyy-MM--dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;

    @NotBlank
    @Size(min = 3, max = 100)
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyleEnum;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private int quantityOnHand;

    @Positive
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    /* @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate localDate;*/
}
