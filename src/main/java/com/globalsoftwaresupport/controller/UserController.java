package com.globalsoftwaresupport.controller;

import com.globalsoftwaresupport.model.PatchUserRequest;
import com.globalsoftwaresupport.model.User;
import com.globalsoftwaresupport.model.UserTmp;
import com.globalsoftwaresupport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") String userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String userId) {
        userService.delete(Integer.valueOf(userId));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") String userId, @RequestBody PatchUserRequest request) {
        userService.update(userId, request);
    }

    // @PathVariable vs @RequestParam
    @GetMapping("/test/{id}/{name}")
    public void test1(@PathVariable int id, @PathVariable String name) {
        System.out.println("id: " + id + ", name: " + name );
    }

    // http://localhost:8080/v1/test?id=1&name=Adam
    @GetMapping("/test")
    public String test(@RequestParam int id, @RequestParam String name) {
        return ("id: " + id + ", name: " + name );
    }

    /**
     * Reading Headers
     */

    @GetMapping("/headers")
    public String headerInfo(@RequestHeader HttpHeaders headers) {
        return headers.getHost().getHostName() + " - " + headers.getHost().getPort();
    }

    @GetMapping("/headers/key")
    public String readHeaderKey(@RequestHeader("number") int num) {
        return "" + num;
    }

    @GetMapping("/headers/keies")
    public void readHeaderMultiKey(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, val) -> {
            System.out.println(key + " - " + val);
        });
    }

    @GetMapping("/headers/must-key")
    public String readHeaderMandatoryKey(@RequestHeader(value = "Mandatory-key", required = true) String val) {
        return val;
    }

    @GetMapping("/headers/default-value")
    public ResponseEntity<String> readHeaderWithDefaultValue(@RequestHeader(value = "number1", defaultValue = "100") int num) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("own-property", "properties value");
        return new ResponseEntity<>("This is the default value:  " + num, headers, HttpStatus.ACCEPTED);
    }

    /**
     * Json tests for Date
     */
    @GetMapping("/test2")
    public UserTmp test2() {
        return new UserTmp(100L,"first", "last", "email", new Date());
    }

    @PostMapping("/test3")
    public void test3(@RequestBody UserTmp userTmp) {
        System.out.println(userTmp.getDate());
    }
}
