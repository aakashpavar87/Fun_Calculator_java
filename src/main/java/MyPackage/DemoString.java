package MyPackage;

public class DemoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jokeString = "Knock, knock.\" \"Who's there?\"  [very long pause]  \"Java.";
		jokeString = jokeString.replaceAll("\"", "'");
		jokeString = jokeString.replaceAll("%20", " ");
		System.out.println(jokeString);
		
	}

}
