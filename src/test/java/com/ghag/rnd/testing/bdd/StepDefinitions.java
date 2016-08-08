package com.ghag.rnd.testing.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class StepDefinitions {
	private Belly belly;
	private int waitingTime;

	@Given("^I have (\\d+) cukes in my belly$")
	public void i_have_cukes_in_my_belly(int cukes) throws Throwable {
		System.out.println("inside given");
		belly = new Belly();
		belly.eat(cukes);
	}

	@When("^I wait (\\d+) hour$")
	public void i_wait_hour(int waitingTime) throws Throwable {
		System.out.println("inside when");
		this.waitingTime = waitingTime;
	}

	@Then("^my belly should (.*)$")
	public void my_belly_should_growl(String expectedSound) throws Throwable {
		String actualSound = belly.getSound(waitingTime);
		assertThat(actualSound, is(expectedSound));
		System.out.println("inside then after assert success");
	}
}
