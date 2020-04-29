package ku.opensrcsw._MidTerm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import midterm.problem2.RegularExpression;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 RegularExpression re = new RegularExpression();
    	
    	
		JSONParser jsonParser = new JSONParser();
		Object jsonObject = null;
		try {
			try {
				jsonObject = (JSONObject) jsonParser.parse(new FileReader("midterm.json"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("asdasd");
			e.printStackTrace();
		}
		System.out.print("Enter the patterm you are looking for : ");
		Scanner scan = new Scanner(System.in);
		String temp = scan.next();
		Object infoArray = ((JSONArray) jsonObject).get(temp);
		for(int i =0;i<((ArrayList) infoArray).size();i++) {
			if(re.check((String)infoArray, temp)) {
				System.out.println(infoArray);
			}

		}
    }
}
