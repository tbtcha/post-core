package dar.kz.academy.postofficeapi.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCoreModel {
    public String postId;
    @NotNull
    public String clientId;
    @NotNull
    public String postRecipientId;
    @NotNull
    public String postItem;
    public String status;
}
