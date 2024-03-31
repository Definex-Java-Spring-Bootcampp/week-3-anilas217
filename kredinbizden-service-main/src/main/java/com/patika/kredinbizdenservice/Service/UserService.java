package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User update(String email, User user) {
        return null;
    }

    @Override
    public ResponseEntity<List<Application>> applicationVIAbankName(String bankName, User user) {
        return null;
    }
}
