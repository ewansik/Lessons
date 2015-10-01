import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFormat {
	
	public String getFormat(String fileName)
	{
		Pattern pattern = Pattern.compile("\\.[a-z]+$");
		Matcher matcher = null;
		
		matcher = pattern.matcher(fileName);
		
		if(matcher.find())
		{
			fileName = fileName.substring(matcher.start(), matcher.end());
		}
		else
		{
			fileName = "Incorrect file name.";
		}
		
		return fileName;
	}
	
	public boolean checkFormat(String fileFormat)
	{
		String[] format = {".xml",".json"};
		
		boolean check = false;
		
		for (String string : format) {
			if(string.equals(fileFormat))
			{
				check = true;
			}
		}
		
		return check;
	}
}
