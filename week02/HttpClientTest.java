package week02.nio.nio01;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	
	//请求url
	private String url;
	
	public HttpClientTest(String url) {
		this.url=url;
	}
	
	//get方法
	private void getMethod() throws IOException{
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
 
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity, "UTF-8"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpGet.releaseConnection();
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		
		HttpClientTest httpClient=new HttpClientTest("http://localhost:8801");
		httpClient.getMethod();

	}

}
