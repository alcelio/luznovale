package br.com.luznovale.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Droga
 *
 */
@Entity
@NamedQuery(name = "Droga.findAll", query = "SELECT d FROM Droga d")
public class Droga implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue
	private Integer idDroga;
	private String desDroga;

	public Droga() {

	}   
	public Integer getIdDroga() {
		return this.idDroga;
	}

	public void setIdDroga(Integer idDroga) {
		this.idDroga = idDroga;
	}   
	public String getDesDroga() {
		return this.desDroga;
	}

	public void setDesDroga(String desDroga) {
		this.desDroga = desDroga;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desDroga == null) ? 0 : desDroga.hashCode());
		result = prime * result + ((idDroga == null) ? 0 : idDroga.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Droga other = (Droga) obj;
		if (desDroga == null) {
			if (other.desDroga != null)
				return false;
		} else if (!desDroga.equals(other.desDroga))
			return false;
		if (idDroga == null) {
			if (other.idDroga != null)
				return false;
		} else if (!idDroga.equals(other.idDroga))
			return false;
		return true;
	}
}
