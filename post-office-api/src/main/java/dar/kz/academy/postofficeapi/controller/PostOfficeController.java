package dar.kz.academy.postofficeapi.controller;

import dar.kz.academy.postofficeapi.model.PostOfficeModel;
import dar.kz.academy.postofficeapi.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
public class PostOfficeController {

    @Autowired
    PostOfficeService postOfficeService;

    @GetMapping("/check")
    public String checkHealth(){
        return "post-office working...";
    }

    @GetMapping("/{id}")
    public PostOfficeModel getPostOfficeById(@PathVariable String id){
        return postOfficeService.getPostOfficeById(id);
    }
}
