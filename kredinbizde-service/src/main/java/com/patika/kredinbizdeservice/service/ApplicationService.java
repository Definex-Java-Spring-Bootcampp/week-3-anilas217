package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApplicationService implements IApplicationService{

    private ApplicationRepository applicationRepository = new ApplicationRepository();
    @Override
    public List<Application> getAllAplication(String email, User user) {
        List<Application> applicationslists = new ArrayList<>();
        return applicationRepository.getAllByUser(user);
    }

    @Override
    public Object addApplication(Application application) {
        applicationRepository.save(application);
        return application;
    }
}
