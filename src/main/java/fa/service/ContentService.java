package fa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.entity.ContentEntity;
import fa.entity.MemberEntity;
import fa.payload.request.ContentReq;
import fa.payload.response.ViewContentResp;
import fa.repository.DBContext;

@Service
public class ContentService {

	@Autowired
	private DBContext dbContext;
	
	public ContentReq getContentByIdAndAuthorId(int id, int authorId) {
//		return toDTO(dbContext.contentRepository.findOne(id));
//		return dbContext.contentRepository.findContentById(id)
		return dbContext.contentRepository.findContentByIdAndAuthor_Id(id, authorId)
				.map(this::toDTOReq)
				.orElse(null);
	}
		
	public List<ViewContentResp> getAllAuthorizedContent(int authorId){
//		dbContext.contentRepository.findAllContentByAuthorId(authorId).forEach(System.out::println);
		return dbContext.contentRepository.findAllContentByAuthor_Id(authorId)
				.stream().map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	public List<ViewContentResp> getAllAuthorizedContent(int authorId, String content){
//		dbContext.contentRepository.findAllContentByAuthorIdAndContentContaining(authorId, content).forEach(System.out::println);
		return dbContext.contentRepository.findAllContentByAuthorIdAndContentContaining(authorId, content)
				.stream().map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	private ViewContentResp toDTO(ContentEntity entity) {
		return ViewContentResp.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.brief(entity.getBrief())
				.createDate(entity.getCreateDate())
				.build();
	}
	
	private ContentReq toDTOReq(ContentEntity entity) {
		return ContentReq.builder()
				.id(entity.getId())
				.title(entity.getTitle())
				.brief(entity.getBrief())
				.content(entity.getContent())
				.build();
	}
	
	public ContentEntity save(ContentReq contentReq, MemberEntity author) {
		ContentEntity con = ContentEntity.builder()
//				.id(contentReq.getId() )
				.title(contentReq.getTitle())
				.brief(contentReq.getBrief())
				.content(contentReq.getContent())
				.author(author)
				.build();
		if (contentReq.getId() != null) {
			con.setId(contentReq.getId());
		}		
		return dbContext.contentRepository.save(con);
	}
	
	public boolean deleteContent(int id, int authorId) {
		//kiem tra co phai author khong roi hay xoa
		Optional<ContentEntity> conOP = dbContext.contentRepository.findContentByIdAndAuthor_Id(id, authorId);
		if (conOP.isPresent()) {
			dbContext.contentRepository.delete(conOP.get());
			return true;
		} 
		return false;
	}
	
}
