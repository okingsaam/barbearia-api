package com.barbearia.barbearia_api.security;

import com.barbearia.barbearia_api.infrastructure.entity.Usuario;
import com.barbearia.barbearia_api.infrastructure.repository.UsuarioRepository;
import com.barbearia.barbearia_api.security.dto.AuthResponse;
import com.barbearia.barbearia_api.security.dto.LoginRequest;
import com.barbearia.barbearia_api.security.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setRole("ROLE_USER");

        usuarioRepository.save(usuario);

        String token = jwtService.gerarToken(usuario.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        String token = jwtService.gerarToken(usuario.getEmail());
        return new AuthResponse(token);
    }
}