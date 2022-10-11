package dar.kz.academy.postofficeapi.controller;

import dar.kz.academy.postofficeapi.model.MunicipalModel;
import dar.kz.academy.postofficeapi.service.MunicipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipal")
public class MunicipalController {

    @Autowired
    MunicipalService service;

    @GetMapping("/{id}")
    public MunicipalModel getMunicipal(@PathVariable String id, Pageable pageable){
        return service.getClientMunicipalList(id, pageable);
    }
}
