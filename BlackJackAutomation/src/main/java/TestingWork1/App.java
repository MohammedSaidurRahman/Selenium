package TestingWork1;

/**
 * Hello world!
 *
 */
public class App 
{
  
    
    
	public int play(int a, int b)
	{
		
		if (a > 21 &&  b > 21)
		{
			return 0;
		} 
		else if(a > 21 &&  b <  21)
		{
			return b;
		}
		else if (a < 21 &&  b > 21)
		{
			return a;
		}
		else if ( a >  b)
		{
			return a;
		}
		else if(b >  a)
		{
			return b;
		}
		else
		{
			return a;
		}
		
		
		
	} 
    
}


