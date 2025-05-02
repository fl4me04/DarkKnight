package index;

public class player extends Entity{
	private String currItem;

	public player(int hp, int basedmg, String currItem) {
		super(hp, basedmg);
		this.currItem = currItem;
	}

	public String getCurrItem() {
		return currItem;
	}

	public void setCurrItem(String currItem) {
		this.currItem = currItem;
	}
}
