package fa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Integer> {
//	@Query(value = "Select * From content c Where c.author_id = :authorID", nativeQuery = true)
//	List<ContentEntity> findAllContentByAuthor_Id(@Param("authorID") Integer authorId);
	
	List<ContentEntity> findAllContentByAuthor_Id(Integer authorId);

	Optional<ContentEntity> findContentById(Integer id);
	
	Optional<ContentEntity> findContentByIdAndAuthor_Id(Integer id, Integer authorId);
	
	List<ContentEntity> findAllContentByAuthorIdAndContentContaining(Integer authorId, String content);
}
