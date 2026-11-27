package a26.web2.service_a.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import a26.web2.service_a.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    Message findFirstByMessageIs(String bdMessage);
}
