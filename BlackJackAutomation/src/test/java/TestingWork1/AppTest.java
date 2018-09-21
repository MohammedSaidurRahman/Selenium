package TestingWork1;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest 
   
{
	App blackJack;
	
	@Before
	public void setUp() {

		blackJack = new App();
	}
	
	
	@Test
	public void test() {
	
		assertEquals(2, blackJack.play(1, 2));
	}
	
	
	@Test
	public void charTest() {
	
		assertEquals(0, blackJack.play(0,0));
	}
	
	@After
	public void tearDown() {

	}
	

	
	
	
}

