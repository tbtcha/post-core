package dar.kz.academy.postofficeapi.service;

import dar.kz.academy.postofficeapi.feign.*;
import dar.kz.academy.postofficeapi.model.MunicipalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class MunicipalService {

    @Autowired
    PaymentFeign paymentFeign;

    @Autowired
    ClientFeign clientFeign;

    public MunicipalModel getClientMunicipalList(String id, Pageable pageable){
        Page<MunicipalDTO> municipalDTOS = paymentFeign.getOffices(id, pageable);
        int total = 0;
        Iterator iterator = municipalDTOS.iterator();
        while (iterator.hasNext()){
            MunicipalDTO municipalDTO = (MunicipalDTO) iterator.next();
            total+=municipalDTO.getPrice();
        }
        MunicipalModel municipalModel = new MunicipalModel(clientFeign.getClientById(id), total, municipalDTOS);
        return municipalModel;
    }
}
