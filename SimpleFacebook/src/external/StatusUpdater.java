package external;

public class StatusUpdater {
	public void updateStatus(String status) {
		// TODO: Commented for tests... uncomment on deployment
		UpdaterAdaptor updaters[] = { new TwitterAdapter(), new FacebookAdapter() };
		for (UpdaterAdaptor u : updaters)
		    u.updateStatus(status);
	}

	public void updateTwitterStatus(String text) {
		UpdaterAdaptor twitter = new TwitterAdapter();
		twitter.updateStatus(text);
	}

	public void updateFacebookStatus(String text) {
		UpdaterAdaptor fb = new FacebookAdapter();
		fb.updateStatus(text);
	}

}
