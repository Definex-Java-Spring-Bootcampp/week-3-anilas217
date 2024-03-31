package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ApplicationService implements IApplicationService {
    @Override
    public List<Application> getAllAplication(String email, User user) {
        return null;
    }
}
