import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ElevatorMaintenance
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] list = new String[]{"2.1.2", "1","1.0","2.1.19","1.0.0","3.17","4.21.7", "1.3.3", "1.0.12", "1.0.2","2.19.1","2.2"};
		
		System.out.println(Arrays.deepToString(answer(list)));
	}
	
	public static String[] answer(String[] l)
	{
		ArrayList<Version> versions = new ArrayList<Version>();
		String[] sortedArray = new String[l.length];
		for(String version:l)
		{
			versions.add(new Version(version));
		}
		Collections.sort(versions);
		int index=0;
		for(Version version: versions)
		{
			sortedArray[index++] = version.toString();
		}
		return sortedArray;
	}

	private static class Version implements Comparable<Version>
	{
		int major = -1;
		int minor = -1;
		int revisionVersion = -1;
		
		public Version(String version)
		{
			String[] versions = version.split("\\.");
			
			if(versions.length == 0)
				major = Integer.parseInt(version);
			else
				major = Integer.parseInt(versions[0]);
			
			if(versions.length>1)
				minor = Integer.parseInt(versions[1]);
			
			if(versions.length>2)
				revisionVersion = Integer.parseInt(versions[2]);
		}
		
		
		@Override
		public String toString()
		{
			String string="";
			
			string += major;
			if(minor!=-1)
			{
				string += "." + minor;
			}
			if(revisionVersion!=-1)
			{
				string += "." + revisionVersion;
			}
			
			return string;
		}
		
		public int compareTo(Version v)
		{
			if (this.major > v.major)
				return 1;
			else if(this.major==v.major)
			{
				if(this.minor>v.minor)
					return 1;
				else if(this.minor==v.minor)
				{
					if (this.revisionVersion>v.revisionVersion)
						return 1;
					if(this.revisionVersion==v.revisionVersion)
						return 0;
					else
						return -1;
				}
				else
					return -1;
			}
			else
				return -1;
		}
	}
	
}
