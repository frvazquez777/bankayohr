package com.frvazquez.bankayohr.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frvazquez.bankayohr.domain.Request;

@SpringBootTest
public class RequestRepositoryTest {

	@Autowired
	RequestRepository repository;

	@Test
	@Transactional
	public void saveTest() {
		Request request = new Request();
		request.setIpOrigen("192.168.0.1");
		request.setMetodo("demo");
		repository.save(request);

		Optional<Request> newRequest = repository.findById(1L);
		assertEquals("192.168.0.1", newRequest.get().getIpOrigen());
	}

}
