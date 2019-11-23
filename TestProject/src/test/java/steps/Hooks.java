package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println("TestCase Name" + sc.getName());
		System.out.println("TestCase Name" + sc.getId());
		System.out.println("TestCase Name" + sc.getStatus());
	}

	@After
	public void afterScenario(Scenario sc) {
		System.out.println("TestCase Name" + sc.getName());
		System.out.println("TestCase Name" + sc.getId());
		System.out.println("TestCase Name" + sc.getStatus());

	}

}
