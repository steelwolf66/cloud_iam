package com.ztax.iam.module.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(value={"id","parentId"})
public class RouterVO {

    private String id;

    private String parentId;

    private String path;

    private String component;

    private String name;

    private Meta meta;

    private List<RouterVO> children;

}
