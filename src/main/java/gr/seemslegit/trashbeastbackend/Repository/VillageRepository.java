package gr.seemslegit.trashbeastbackend.Repository;

import gr.seemslegit.trashbeastbackend.Model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {


    Village findByName(String name);
    List<Village> findAll();
    List<Village> findAllByVisited(boolean TRUE);
}
