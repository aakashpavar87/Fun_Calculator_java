package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int num1= Integer.parseInt(request.getParameter("num1"));
		int num2= Integer.parseInt(request.getParameter("num2"));
		String[] jokes = {
				"Why Java Developers wear Glasses because they cant' C",
				"Python developers feel frustrated when it comes jump in Java",
				"Java Programmer is always a Ninja Worrior",
				"Java and C talking C points to a reference but Java doesn't have pointers HAHAHA"
		};
		double result = 0;
		
		String op = request.getParameter("btn");
		switch(op) {
		case "add":
			result = num1 + num2;
			break;
		case "sub":
			result = num1 - num2;
			break;
		case "mul":
			result = num1 * num2;
			break;
		case "div":
			try {
			result = num1 / num2;
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		}
		String myurl = "https://v2.jokeapi.dev/joke/Any?type=single&contains=java";
		URL url = new URL(myurl);

		//Open Connection
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		//Add Input Stream
		InputStream iStream = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(iStream);
//		
		//Declare Write String
		StringBuilder cont = new StringBuilder();
		
		//Scanning Data and Storing Data
		Scanner sc = new Scanner(isr);
		while (sc.hasNext()) {
			cont.append(sc.nextLine());
		}
//		 Collecting Data from JSON Format
		Gson gson = new Gson();
//		String joke = cont.toString().replaceAll("\"", "\\\"");
////		joke = joke.replaceAll(" ","");
		JsonObject jsonObject = gson.fromJson(cont.toString(), JsonObject.class);

		String randomJoke = jsonObject.get("joke").getAsString();
//		int idx = (int)(Math.random()*(jokes.length-1));
//		String randomJoke = jokes[idx];
		randomJoke = randomJoke.replaceAll("\"", "'");
		randomJoke = randomJoke.replaceAll("\\[|\\]", "");
//		randomJoke = randomJoke.replaceAll("]", " ");
        HttpSession session = request.getSession(true);

        // Get calculation history from session
        ArrayList<Double> history = (ArrayList<Double>) session.getAttribute("history");

        // If history doesn't exist, create a new one
        if (history == null) {
            history = new ArrayList<>();
        }

        // Add the current result to history
        history.add(result);

        // Update session with the new history
        session.setAttribute("history", history);
        String send_url = "NewFile.jsp?result="+(int)result+"&joke="+randomJoke;
//		response.sendRedirect(send_url.replaceAll("joke=([^&]*)", "joke=$1".replaceAll(" ", "%20")));
        response.sendRedirect(send_url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
