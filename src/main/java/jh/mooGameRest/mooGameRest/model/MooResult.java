package jh.mooGameRest.mooGameRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="moo_results")
@Getter
@Setter
@NoArgsConstructor
public class MooResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int result;

	@Override
	public String toString() {
		return "MooResult [id=" + id + ", result=" + result;
	}
	
	
	
}
