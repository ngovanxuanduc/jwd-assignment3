package fa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.entity.ContentEntity;
import fa.payload.response.ViewContentResp;
import fa.repository.DBContext;

@Service
public class ContentService {

	@Autowired
	private DBContext dbContext;
	
	public List<ViewContentResp> getAllAuthorizedContent(int authorId){
		dbContext.contentRepository.findAllContentByAuthorId(authorId).forEach(System.out::println);
		return dbContext.contentRepository.findAllContentByAuthorId(authorId)
				.stream().map(this::toDTO)
				.collect(Collectors.toList());
	}
	
	private ViewContentResp toDTO(ContentEntity entity) {
		return ViewContentResp.builder()
				.title(entity.getTitle())
				.brief(entity.getBrief())
				.createDate(entity.getCreateDate())
				.build();
	}
}
