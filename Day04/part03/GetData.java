import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/*
	FileName : GetData.java  
	ㅇ  Get방식 전송된 Client Form Data 처리
*/
public class GetData extends HttpServlet{

	//	 1. Client Get 방식으로 Request  :: doGet() method O/R
	//	 2. service()  O/R 가능
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		//아래의 두실행문은  servlet에서 client로 Html을 전송시 필수 코딩
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		//client form data(QueryString :: name=value)처리 (API확인)
        String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
        
        //client form data 출력(출력은 ??)
        System.out.println(clientName+" : "+clientAddr);

		out.println("<html>");
		out.println("<head><title>GetData.java</title></head>");
		out.println("<body>");
		
		out.println("<h2>Get Test </h2>");
		out.println("<li> 이름 : "+clientName);
		out.println("<li> 주소 : "+clientAddr);

		out.println("<p><p><a href='/edu/getData.html'>뒤로</a>");

		out.println("</body>");
		out.println("</html>");
	}

}//end of class