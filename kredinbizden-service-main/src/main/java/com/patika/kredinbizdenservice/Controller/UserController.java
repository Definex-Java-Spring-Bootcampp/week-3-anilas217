package com.patika.kredinbizdenservice.Controller;

import com.patika.kredinbizdenservice.Service.IApplicationService;
import com.patika.kredinbizdenservice.Service.IUserService;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IApplicationService applicationService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        System.out.println("userService: " + userService.hashCode());
        return userService.save(user);
    }

    /*
    get all users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

 /*   @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }   */


    /*
    List all application
    */
    @GetMapping("/{email}/applications")
    public ResponseEntity<List<Application>> getAllApplication(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return ResponseEntity.ok().body(applicationService.getAllAplication(email, user));
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user) {

        User user1 = userService.update(email, user);

        if (user1 != null) {
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{bankName}")
    public ResponseEntity<List<Application>> GarantiBankApplication(@PathVariable String bankName, @RequestBody User user) {

        return userService.applicationVIAbankName(bankName, user);
    }


   /* @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }*/
}