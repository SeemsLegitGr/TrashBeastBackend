package gr.seemslegit.trashbeastbackend.Repository;

import gr.seemslegit.trashbeastbackend.Model.Path;
import gr.seemslegit.trashbeastbackend.Model.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathRepository extends JpaRepository<Path, Long> {

    List<Path> findByOrigin(Village village);
}
