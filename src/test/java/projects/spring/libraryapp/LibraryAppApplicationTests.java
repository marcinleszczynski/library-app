package projects.spring.libraryapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootTest
class LibraryAppApplicationTests {
	@Autowired
	private ResourceLoader resourceLoader;


	@Test
	void contextLoads() {
	}

	@Test
	public void testLoadFromClasspath() {
		Resource resource = resourceLoader.getResource("persistence.properties");
		assertTrue(resource.exists());
	}

}
