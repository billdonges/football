package donges.beans;

import java.util.Hashtable;

import com.mongodb.BasicDBObject;

import donges.util.BeanUtils;

public class Week extends BeanUtils
{
	/**
	 * empty constructor
	 */
	public  Week()
	{
	}
	
	/**
	 * populates a Player object from a BasicDBObject  
	 */
	public  Week(BasicDBObject obj) 
	{
		convertDBObjectToWeek(obj);
	}	
	
	/**
	 * populates a Player object from data passed
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param teamName
	 * @param position
	 */
	public  Week(int weekNum, String date, Player qb1, Player rb1, Player rb2, Player wr1, Player wr2, Player flex1, Player k, Player def)
	{
	}
	
	// --------------------------------------------------------------------------------------	
	// variables
	private String[] cols = {"weekNum","date","qb", "rb1","rb2","wr1","wr2","flex1","k","def"};
	private Hashtable<String,Object> data;
	private String json;
	
	// --------------------------------------------------------------------------------------
	// other methods
    /**
	 * converts a Week object into a BasicDBObject (mongodb)
	 * @return BasicDBObject
	 */
	public BasicDBObject convertWeekToBasicDBObject()
	{
		BasicDBObject obj = convertObjectToBasicDBObject(data);
		setJson(obj.toString());
		return obj;
	}
	
	/**
	 * converts a BasicDBObject (mongodb) into a Week
	 * @param obj
	 */
	public void convertDBObjectToWeek(BasicDBObject obj)
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
		return generateLogEntry(data, "Week"); 
	}
	
	/**
	 * prints log entry to sysout
	 */
	public void show() 
	{ 
		printToOut(generateLogEntry(data, "Week")); 
	}
	
	// --------------------------------------------------------------------------------------
	// getters and setters  "weekNum","date","qb", "rb1","rb2","wr1","wr2","flex1","k","def"
	public String getJson() { return this.json; }
	public int getWeekNum() { return Integer.parseInt(data.get("weekNum").toString()); }
	public String getDate() { return data.get("date").toString(); }
	public Player getQb() { return (Player)data.get("qb"); }
	public Player getRb1() { return (Player)data.get("rb1"); }
	public Player getRb2() { return (Player)data.get("rb2"); }
	public Player getWr1() { return (Player)data.get("wr1"); }
	public Player getWr2() { return (Player)data.get("wr2"); }
	public Player getFlex() { return (Player)data.get("flex"); }
	public Player getK() { return (Player)data.get("k"); }
	public Player getDef() { return (Player)data.get("def"); }	
	
	public void setJson(String json) { this.json = json; }
	public void setWeekNum(int weekNum) { data.put("weekNum",String.valueOf(weekNum)); }
	public void setDate(String date) { data.put("date",date); }
	public void setQb(Player qb) { data.put("qb",qb); }
	public void setRb1(Player rb1) { data.put("qb",rb1); }
	public void setRb2(Player rb2) { data.put("qb",rb2); }
	public void setWr1(Player wr1) { data.put("qb",wr1); }
	public void setWr2(Player wr2) { data.put("qb",wr2); }
	public void setFlex(Player flex) { data.put("qb",flex); }
	public void setK(Player k) { data.put("qb",k); }
	public void setDef(Player def) { data.put("qb",def); }
}
