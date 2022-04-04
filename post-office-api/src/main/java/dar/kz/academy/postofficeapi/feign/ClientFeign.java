package dar.kz.academy.postofficeapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("client-core-api")
public interface ClientFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/client/{clientId}", produces = "application/json")
ClientCoreModel getClientById(@PathVariable("clientId") String id);
}

