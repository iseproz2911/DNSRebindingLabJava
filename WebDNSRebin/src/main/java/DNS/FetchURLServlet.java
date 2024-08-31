package DNS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FetchURLServlet")
public class FetchURLServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        if (isValidUrl(url, request)) {
            String content = fetchURL(url);
            request.setAttribute("content", content);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.getWriter().println("No access!");
        }
    }
    private boolean isValidUrl(String url, HttpServletRequest request) {
        if (url != null && !url.isEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                return false;
            }
            return true;
        }
        return false;
    }

//    private boolean isValidUrl(String url, HttpServletRequest request) {
//        if (url != null && !url.isEmpty()) {
//            if (!url.startsWith("http://") && !url.startsWith("https://")) {
//                return false;
//            }
//            try {
//            	//Check IP 
//                InetAddress serverAddress = InetAddress.getLocalHost();
//                String serverIp = serverAddress.getHostAddress();                
//                String urlIp = InetAddress.getByName(new URL(url).getHost()).getHostAddress();                
//                return serverIp.equals(urlIp);                
//            } catch (IOException e) {
//                e.printStackTrace();
//                return false;
//            }
//        }
//        return false;
//    }
    private String fetchURL(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
            
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error fetching content from URL.";
        }
    }
}
