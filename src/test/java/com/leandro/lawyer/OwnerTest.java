package com.leandro.lawyer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.leandro.lawyer.model.Owner;
import com.leandro.lawyer.repository.OwnerRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OwnerTest extends LaywerApplication {

	@Autowired
	private TestEntityManager em;

	@Autowired
	OwnerRepo repo;

	@Test
	public void testExample() {
		Owner o1 = new Owner(0L, "Leandro", "Tester", null);

		repo.save(o1);

		List<Owner> oList = (List<Owner>) repo.findAll();
	}
}