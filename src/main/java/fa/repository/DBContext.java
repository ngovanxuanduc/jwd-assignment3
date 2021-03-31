package fa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
public class DBContext {
	@Autowired
	public MemberRepository memberRepository;
	
}
