package folha.rodrigo.login_auth_api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import folha.rodrigo.login_auth_api.domain.user.User;
import folha.rodrigo.login_auth_api.dto.LoginRequestDTO;
import folha.rodrigo.login_auth_api.dto.LoginResponseDTO;
import folha.rodrigo.login_auth_api.dto.RegisterRequestDTO;
import folha.rodrigo.login_auth_api.infra.security.TokenService;
import folha.rodrigo.login_auth_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("User not found!"));
        if(passwordEncoder.matches(dto.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO dto) {
        Optional<User> user = userRepository.findByEmail(dto.email());
        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setName(dto.name());
            newUser.setEmail(dto.email());
            newUser.setPassword(passwordEncoder.encode(dto.password()));
            userRepository.save(newUser);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new LoginResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    
}
