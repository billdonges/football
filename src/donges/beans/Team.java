package donges.beans;

import java.util.Hashtable;

import com.mongodb.BasicDBObject;

import donges.util.BeanUtils;

public class Team extends BeanUtils 
{
	/**
	 * empty constructor
	 */
	public Team()
	{
	}
	
	/**
	 * populates a Player object from a BasicDBObject  
	 */
	public Team(BasicDBObject obj) 
	{
		convertDBObjectToTeam(obj);
	}	
	

	public Team(int id, String teamName, String coach, String coachEmail, String place)
	{
		setId(id);
		setTeamName(teamName);
		
	}
	
	// --------------------------------------------------------------------------------------	
	// variables
	private String[] cols = {"id", "teamName","coach","coachEmail","place","team","weeks"};
	private Hashtable<String,Object> data;
	private String json;
	
	// --------------------------------------------------------------------------------------
	// other methods
    /**
	 * converts a GameStats object into a BasicDBObject (mongodb)
	 * @return BasicDBObject
	 */
	public BasicDBObject convertTeamToBasicDBObject()
	{
		BasicDBObject obj = convertObjectToBasicDBObject(data);
		setJson(obj.toString());
		return obj;
	}
	
	/**
	 * converts a BasicDBObject (mongodb) into a GameStats
	 * @param obj
	 */
	public void convertDBObjectToTeam(BasicDBObject obj)
	{
		setJson(obj.toString());
		data = convertBasicDBObjectToObject(obj, cols);
	}		
	
	/**
	 * generates string for log entry
	 * @return
	 */
	public String getLogEntry()	
	{ 
		return generateLogEntry(data, "Team"); 
	}
	
	/**
	 * prints log entry to sysout
	 */
	public void show() 
	{ 
		printToOut(generateLogEntry(data, "Team")); 
	}
	
	// --------------------------------------------------------------------------------------
	// getters and setters
	public String getJson() { return this.json; }
	public int getId() { return Integer.parseInt(data.get("id").toString()); }
	public String getTeamName() { return data.get("teamName").toString(); }
	public String getCoach() { return data.get("coach").toString(); }
	public String getCoachEmail() { return data.get("coachEmail").toString(); }
	public int getPlace() { return Integer.parseInt(data.get("place").toString()); }
	public Hashtable<String,Object> getPlayers() { return (Hashtable)data.get("players"); }
	public Hashtable<String,Object> getWeeks() { return (Hashtable)data.get("weeks"); }
	
	public void setJson(String json) { this.json = json; }
	public void setId(int id) { data.put("id", String.valueOf(id)); }
	public void setTeamName(String teamName) { data.put("teamName", teamName); }
	public void setCoach(String coach) { data.put("coach", coach); }
	public void setCoachEmail(String coachEmail) { data.put("coachEmail",coachEmail); }
	public void setPlace(int place) { data.put("place", String.valueOf(place)); }
	public void setPlayers(Hashtable<String,Object> players) { data.put("players", players); }
	public void setWeeks(Hashtable<String,Object> weeks) { data.put("weeks", weeks); }
	
	
}
