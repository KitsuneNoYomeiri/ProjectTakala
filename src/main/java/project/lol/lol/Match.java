package project.lol.lol;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String champion;
	private String role;
	private int kills;
	private int deaths;
	private int assists;
	private int creeps;
	private double gametime;
	private String result;
	
	@ManyToOne		//creates a connection from may Matches into a single category id
	@JsonIgnore		//breaks the infinite loop between @manytoone and @onetomany
	@JoinColumn(name ="categoryid") //joins Match with Category
	private Category category;
	
	public Match() {}
	
	public Match(String champion, String role, int kills, int deaths, int assists, int creeps, double gametime,
			String result, Category category) {
		super();
		this.champion = champion;
		this.role = role;
		this.kills = kills;
		this.deaths = deaths;
		this.assists = assists;
		this.creeps = creeps;
		this.gametime = gametime;
		this.result = result;
		this.category = category;
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChampion() {
		return champion;
	}
	public void setChampion(String champion) {
		this.champion = champion;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getCreeps() {
		return creeps;
	}
	public void setCreeps(int creeps) {
		this.creeps = creeps;
	}
	
	public double getGametime() {
		return gametime;
	}
	public void setGametime(double gametime) {
		this.gametime = creeps;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category !=null)
		return "Match [id=" + id + ", champion=" + champion + ", role=" + role + ", kills=" + kills + ", deaths=" + deaths + ", assists="
				+ assists + ", creeps=" + creeps + ", gametime=" + gametime + ", result=" + result + ", category="
				+ category + "]";
		return "Match [id=" + id + ", champion=" + champion + ", role=" + role + ", kills=" + kills + ", deaths=" + deaths + ", assists="
		+ assists + ", creeps=" + creeps + ", gametime=" + gametime + ", result=" + result;
	}

	
}
