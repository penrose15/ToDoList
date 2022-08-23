package com.ToDoList.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter// pageInfo와 Data를 리스트로 응답하기 위해 만든 DTO
public class MultiResponseDto<T> {
    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page page) {
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber(),
                page.getSize(), page.getTotalElements(),
                pageInfo.getTotalPages());
    }
}
