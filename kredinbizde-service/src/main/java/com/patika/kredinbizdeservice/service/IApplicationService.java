package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;

import java.util.List;

public interface IApplicationService {
    List<Application> getAllAplication(String email, User user);

    Object addApplication(Application application);
}
