package dar.kz.academy.clientcoreapi.repository;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ClientRepo extends CrudRepository<ClientEntity, Long> {
    ClientEntity getClientEntityByClientId(String clientId);
    List<ClientEntity> getClientEntitiesBy();

    @Transactional
    void deleteByClientId(String clientId);
}
