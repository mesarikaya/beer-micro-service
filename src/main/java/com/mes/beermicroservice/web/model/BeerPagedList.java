package com.mes.beermicroservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by mesar on 2/11/2020
 */
public class BeerPagedList extends PageImpl<BeerDto> {

    public BeerPagedList(List<BeerDto> content, Pageable pageable,  long total){
        super(content,  pageable, total);
    }

    public BeerPagedList(List<BeerDto> content){
        super(content);
    }
}
