package com.example.azsserver.authentication;

import com.example.azsserver.appuser.AppUser;
import com.example.azsserver.appuser.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<AppUser> auth (@RequestBody AuthRequest request) {
        return ResponseEntity.ok(userService.authUser(new AppUser(request.getUsername(), request.getPassword())));
    }
}
