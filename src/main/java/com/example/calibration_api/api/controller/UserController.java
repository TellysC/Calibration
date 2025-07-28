package com.example.calibration_api.api.controller;

import com.example.calibration_api.api.dto.UserInputDTO;
import com.example.calibration_api.api.dto.UserOutDTO;
import com.example.calibration_api.assembler.UserAssembler;
import com.example.calibration_api.domain.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserAssembler userAssembler;
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutDTO add(@RequestBody final @Valid UserInputDTO userInputDTO) {
        return userAssembler.toDto(userService.register(userAssembler.toUser(userInputDTO)));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserOutDTO> update(@PathVariable final @NotNull Long userId, @RequestBody final @Valid UserInputDTO userInputDTO) {
        return ResponseEntity.ok(userAssembler.toDto(userService.update(userAssembler.toUser(userInputDTO), userId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public UserOutDTO consult(@PathVariable final @NotNull Long userId) {
        return userAssembler.toDto(userService.search(userId));
    }

    @GetMapping
    public List<UserOutDTO> list() {
        return userAssembler.toCollectionDto(userService.list());
    }
}
