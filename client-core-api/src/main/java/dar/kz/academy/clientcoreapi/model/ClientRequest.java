package dar.kz.academy.clientcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequest {
    @NotNull
    private String clientId;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull @Email
    private String email;
}
