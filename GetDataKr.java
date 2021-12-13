import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

//	Get ��� ���۵� Client Form Data ó��

public class GetDataKr extends HttpServelt {

	// 1. Client Get ������� Request :: doGet() method O/R
	// 2. service() O/R ����
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//�Ʒ��� �� ���๮�� servlet���� client�� html�� ���۽� �ʼ� �ڵ�
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();

		//client from data(QueryString :: name=value) ó�� (APIȮ��)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		//16���� ���ڵ��� client from data  �ѱ� ���ڵ�
		String clientNameKo = this.convertKo(clientName);
		String clientAddrKo = convertKo(clientAddr);

		//client from data ��� (����� ??)
		System.out.println(clientNameKo + " : " + clientAddrKo);

		out.println("<html>");
		out.println("<head><title>GetDataKr.java</title></head>");
		out.println("<body>");

		out.println("<h2>Get Test Kr </h2>");
		out.println("<li> �̸� : "+clientNameKo);
		out.println("<li> �ּ� : "+clientAddrKo);

		out.println("<p><p><a href='/edu/getDataKr.html'>�ڷ�</a>");

		out.println("</body>");
		out.println("</html>");

	}

	//Method
	private String convertKo(String paramValue) {
		String convertParamValue = null;
		try	{
			//==>API�� Ȯ��
			byte[] b = paramValue.getBytes("8859_1");
			convertParamValue = new String(b, "EUC_KR");
		}	catch (UnsupportedEncodingException uee)	{
			System.out.println("�ѱ� ��ȯ�� Exception �߻�");
			uee.printStackTrace();
		}
		return convertParamValue;
	}

	
}//end of class
