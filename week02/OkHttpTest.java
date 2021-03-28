package week02.nio.nio01;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {
	
	private String url;
	
	public OkHttpTest(String url) {
		this.url=url;
	}
	
	
	private String run() throws IOException {
	OkHttpClient client = new OkHttpClient();
	  Request request = new Request.Builder()
	      .url(url)
	      .build();

	  try (Response response = client.newCall(request).execute()) {
	    return response.body().string();
	  }
	}
	
	public static void main(String[] args) throws IOException {
		OkHttpTest okHttp=new OkHttpTest("http://localhost:8801");
		System.out.println(okHttp.run());

	}

}
