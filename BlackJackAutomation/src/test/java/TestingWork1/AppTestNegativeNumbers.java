package TestingWork1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class AppTestNegativeNumbers {
	
	App blackJack;
	
	@Before
	public void setUp() {
		blackJack = new App();
	}
	
	@Test
	public void negativeNum() {
	//  App blackJack = new App();
		assertEquals(-2, blackJack.play(-5, -2));
	}
	
/*
	@Parameters
	public static Collection<Object[]>data() {
		return Arrays.asList(new Object[][] { {-1, -1,-1},{-2,-2},{-3,-3}});
	}
	
	private int intPut;
	private int intPut2;
	private int intPected;
	
	public ExampleTest(int input, int input2, int expected) {
		intPut = input;
		intPut2 = input2;
		intPected = expected;
	}
	
	@Test
	public void test() {
		assertEquals(intPected, App.play(intPut, intPut2));
	}
	
	*/

}

