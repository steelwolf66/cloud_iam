package com.ztax.iam.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date gmtCreate;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Date gmtModified;
}