package dar.kz.academy.postofficeapi.model;

import dar.kz.academy.postofficeapi.feign.ClientCoreModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostOfficeModel {
    @NotNull
    private String postId;
    @NotNull
    private ClientCoreModel client;
    @NotNull
    private ClientCoreModel postRecipient;
    @NotNull
    private String postItem;
    private String status;
}
