package org.example.tennisv3.controller;
import org.example.tennisv3.model.User;
import org.example.tennisv3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    // Testirano i ispravno
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }
// Testirano i ispravno, dodaje i rolu i usera za novog korisnika
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
                userService.saveUser(user);
    }
// Testirano i ispravno
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
// Testirano i ispravno
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
    }


}


