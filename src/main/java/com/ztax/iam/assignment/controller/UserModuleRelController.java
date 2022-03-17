package com.ztax.iam.assignment.controller;


import com.ztax.iam.assignment.entity.UserModuleRel;
import com.ztax.iam.assignment.service.impl.UserModuleRelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

;

@RestController
@RequestMapping("/assignment")
public class UserModuleRelController{
    @Autowired
    private UserModuleRelServiceImpl userModuleRelService;

    @PostMapping("/grant")
    public void grant(@RequestBody List<UserModuleRel> paramList){

        userModuleRelService.grant(paramList);
    }
}