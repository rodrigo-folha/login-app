package folha.rodrigo.login_auth_api.dto;

public record RegisterRequestDTO(
    String name,
    String email,
    String password
) {
    
}
