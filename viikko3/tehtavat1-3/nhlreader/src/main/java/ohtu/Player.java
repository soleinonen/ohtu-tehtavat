
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String nationality;

    public String getNationality() {
		return nationality;
	}

	public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getGoals() {
    	return goals;
    }

    public int getAssists() {
		return assists;
	}
    
    public String getTeam() {
    	return team;
    }
    
    @Override
    public int compareTo(Player other) {
    	int pointDiff = (other.goals+other.assists)-(this.goals+this.assists);
    	if(pointDiff != 0) {
    		return pointDiff;
    	} else {
    		return (other.goals - this.goals);
    	}
    }

	@Override
    public String toString() {
        //return name+" "+team+" "+goals+"+ "+assists;
		return String.format("%-20s %-6s %2d + %2d = %-2d", name, team, goals, assists, goals+assists);
	}
      
}
