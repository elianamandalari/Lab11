package it.polito.tdp.model;

public class GruppoClienti {
	 private int time;
	 private int num_persone;
	 private int durata;
	 private float tolleranza;
	 private Tavolo tavolo;
	 
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + durata;
		result = prime * result + num_persone;
		result = prime * result + time;
		result = prime * result + Float.floatToIntBits(tolleranza);
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
		GruppoClienti other = (GruppoClienti) obj;
		if (durata != other.durata)
			return false;
		if (num_persone != other.num_persone)
			return false;
		if (time != other.time)
			return false;
		if (Float.floatToIntBits(tolleranza) != Float.floatToIntBits(other.tolleranza))
			return false;
		return true;
	}
	public GruppoClienti(int time, int num_persone, int durata, float tolleranza) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}
	 
	 
	

}
