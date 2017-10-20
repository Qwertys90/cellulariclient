package it.dstech.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brano {
@Id
@GeneratedValue
private int id;

private String titolo;

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

public int getDurata() {
	return durata;
}

public void setDurata(int durata) {
	this.durata = durata;
}


}
