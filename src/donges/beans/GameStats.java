package donges.beans;

import java.util.Hashtable;

import com.mongodb.BasicDBObject;

import donges.util.BeanUtils;

public class GameStats extends BeanUtils
{

	// --------------------------------------------------------------------------------------
	// constructors
	
	/**
	 * empty constuctor
	 */
	public GameStats()
	{
	}
	
	/**
	 * populates a GameStats object from a BasicDBObject  
	 * @param obj
	 */
	public GameStats(BasicDBObject obj) 
	{
		convertDBObjectToGameStats(obj);
	}	
	
	/**
	 * populates a GameStats object from data passed
	 * @param id
	 * @param teamId
	 * @param weekNum
	 * @param opponent
	 * @param passingYards
	 * @param passingTds
	 * @param passingPoints
	 * @param rushingYards
	 * @param rushingTds
	 * @param rushingPoints
	 * @param receivingYards
	 * @param receivingTds
	 * @param receivingPoints
	 * @param fumblesLost
	 * @param intThrows
	 * @param turnOverPoints
	 * @param extraPoints
	 * @param fg0to30
	 * @param fg31to40
	 * @param fg41to50
	 * @param fg51plus
	 * @param kickingPoints
	 * @param intMade
	 * @param fumblesRecovered
	 * @param defPoints
	 * @param total
	 */
	public GameStats(int id, int teamId, int weekNum, String opponent, int passingYards, int passingTds, int passingPoints, 
			int rushingYards, int rushingTds, int rushingPoints, int receivingYards, int receivingTds, int receivingPoints, 
			int fumblesLost, int intThrown, int turnOverPoints, int extraPoints, int fg0to30, int fg31to40, int fg41to50,
			int fg51plus, int kickingPoints, int intMade, int fumblesRecovered, int defPoints, int total, Player player)
	{
		setId(id);
		setTeamId(teamId);
		setWeekNum(weekNum);
		setOpponent(opponent);
		setPassingYards(passingYards);
		setPassingTds(passingTds);
		setPassingPoints(passingPoints);
		setRushingPoints(rushingYards);
		setRushingTds(rushingTds);
		setRushingPoints(rushingPoints);
		setReceivingYards(receivingYards);
		setReceivingTds(receivingTds);
		setReceivingPoints(receivingPoints);
		setFumblesLost(fumblesLost);
		setIntThrown(intThrown);
		setTurnOverPoints(turnOverPoints);
		setExtraPoints(extraPoints);
		setFg0to30(fg0to30);
		setFg31to40(fg31to40);
		setFg41to50(fg41to50);
		setFg51plus(fg51plus);
		setKickingPoints(kickingPoints);
		setIntMade(intMade);
		setFumblesRecovered(fumblesRecovered);
		setDefPoints(defPoints);
		setTotal(total);
		setPlayer(player);
	}
	
	
	// --------------------------------------------------------------------------------------
	// variables
	private String[] cols = {"id", "teamId", "weekNum", "opponent", "player", "passingYards", "passingTds", "passingPoints", "rushingYards", "rushingTds", "rushingPoints", 
			"receivingYards", "receivingTds", "receivingPoints", "fumblesLost", "intThrows", "turnOverPoints", "extraPoints", "fg0to30", "fg31to40", "fg41to50",
			"fg51plus", "kickingPoints","intMade","fumblesRecovered","defPoints","total"};
	private Hashtable<String,Object> data = new Hashtable<String,Object>();
	private String json;
	
	// --------------------------------------------------------------------------------------
	// other methods
    /**
	 * converts a GameStats object into a BasicDBObject (mongodb)
	 * @return BasicDBObject
	 */
	public BasicDBObject convertGameStatsToBasicDBObject()
	{
		BasicDBObject obj = convertObjectToBasicDBObject(data);
		setJson(obj.toString());
		return obj;
	}
	
	/**
	 * converts a BasicDBObject (mongodb) into a GameStats
	 * @param obj
	 */
	public void convertDBObjectToGameStats(BasicDBObject obj)
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
		return generateLogEntry(data, "GameStats"); 
	}
	
	/**
	 * prints log entry to sysout
	 */
	public void show() 
	{ 
		printToOut(generateLogEntry(data, "GameStats")); 
	}

	// --------------------------------------------------------------------------------------
	// getters and setters
	public String getJson()	{ return json; }
	public int getId() { return Integer.valueOf(data.get("id").toString()); }
	public int getTeamId() { return Integer.valueOf(data.get("teamId").toString()); }
	public int getWeekNum() { return Integer.valueOf(data.get("weekNum").toString()); }
	public String getOpponent() { return data.get("opponent").toString(); }
	public Player getPlayer() { return (Player)data.get("player"); }
	public int getPassingYards() { return Integer.valueOf(data.get("passingYards").toString()); }
	public int getPassingTds() { return Integer.valueOf(data.get("passingTds").toString()); }
	public int getPassingPoints() { return Integer.valueOf(data.get("passingPoints").toString()); }
	public int getRushingYards() { return Integer.valueOf(data.get("rushingYards").toString()); }
	public int getRushingTds() { return Integer.valueOf(data.get("rushingTds").toString()); }
	public int getRushingPoints() { return Integer.valueOf(data.get("rushingPoints").toString()); }
	public int getReceivingYards() { return Integer.valueOf(data.get("receivingYards").toString());	}
	public int getReceivingTds() { return Integer.valueOf(data.get("receivingTds").toString()); }
	public int getReceivingPoints() { return Integer.valueOf(data.get("receivingPoints").toString()); }
	public int getFumblesLost() { return Integer.valueOf(data.get("fumblesLost").toString()); }
	public int getIntThrown() { return Integer.valueOf(data.get("intThrown").toString()); }
	public int getTurnOverPoints() { return Integer.valueOf(data.get("turnOverPoints").toString()); }
	public int getExtraPoints() { return Integer.valueOf(data.get("extraPoints").toString()); }
	public int getFg0to30() { return Integer.valueOf(data.get("fg0to30").toString()); }
	public int getFg31to40() { return Integer.valueOf(data.get("fg31to40").toString()); }
	public int getFg41to50() { return Integer.valueOf(data.get("fg41to50").toString());	}
	public int getFg51plus() { return Integer.valueOf(data.get("fg51plus").toString()); }
	public int getKickingPoints() { return Integer.valueOf(data.get("kickingPoints").toString()); }
	public int getIntMade() { return Integer.valueOf(data.get("intMade").toString()); }
	public int getFumblesRecovered() { return Integer.valueOf(data.get("fumblesRecovered").toString());	}
	public int getDefPoints() { return Integer.valueOf(data.get("defPoints").toString()); }
	public int getTotal() { return Integer.valueOf(data.get("total").toString()); }
	
	public void setJson(String json) { json = checkNullString(json); this.json = json; }
	public void setId(int id) { data.put("id", String.valueOf(id)); }
	public void setTeamId(int teamId) { data.put("teamId", String.valueOf(teamId)); }
	public void setWeekNum(int weekNum) { data.put("weekNum", String.valueOf(weekNum)); }
	public void setOpponent(String opponent) { data.put("opponent", opponent); }
	public void setPlayer(Player player) { data.put("player", player); }
	public void setPassingYards(int passingYards) { data.put("passingYards", String.valueOf(passingYards)); }
	public void setPassingTds(int passingTds) { data.put("passingTds", String.valueOf(passingTds)); }
	public void setPassingPoints(int passingPoints) { data.put("passingPoints", String.valueOf(passingPoints)); }
	public void setRushingYards(int rushingYards) { data.put("rushingYards", String.valueOf(rushingYards)); }
	public void setRushingTds(int rushingTds) { data.put("rushingTds", String.valueOf(rushingTds)); }
	public void setRushingPoints(int rushingPoints) { data.put("rushingPoints", String.valueOf(rushingPoints)); }
	public void setReceivingYards(int receivingYards) { data.put("receivingYards", String.valueOf(receivingYards)); }
	public void setReceivingTds(int receivingTds) { data.put("receivingTds", String.valueOf(receivingTds)); }
	public void setReceivingPoints(int receivingPoints) { data.put("receivingPoints", String.valueOf(receivingPoints)); }
	public void setFumblesLost(int fumblesLost) { data.put("fumblesLost", String.valueOf(fumblesLost)); }
	public void setIntThrown(int intThrown) { data.put("intThrown", String.valueOf(intThrown)); }
	public void setTurnOverPoints(int turnOverPoints) { data.put("turnOverPoints", String.valueOf(turnOverPoints)); }
	public void setExtraPoints(int extraPoints) { data.put("extraPoints", String.valueOf(extraPoints)); }
	public void setFg0to30(int fg0to30) { data.put("fg0to30", String.valueOf(fg0to30)); }
	public void setFg31to40(int fg31to40) { data.put("fg31to40", String.valueOf(fg31to40)); }
	public void setFg41to50(int fg41to50) { data.put("fg41to50", String.valueOf(fg41to50)); }
	public void setFg51plus(int fg51plus) { data.put("fg51Plus", String.valueOf(fg51plus)); }
	public void setKickingPoints(int kickingPoints) { data.put("kickingPoints", String.valueOf(kickingPoints)); }
	public void setIntMade(int intMade) { data.put("intMade", String.valueOf(intMade)); }
	public void setFumblesRecovered(int fumblesRecovered) { data.put("fumblesRecovered", String.valueOf(fumblesRecovered)); }
	public void setDefPoints(int defPoints) { data.put("defPoints", String.valueOf(defPoints)); }
	public void setTotal(int total) { data.put("total", String.valueOf(total)); }
	
}
