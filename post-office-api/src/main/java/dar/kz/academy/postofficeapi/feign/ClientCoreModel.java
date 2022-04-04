package dar.kz.academy.postofficeapi.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientCoreModel {
    @NotNull
    public String id;
    @NotNull
    public String name;
    @NotNull
    public String surname;
    @NotNull
    @Email
    public String email;
}
