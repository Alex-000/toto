package fr.treeptik.annuaire.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//named query
@NamedQueries({
	@NamedQuery(name = "findAllNumero", query = "SELECT n FROM Numero n"),
	@NamedQuery(name = "findAllNumeroWithPersonne", query = "SELECT DISTINCT(n) FROM Numero n LEFT JOIN FETCH n.personnes"),
	@NamedQuery(name = "findAllNumeroWithoutPersonne", query = "SELECT n FROM Numero n LEFT JOIN n.personnes p WHERE p IS NULL"),
	@NamedQuery(name = "findNumero", query = "SELECT n FROM Numero n WHERE n.numero = :numero"),
	@NamedQuery(name = "findNumeroOnePersonne", query = "SELECT n FROM Numero n JOIN n.personnes p WHERE p.id = :id"),
	@NamedQuery(name = "findPersonneByNumero", query = "SELECT p FROM Personne p LEFT JOIN p.numeros n WHERE n.numero = :numero"),
	})
public class Numero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String type;
	
	@Column(nullable = false)
	private String numero;
	
	@ManyToMany(mappedBy = "numeros")
	private List<Personne> personnes;

	public Numero() {
	}

	
	
	public Numero(Integer id, String type, String numero, List<Personne> personnes) {
		this.id = id;
		this.type = type;
		this.numero = numero;
		this.personnes = personnes;
	}

	

	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Numero other = (Numero) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public List<Personne> getPersonnes() {
		return personnes;
	}



	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Numero [id=" + id + ", type=" + type + ", numero=" + numero + "]";
	}

	
}
