package com.mes.beermicroservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mes.beermicroservice.web.model.BeerDto;
import com.mes.beermicroservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "dev.mes", uriPort = 80)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    ObjectMapper objectMapper;

    BeerDto validBeer;

    ConstrainedFields fields;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {

        validBeer = BeerDto.builder()
                .id(null)
                .beerName("Efes")
                .beerStyleEnum(BeerStyleEnum.BLONDE)
                .price(new BigDecimal("6.55"))
                .quantityOnHand(10)
                .upc(123456789012L)
                .build();
        fields = new ConstrainedFields(BeerDto.class);
    }

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(get("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("/v1/beer-get",
                        pathParameters(
                                parameterWithName("beerId").description("UUID of desired beer to get.")
                        ),
                        responseFields(
                                fields.withPath("id").description("Id of Beer").type(UUID.class),
                                fields.withPath("version").description("Version number").type(Long.class),
                                fields.withPath("createdDate").description("Date Created").type(OffsetDateTime.class),
                                fields.withPath("lastModifiedDate").description("Date Updated").type(OffsetDateTime.class),
                                fields.withPath("beerName").description("Beer Name").type(String.class),
                                fields.withPath("beerStyleEnum").description("Beer Style").type(Enum.class),
                                fields.withPath("upc").description("UPC of Beer").type(Long.class),
                                fields.withPath("price").description("Price").type(BigDecimal.class),
                                fields.withPath("quantityOnHand").description("Quantity On Hand").type(Integer.class)
                        )
                ));
    }

    @Test
    void saveNewBeer() throws Exception {

        BeerDto beerDto = validBeer;
        String beetDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beetDtoJson))
                .andExpect(status().isCreated())
                .andDo(document("/v1/beer-new",
                        requestFields(
                                fields.withPath("id").ignored().type(UUID.class),
                                fields.withPath("version").ignored().type(Long.class),
                                fields.withPath("createdDate").ignored().type(OffsetDateTime.class),
                                fields.withPath("lastModifiedDate").ignored().type(OffsetDateTime.class),
                                fields.withPath("beerName").description("Beer Name").type(String.class),
                                fields.withPath("beerStyleEnum").description("Beer Style").type(Enum.class),
                                fields.withPath("upc").description("UPC of Beer").type(Long.class),
                                fields.withPath("price").description("Price").type(BigDecimal.class),
                                fields.withPath("quantityOnHand").ignored().type(Integer.class)
                        )
                ));
    }

    @Test
    void updateBeerId() throws Exception {

        BeerDto beerDto = validBeer;
        String beetDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beetDtoJson))
                .andExpect(status().isNoContent())
                .andDo(document("/v1/beer-update",
                        pathParameters(
                                parameterWithName("beerId").description("UUID of desired beer to get.")
                        ),
                        requestFields(
                                fields.withPath("id").ignored().type(UUID.class),
                                fields.withPath("version").ignored().type(Long.class),
                                fields.withPath("createdDate").ignored().type(OffsetDateTime.class),
                                fields.withPath("lastModifiedDate").ignored().type(OffsetDateTime.class),
                                fields.withPath("beerName").description("Beer Name").type(String.class),
                                fields.withPath("beerStyleEnum").description("Beer Style").type(String.class),
                                fields.withPath("upc").description("UPC of Beer").type(Long.class),
                                fields.withPath("price").description("Price").type(BigDecimal.class),
                                fields.withPath("quantityOnHand").ignored().type(Integer.class)
                        )
                ));
    }

    @Test
    void deleteBeerById() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/{beerId}", UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(document("/v1/beer-delete",
                        pathParameters(
                                parameterWithName("beerId").description("UUID of desired beer to delete.")
                        )
                ));
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }
}

