package fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.entity.DemoEntity;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {

}
