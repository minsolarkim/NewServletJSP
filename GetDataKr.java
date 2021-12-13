import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

//	Get 방식 전송된 Client Form Data 처리

public class GetDataKr extends HttpServelt {

	// 1. Client Get 방식으로 Request :: doGet() method O/R
	// 2. service() O/R 가능
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//아래의 두 실행문은 servlet에서 client로 html을 전송시 필수 코딩
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		//client from data(QueryString :: name=value) 처리 (API확인)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		//16진수 인코딩된 client from data  한글 디코딩
		String clientNameKo = this.convertKo(clientName);
		String clientAddrKo = convertKo(clientAddr);

		//client from data 출력 (출력은 ??)
		System.out.println(clientNameKo + " : " + clientAddrKo);

		out.println("<html>");
		out.println("<head><title>GetDataKr.java</title></head>");
		out.println("<body>");

		out.println("<h2>Get Test Kr </h2>");
		out.println("<li> 이름 : "+clientNameKo);
		out.println("<li> 주소 : "+clientAddrKo);

		out.println("<p><p><a href='/edu/getDataKr.html'>뒤로</a>");

		out.println("</body>");
		out.println("</html>");

	}

	//Method
	private String convertKo(String paramValue) {
		String convertParamValue = null;
		try	{
			//==>API를 확인
			byte[] b = paramValue.getBytes("8859_1");
			convertParamValue = new String(b, "EUC_KR");
		}	catch (UnsupportedEncodingException uee)	{
			System.out.println("한글 변환중 Exception 발생");
			uee.printStackTrace();
		}
		return convertParamValue;
	}

	
}//end of class
