package dar.kz.academy.postofficeapi.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MunicipalTypesModel {
    private String TypeId;
    private String CompanyName;
    private String TypeName;
}
