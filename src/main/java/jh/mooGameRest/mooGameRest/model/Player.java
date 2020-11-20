package jh.mooGameRest.mooGameRest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hedma
 *
 */
@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "player",nullable = false)
	private List<MooResult> mooResults = new ArrayList<MooResult>();

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", mooResults=" + mooResults + "]";
	}
	
	public void addNewResult(MooResult result) {
		mooResults.add(result);
	}
	
	
}
