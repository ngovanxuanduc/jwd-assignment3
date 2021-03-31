package fa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.entity.DemoEntity;
import fa.repository.DemoRepository;

@Service
public class DemoServices {
	@Autowired
	private DemoRepository demoRepository;

	public List<String> getAllNameDemoEntity() {
		return demoRepository.findAll().stream().map(DemoEntity::getName).collect(Collectors.toList());
	}

	public void saveTenEntity() {
		for (int i = 0; i < 10; i++) {
			demoRepository.save(new DemoEntity("name: " + i));
		}
	}
}
