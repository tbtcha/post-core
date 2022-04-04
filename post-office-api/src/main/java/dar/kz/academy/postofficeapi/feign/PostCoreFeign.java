package dar.kz.academy.postofficeapi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("post-core-api")
public interface PostCoreFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/post/{postId}", produces = "application/json")
    PostCoreModel getPostCoreById(@PathVariable("postId") String id);
}

