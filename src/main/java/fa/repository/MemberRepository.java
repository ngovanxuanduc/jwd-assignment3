package fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.entity.MemberEntity;
import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
	Optional<MemberEntity> findByUserNameAndPassword(String userName, String password);
	
	boolean existsByUserName(String userName);
}
