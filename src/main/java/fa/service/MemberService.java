package fa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.entity.MemberEntity;
import fa.payload.request.EditUserReq;
import fa.repository.DBContext;

@Service
public class MemberService {
	@Autowired
	private DBContext dbContext;

	public MemberEntity addMember(MemberEntity member) {
		String time = "" + java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime();
		MemberEntity mem = MemberEntity.builder()
				.firstName("FName: " + time)
				.lastName("LName: " + time)
				.userName("uname-"+time)
				.password("pass-"+time)
				.phone(time)
				.email(time+"@gmail.com")
				.description("description: "+time)
				.build();

		return dbContext.memberRepository.save(mem);
	}
	
	
	public MemberEntity updateMember(EditUserReq memNew, MemberEntity memOld) {
		
		//set du lieu moi vao doi tuong cu
		memOld.setFirstName(memNew.getFirstName());
		memOld.setLastName(memNew.getLastName());
		memOld.setPhone(memNew.getPhone());
		memOld.setDescription(memNew.getDescription());
		
		return updateMember(memOld);
	}
	
	public MemberEntity updateMember(MemberEntity member) {
		return dbContext.memberRepository.save(member);
	}
	
	public MemberEntity login(String userName, String password) {
		return dbContext.memberRepository.findByUserNameAndPassword(userName, password)
				.orElse(null);
				
	}
	
	public MemberEntity register(String userName, String password, String email) {
		if (dbContext.memberRepository.existsByUserName(userName)) {
			System.out.println("username: "+userName+" ton tai roi ban eiiii");
			return null;
		}
		MemberEntity mem = MemberEntity.builder()
				.userName(userName)
				.password(password)
				.email(email)
				.build();
		return dbContext.memberRepository.save(mem);
	}
	
	public MemberEntity getMemberEntityById(int id) {
		return dbContext.memberRepository.findOne(id);
	}

//	public static void main(String[] args) throws InterruptedException {
//		
//		System.out.println(""+ java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime() );
//		Thread.sleep(1000);
//		System.out.println(""+ java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime() );
//	}
}
