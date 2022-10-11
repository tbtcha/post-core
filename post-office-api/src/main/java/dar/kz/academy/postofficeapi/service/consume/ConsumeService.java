package dar.kz.academy.postofficeapi.service.consume;

import dar.kz.academy.postofficeapi.feign.MunicipalOfficeModel;
import dar.kz.academy.postofficeapi.model.MunicipalModel;

public interface ConsumeService {
    void consumeMessage(MunicipalOfficeModel officeModel);
}
