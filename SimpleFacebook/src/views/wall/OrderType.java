package views.wall;

public enum OrderType {
	LATEST(LatestOrderStrategy.class), 
	OLDER(OlderOrderStrategy.class), 
	TYPE(TypeOrderStrategy.class), 
	ACTIVITY(ActivityOrderStrategy.class);

	OrderStrategy c = null;

	OrderType(Class<? extends OrderStrategy> c) {
		try {
			this.c = (OrderStrategy) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OrderStrategy getInstance() {
		return c;
	}
}
