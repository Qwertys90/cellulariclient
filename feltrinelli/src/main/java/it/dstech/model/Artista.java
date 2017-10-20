package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Artista {
	
@Id
@GeneratedValue
private int id;

private String nome;

private String cognome;

@OneToMany
@JoinColumn(name="ARTISTA_ID")
private List<Album> listAlbum;

@OneToMany
@JoinColumn(name="ARTISTA_ID")
private List<Brano> listBrani;



public Artista() {
this.listAlbum = new ArrayList<Album>();
this.listBrani = new ArrayList<Brano>();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public List<Album> getListAlbum() {
	return listAlbum;
}
public void setListAlbum(List<Album> listAlbum) {
	this.listAlbum = listAlbum;
}
public List<Brano> getListBrani() {
	return listBrani;
}
public void setListBrani(List<Brano> listBrani) {
	this.listBrani = listBrani;
}

}
