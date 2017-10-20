package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Album {
	@Id
	@GeneratedValue
	private int id;
	
	private String titolo;
	
	private String Gay;
	
	@OneToMany
	@JoinColumn(name="ALBUM_ID")
	private List<Brano> listaBrani;
	
	@ManyToMany(mappedBy="listaAlbum")
	private List<User> listUser;
	
	public Album() {
		this.listaBrani = new ArrayList<Brano>();
	}

	private int durata;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Brano> getListaBrani() {
		return listaBrani;
	}

	public void setListaBrani(List<Brano> listaBrani) {
		this.listaBrani = listaBrani;
	}

	public int getDurata() {
		return durata;
	}
	
	public int getDurataTotale() {
		int durata=0;
		for(Brano brano : listaBrani) {
			durata+=brano.getDurata();
		}
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	
}
