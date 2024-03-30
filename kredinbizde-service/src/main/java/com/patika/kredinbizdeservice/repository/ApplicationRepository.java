package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {
    Application application = new Application();
    User user = new User();
    private List<Application> applicationList = new ArrayList<>();

    public void save(Application application) {
        applicationList.add(application);
    }

    public List<Application> getAll() {
        return applicationList;
    }
    public List<Application> getAllByUser(User user) {
        return applicationList.stream()
                .filter(application-> application.getUser().equals(user)).toList();
    }

}
