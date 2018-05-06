package gr.seemslegit.trashbeastbackend.Repository;

import java.util.List;

import gr.seemslegit.trashbeastbackend.Model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {

    Village findByName(String name);
    List<Village> findAll();
}
