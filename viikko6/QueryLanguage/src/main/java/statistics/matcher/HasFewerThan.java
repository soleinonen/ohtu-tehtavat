package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher{
	Matcher m;
	
	public HasFewerThan(int value, String fieldname) {
		this.m = new Not(new HasAtLeast(value, fieldname));
	}
	
	@Override
	public boolean matches(Player p) {
		return this.m.matches(p);
	}

}
