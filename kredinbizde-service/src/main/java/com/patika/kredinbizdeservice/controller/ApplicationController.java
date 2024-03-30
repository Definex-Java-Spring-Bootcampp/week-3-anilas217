package com.patika.kredinbizdeservice.controller;


import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.IApplicationService;
import com.patika.kredinbizdeservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    private IApplicationService applicationService;


    //Injection controller
    @Autowired
    public ApplicationController(IApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application UserApplication(@RequestBody Application application){
        return (Application) applicationService.addApplication(application);
    }


}
