package br.com.supportcomm.virtualgoods.simulator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URIException;


@WebServlet("/ask_auth")
public class AskAuthorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIRTUAL_GOODS_URL = "http://localhost:8080/VirtualGoods/services/authorize";
	
	private static final String PARAM_MSISDN = "msisdn";
	private static final String PARAM_MSG = "message";
	private static final String PARAM_ID_MSG = "mid";
	private static final String AND = "&";
	private static final String PARAM_START = "?";
	private static final String EMPTY_STRING = "";
	private static final String EQUALS = "=";
	private static final String QUOTE = "\"";
       
    public AskAuthorization() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doGet of Authorize"); //Enter here when the originator was by putting manually the URL in the browser.
		sendAuthorization(request);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doPost of Authorize"); //Enter here when submitting a form, or not via manually entering the URL in the browser.
		sendAuthorization(request);
	}

	private void sendAuthorization(HttpServletRequest request) throws URIException, IOException, HttpException {

//		System.out.println("Thread sleep....Waiting 1 minute after sending authorization");	
//		try {
//			Thread.sleep(1000*60); // sleep 1 minute after send authorization.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Thread Waiking up....Sending Authorization");
		
		
//		HttpClient httpClient = new HttpClient();
//		PostMethod post = new PostMethod(VIRTUAL_GOODS_URL);
//		post.addParameter(PARAM_MSISDN, NVL(request.getParameter(PARAM_MSISDN),EMPTY_STRING));
//		post.addParameter(PARAM_MSG, NVL(request.getParameter(PARAM_MSG),EMPTY_STRING));
//		post.addParameter(PARAM_ID_MSG, NVL(request.getParameter(PARAM_ID_MSG),EMPTY_STRING));
		
		StringBuffer sbf = new StringBuffer();
		sbf.append(VIRTUAL_GOODS_URL).append(PARAM_START);
		sbf.append(PARAM_MSISDN).append(EQUALS).append(NVL(request.getParameter(PARAM_MSISDN),EMPTY_STRING));
		sbf.append(AND);
		sbf.append(PARAM_MSG).append(EQUALS).append(QUOTE).append(NVL(request.getParameter(PARAM_MSG),EMPTY_STRING)).append(QUOTE);
		sbf.append(AND);
		sbf.append(PARAM_ID_MSG).append(EQUALS).append(NVL(request.getParameter(PARAM_ID_MSG),EMPTY_STRING));
		
		System.out.println("URL to authorize Billing: " + sbf.toString());
		
		
//		System.out.println("Posting to the URL: " + post.getURI());
//		System.out.println("Path: " + post.getPath());
//		System.out.println("Query String" + post.getQueryString());
//		System.out.println("getParams" + post.getParams().toString());
//		System.out.println("getParameters" + post.getParameters().toString());
//		System.out.println("getRequestHeaders" + post.getRequestHeaders().toString());
		
//		httpClient.executeMethod(post);
//		if (post.getStatusCode() == 200) {
//			System.out.println("OK! Status Code was 200");
//		} else { 
//			System.out.println("Error! Status Code was:" + post.getStatusCode());
//		}
	}
	
	public <T> T NVL(T a, T b) {
		return (a == null)?b:a;
	}


}
