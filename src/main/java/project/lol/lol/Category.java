package project.lol.lol;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import project.lol.lol.Match;

@Entity
public class Category {
	@Id 	// used to create id for the table
	@GeneratedValue(strategy=GenerationType.AUTO)	//generates an unique primary key automatically
	private Long categoryid;
	private String mapname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // creates a connection from a categoryid into many matchids
	private List<Match> Matches;
	
	public Category() {
		
	}

	
	public Category(String mapname) {
		super();
		this.mapname = mapname;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getMapname() {
		return mapname;
	}

	public void setMapname(String mapname) {
		this.mapname = mapname;
	}

	public List<Match> getMatches() {
		return Matches;
	}

	public void setMatches(List<Match> matches) {
		this.Matches = matches;
	}


	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", mapname=" + mapname +"]";
	}
	
	
}
