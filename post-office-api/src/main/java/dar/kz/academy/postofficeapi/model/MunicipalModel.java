package dar.kz.academy.postofficeapi.model;

import dar.kz.academy.postofficeapi.feign.ClientCoreModel;
import dar.kz.academy.postofficeapi.feign.MunicipalDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MunicipalModel {
    private ClientCoreModel client;
    private int total;
    private Page<MunicipalDTO> officeModelPage;
}
