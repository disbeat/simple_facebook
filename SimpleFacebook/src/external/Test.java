package external;
public class Test {
	public static void main(String[] args) {
		StatusUpdater su = new StatusUpdater();
		su.updateTwitterStatus("Testing my awful code... sry");
		su.updateFacebookStatus("Testing my awful code... fb");
	}
}
