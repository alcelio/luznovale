package br.com.luznovale.model;

import br.com.luznovale.model.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Responsavel
 *
 */
@Entity
@DiscriminatorValue("Responsavel")
@NamedQuery(name = "Responsavel.findAll", query = "SELECT o FROM Responsavel o")
public class Responsavel extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	public Responsavel() {
		super();
	}
   
}
