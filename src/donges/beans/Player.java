package donges.beans;

import java.util.Hashtable;

import com.mongodb.BasicDBObject;

import donges.util.BeanUtils;

public class Player extends BeanUtils
{

	/**
	 * empty constructor
	 */
	public Player()
	{
	}
	
	/**
	 * populates a Player object from a BasicDBObject  
	 */
	public Player(BasicDBObject obj) 
	{
		convertDBObjectToPlayer(obj);
	}	
	
	/**
	 * populates a Player object from data passed
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param teamName
	 * @param position
	 */
	public Player(int id, String firstName, String lastName, String teamName, String position)
	{
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setTeamName(teamName);
		setPosition(position);
	}
	
	// --------------------------------------------------------------------------------------	
	// variables
	private String[] cols = {"id", "firstName","lastName","teamName","position","games"};
	private Hashtable<String,Object> data;
	private String json;
	
	// --------------------------------------------------------------------------------------
	// other methods
    /**
	 * converts a Player object into a BasicDBObject (mongodb)
	 * @return BasicDBObject
	 */
	public BasicDBObject convertPlayerToBasicDBObject()
	{
		BasicDBObject obj = convertObjectToBasicDBObject(data);
		setJson(obj.toString());
		return obj;
	}
	
	/**
	 * converts a BasicDBObject (mongodb) into a Player
	 * @param obj
	 */
	public void convertDBObjectToPlayer(BasicDBObject obj)
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
		return generateLogEntry(data, "Player"); 
	}
	
	/**
	 * prints log entry to sysout
	 */
	public void show() 
	{ 
		printToOut(generateLogEntry(data, "Player")); 
	}
	
	// --------------------------------------------------------------------------------------
	// getters and setters
	public String getJson() { return this.json; }
	public int getId() { return Integer.parseInt(data.get("id").toString()); }
	public String getFirstName() { return data.get("firstName").toString(); }
	public String getLastName() { return data.get("lastName").toString(); }
	public String getTeamName() { return data.get("teamName").toString(); }
	public String getPosition() { return data.get("position").toString(); }
	public Hashtable<String,Object> getGames() { return (Hashtable)data.get("games"); }
	
	public void setJson(String json) { this.json = json; }
	public void setId(int id) { data.put("id", String.valueOf(id)); }
	public void setFirstName(String firstName) { data.put("firstName",firstName); }
	public void setLastName(String lastName) { data.put("lastName",lastName); }
	public void setTeamName(String teamName) { data.put("teamName",teamName); }
	public void setPosition(String position) { data.put("position",position); }
	public void setGames(Hashtable<String,Object> games) { data.put("games",games); }
}
