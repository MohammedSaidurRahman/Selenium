package com.qa.StackCucumber;

import com.graphbuilder.struc.Stack;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import static org.junit.Assert.assertEquals;

public class StackSteps {

	StackExample stack;
	String string;

	@Given("^an empty stack$")
	public void an_empty_stack() {
		// Write code here that turns the phrase above into concrete actions

		stack = new StackExample();
		assertEquals(0, stack.size());
	
	}

	@When("^I push an item into the stack$")
	public void i_push_an_item_into_the_stack() {
		// Write code here that turns the phrase above into concrete actions
		stack.push("1");
		assertEquals(1, stack.size());
	}

	@Then("^the stack contains one item$")
	public void the_stack_contains_one_item() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(1, stack.size());
		
	}

	@When("^I push another item into the stack$")
	public void i_push_another_item_into_the_stack() {
		// Write code here that turns the phrase above into concrete actions
		stack.push("2");
		assertEquals(2, stack.size());
		
	}

	@Then("^the stack contains two items$")
	public void the_stack_contains_two_items() {
		// Write code here that turns the phrase above into concrete actions
		
		assertEquals(2, stack.size());
	}

	@When("^I pop from the stack$")
	public void i_pop_from_the_stack() {
	    // Write code here that turns the phrase above into concrete actions
		stack.size();
		stack.pop();
		assertEquals(0, stack.size());
	}

	@Then("^I get the same item back$")
	public void i_get_the_same_item_back() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//System.out.println(string);
	}

	@Given("^a full stack$")
	public void a_full_stack() {
		// Write code here that turns the phrase above into concrete actions
		//stack.size();
	}

}