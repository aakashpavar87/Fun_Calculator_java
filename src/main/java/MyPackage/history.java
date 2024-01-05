package MyPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Servlet implementation class history
 */
public class history extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession(false);
        ArrayList<Double> history = (ArrayList<Double>) session.getAttribute("history");

        PrintWriter out = response.getWriter();
		out.append("<div style=\"display:flex;align-items:center;justify-content:center;flex-direction:column;color:royalblue\">");
		out.append("<h1>History Results : </h1><br>");
//		out.append("<h3>"+ results.toString() +"</h3><br>");
        out.append("<ul>");
        if (history != null) {
            Iterator<Double> iterator = history.iterator();
            while (iterator.hasNext()) {
                out.append("<li>" +iterator.next() + "</li>");
            }
        }else {
        	out.append("<br><h1>Sorry History is not available</h1>");
        }
        out.append("</ul>");
        out.append("<br><a href='index.html'>Home</a>");
        out.append("</div>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		Cookie cookies[] = request.getCookies();
//		HttpSession session = request.getSession(false);
//		ArrayList<String> results = new ArrayList<>();
//		int len = Integer.parseInt((String) session.getAttribute("result_length"));
//
//		for(int i=0; i<len; i++) {
//			String result = (String) session.getAttribute("result"+i);
//			results.add(result);
//		}
//		request.getRequestDispatcher("History").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
