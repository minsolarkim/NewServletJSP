import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServletService extends HttpServlet {

	// init() ==> 금번 예제 method overriding no need

	// service() method Overriding
	public void service(HttpServletRequest req, HtttpServletResponse res) throws ServletException, IOException {
		System.out.println(" :: servlet service() 시작 ");
		System.out.println(" Requerst Client IP  : " + req.getRemoteAddr() );

		//한글 처리
		res.setContentType("text/html");
		//res.setContentType("text/html;charset=EUC_KR");

		//1.client Html Text 전송 위한 Stream을 생성
		//OutputStream outputStream = rew.getOutputStream();
		//Writer writer = new OutputStreamWriter(outputStream);
		//PrintWriter out = new PrintWriter(writer);

		//2. PrintWriter 인스턴스 생성을 Encapsulation 한 API 사용 Stream 생성
		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<head><title>hello Servlet</title></head>");
		out.println("<body>");
		out.println("English : HelloServlet");
		out.println("<p>");
		out.println("Korea : 헬로 서블릿");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();

		System.out.println("::servlet service() 종료\n");

	}

	/// destroy() ==> 금번 예제 method overriding no need

	
}
