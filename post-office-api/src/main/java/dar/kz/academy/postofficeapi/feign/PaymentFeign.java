package dar.kz.academy.postofficeapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("client-payment")
public interface PaymentFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/municipal/office/{id}", produces = "application/json")
    Page<MunicipalDTO> getOffices(@PathVariable("id") String id, Pageable pageable);

    @RequestMapping(method = RequestMethod.GET, value = "/municipal/types/{id}", produces = "application/json")
    MunicipalTypesModel getType(@PathVariable("id") String id);
}
