public class EnRouteSalute
{
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(answer("--->-><-><-->-"));
		System.out.println(answer(">----<"));
		System.out.println(answer("<<>><"));
	}
	
	public static int answer(String s) 
	{ 
		s = s.replace("-","");
		int empStart  = 0;
		empStart = s.indexOf(">", empStart);
		int count = 0;
		
		while(empStart!=-1)
		{
			count += countEmpFromRight(empStart,s);
			empStart = s.indexOf(">", empStart+1);
		}
		
		empStart  = s.indexOf("<", 0);
		while(empStart!=-1)
		{
			count += countEmpFromLeft(empStart,s);
			empStart = s.indexOf("<", empStart+1);
		}
		return count;
    } 
    public static int countEmpFromLeft(int start,String s)
    {
    	int count=0;
    	for(int i=start-1;i>=0;i--)
    	{
    		if(s.charAt(i) == '>')
    			count++;
    	}
    	return count;
    }
    public static int countEmpFromRight(int start,String s)
    {
    	int len = s.length();
    	int count=0;
    	for(int i=start+1;i<len;i++)
    	{
    		if(s.charAt(i) == '<')
    			count++;
    	}
    	return count;
    }
}
