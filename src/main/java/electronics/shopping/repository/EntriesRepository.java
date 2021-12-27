package electronics.shopping.repository;

import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EntriesRepository extends JpaRepository<Entries, Long> {

    List<Entries> findAllById(long id);
    Entries getById(Long id);
    Entries save (Entries entries);
    }
