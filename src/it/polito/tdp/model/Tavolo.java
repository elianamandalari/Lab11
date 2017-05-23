package it.polito.tdp.model;

public class Tavolo {
	private int id_Tavolo;
	private int num_posti;
	private boolean libero;
	
	
	public Tavolo(int num_posti) {
		this.num_posti=num_posti;
		
	}
	
	public int getId_Tavolo() {
		return id_Tavolo;
	}
	public void setId_Tavolo(int id_Tavolo) {
		this.id_Tavolo = id_Tavolo;
	}
	public int getNum_posti() {
		return num_posti;
	}
	public void setNum_posti(int num_posti) {
		this.num_posti = num_posti;
	}
	public boolean isLibero() {
		return libero;
	}
	public void setLibero(boolean libero) {
		this.libero = libero;
	}
	

}
