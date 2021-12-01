package everis.com.micrometer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {
	
	private Counter counter;
	
	public TestController(MeterRegistry mRegistry) {
		
		this.counter = Counter.builder("hello.invokations").description("Total invokations").register(mRegistry);
		
	}
	
	@GetMapping(path = "test")
	public String test() {
		counter.increment();
		
		return "Test";
	}

}
