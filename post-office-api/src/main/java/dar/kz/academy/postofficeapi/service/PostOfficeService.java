package dar.kz.academy.postofficeapi.service;

import dar.kz.academy.postofficeapi.feign.ClientCoreModel;
import dar.kz.academy.postofficeapi.feign.ClientFeign;
import dar.kz.academy.postofficeapi.feign.PostCoreFeign;
import dar.kz.academy.postofficeapi.feign.PostCoreModel;
import dar.kz.academy.postofficeapi.model.PostOfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeService {

    @Autowired
    PostCoreFeign postCoreFeign;

    @Autowired
    ClientFeign clientFeign;

    public PostOfficeModel getPostOfficeById(String id){
        PostCoreModel post = postCoreFeign.getPostCoreById(id);
        ClientCoreModel client = clientFeign.getClientById(post.getClientId());
        ClientCoreModel receiver = clientFeign.getClientById(post.getPostRecipientId());
        System.out.println(receiver);
        System.out.println(client);
        return new PostOfficeModel(post.getPostId(),client,receiver,post.getPostItem(),post.getStatus());
    }

}
