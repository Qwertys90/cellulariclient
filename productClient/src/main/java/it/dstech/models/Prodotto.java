package it.dstech.models;



public class Prodotto {

	
	private int id;
	 
	private String nome;
	
	private String descrizione;
	
	private int codice;
	
	private int quantit‡;
	
	private int prezzo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQuantit‡() {
		return quantit‡;
	}

	public void setQuantit‡(int quantit‡) {
		this.quantit‡ = quantit‡;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", codice=" + codice
				+ ", quantit√†=" + quantit‡ + ", prezzo=" + prezzo + "]";
	}

	
	
}
