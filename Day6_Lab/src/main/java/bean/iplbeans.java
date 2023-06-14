package bean;

import java.sql.SQLException;
import java.util.List;

import dao.TeamDaoImpl;
import pojos.Team;

public class iplbeans {
private TeamDaoImpl teamDao;

public iplbeans() throws SQLException {
	teamDao= new TeamDaoImpl();
	System.out.println("ipl bean is created");
		
}
//getters -setters
public TeamDaoImpl getTeamDao() {
	return teamDao;
}

public void setTeamDao(TeamDaoImpl teamDao) {
	this.teamDao = teamDao;
}
//add B.L method to ret list of all teams to caller(JSP)
public List<Team>fetchAllTeams() throws SQLException
{
	
	return teamDao.getSelectedDetails();
	
}

}
