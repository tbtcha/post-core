package dar.kz.academy.postofficeapi.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MunicipalDTO {
    private String OfficeId;
    private MunicipalTypesModel Type;
    private String ClientId;
    private String Status;
    private int Price;
    private Date CreatedDate;
    private Date PaymentDate;
}
