package com.ztax.iam.module.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
public class Meta {

    private String title;
    private String icon;
    private boolean hidden;
    private boolean alwaysShow;
    private String moduelType;
    private List<String> roles;
}
