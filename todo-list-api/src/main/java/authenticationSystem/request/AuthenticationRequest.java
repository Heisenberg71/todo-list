package authenticationSystem.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationRequest {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
