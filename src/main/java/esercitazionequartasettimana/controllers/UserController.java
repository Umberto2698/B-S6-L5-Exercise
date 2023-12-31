package esercitazionequartasettimana.controllers;

import esercitazionequartasettimana.enteties.User;
import esercitazionequartasettimana.exceptions.BadRequestException;
import esercitazionequartasettimana.payloads.users.UserDTO;
import esercitazionequartasettimana.payloads.users.UserUpdateInfoDTO;
import esercitazionequartasettimana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String orderBy) {
        return userService.getUsers(page, size, orderBy);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Validated UserDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return userService.save(body);
        }
    }

    @PutMapping("/{id}")
    public User updateUserInfo(@PathVariable UUID id, @RequestBody @Validated UserUpdateInfoDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return userService.update(id, body);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
        userService.delete(id);
    }

    @PatchMapping("/{id}/upload")
    public User updateUserPicture(@RequestParam("avatar") MultipartFile body, @PathVariable UUID id) throws IOException {
        return userService.uploadPicture(body, id);
    }
}
