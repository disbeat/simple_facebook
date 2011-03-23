package external;

import com.restfb.DefaultLegacyFacebookClient;
import com.restfb.LegacyFacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;

public class FacebookAdapter extends Thread implements UpdaterAdaptor {
	LegacyFacebookClient facebookClient = null;
	String status = null;

	@Override
	public void updateStatus(String status)  {
		this.status = status;
		this.start();
	}
	
	@Override
	public void run(){
		// Steal it from: http://restfb.com/
		// FACEBOOK_API_KEY = "179749792052791";
		// FACEBOOK_API_SECRET = "94d96ebd0bdeb73513003044b096dbc0";
		// https://graph.facebook.com/oauth/authorize?client_id=MY_API_KEY& redirect_uri=http://www.facebook.com/connect/login_success.html& scope=publish_stream,offline_access,create_event
		// https://graph.facebook.com/oauth/access_token?client_id=MY_API_KEY& redirect_uri=http://www.facebook.com/connect/login_success.html& client_secret=MY_API_SECRET&code=MY_VERIFICATION_CODE
		String access_token = "179749792052791|f08f28fe9096c79d3d8b4c34-774633581|7MMX-B9N9AaIioxHEgZytbeAwTU";
		facebookClient = new DefaultLegacyFacebookClient(access_token);
		
		try {
			facebookClient.execute("stream.publish", String.class, Parameter.with("message", status));
		} catch(FacebookException e) {
			e.printStackTrace();
		}
	}
}
