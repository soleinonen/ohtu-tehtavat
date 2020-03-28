package statistics.matcher;

import statistics.Player;

public class Not implements Matcher{
	Matcher m;
	
	public Not(Matcher m) {
		this.m = m;
	}
	
	@Override
	public boolean matches(Player p) {
		return !this.m.matches(p);
	}
}
