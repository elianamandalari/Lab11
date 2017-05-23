package it.polito.tdp.model;


public class Event implements Comparable<Event> {

	public enum EventType {ARRIVO_GRUPPO_CLIENTI,TAVOLO_LIBERATO_DA_GRUPPO_CLIENTI } ;	
    private EventType type ;
    private GruppoClienti gruppo;
    int time;
  
	public Event(int time,EventType type,GruppoClienti gruppo) {
	    this.type=type;
		this.gruppo=gruppo;
		this.time=time;
	}

	@Override
	public int compareTo(Event o) {
		return this.time-o.time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public GruppoClienti getGruppo() {
		return gruppo;
	}

	public void setGruppo(GruppoClienti gruppo) {
		this.gruppo = gruppo;
	
	}

}
