package external;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;

public class TwitterAdapter extends Thread implements UpdaterAdaptor {
	Twitter twitter = null;
	String status = null;

	@Override
	public void updateStatus(String status) {
		this.status = status;
		this.start();
	}
	
	@Override
	public void run() {
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer("55UBNPdRH5HHxhqvwO3CA", "K78Y1nXB4FFBj090JU0DXvW8R5hiMPzafdA75LMFoM");

		AccessToken accessToken = new AccessToken("16651861-QkvFwrUfdSJKXdL5ME43vaOotBoAJzeSfyKh7sKH5", "WxukElyHKAzNumVTGeLXpAuMDAyzLa8aMeoKVUlAAI");
		twitter.setOAuthAccessToken(accessToken);

		try {
			twitter.updateStatus(status);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
