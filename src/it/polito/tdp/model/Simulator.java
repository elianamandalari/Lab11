package it.polito.tdp.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;


import it.polito.tdp.model.Event.EventType;

public class Simulator {

PriorityQueue<Event>  queue;
Map<Integer,Tavolo> tavoli;
int id_tavolo=0;
private Statistiche statistiche;


	public Simulator() {
		this.queue=new PriorityQueue<Event>();
		this.tavoli=new HashMap<Integer,Tavolo>();
		statistiche=new Statistiche();
	}
   public void addTable(Tavolo tavolo){
	   id_tavolo++;
	   tavoli.put(id_tavolo,tavolo);
	   
   }
	
	public void addEvent(Event e){
	     queue.add(e);
	}
	
    
	
	public void run() {
		
		while(!queue.isEmpty()) {
			Event e = queue.poll() ;
			
			switch(e.getType()) {
			case ARRIVO_GRUPPO_CLIENTI:
			  statistiche.setNumero_totale_clienti(e.getGruppo().getNum_persone());
			  if(this.cercaTavoliDisponibili(e.getGruppo().getNum_persone())!=null){
				  Tavolo tavolo=this.cercaTavoliDisponibili(e.getGruppo().getNum_persone());
				  tavolo.setLibero(false);
				  statistiche.setNumero_clienti_soddisfatti(e.getGruppo().getNum_persone());
				  e.getGruppo().setTavolo(tavolo);
				  queue.add(
							new Event(e.time+ e.getGruppo().getDurata(), EventType.TAVOLO_LIBERATO_DA_GRUPPO_CLIENTI,e.getGruppo())) ;
			  }
			  else{
				 
				 float tolleranza= e.getGruppo().getTolleranza();
				
				 float caso=(float) (0.0+Math.random()*0.9);
				  if(caso<=tolleranza){
					  statistiche.setNumero_clienti_soddisfatti(e.getGruppo().getNum_persone());
				  }else{
					  statistiche.setNumero_clienti_insoddisfatti(e.getGruppo().getNum_persone());
				  }
				  
			  }
			    
				
				 break ;
				
			case TAVOLO_LIBERATO_DA_GRUPPO_CLIENTI :
	          Tavolo tavoloLiberato=this.trovaTavolo(e.getGruppo().getTavolo());
	          tavoloLiberato.setLibero(true);
			break ;
			}
		}
	}
 

	private Tavolo trovaTavolo(Tavolo tavolo) {
		if(tavoli.containsKey(tavolo))
		return tavoli.get(tavolo);
		return null;
	}
	
	
	public Tavolo cercaTavoliDisponibili(int numero_persone_gruppo){
    LinkedList<Tavolo> tavoliTemp=new LinkedList<Tavolo>(tavoli.values());
	Tavolo tavolo=null;
	int numero_posti_min=Integer.MAX_VALUE;
	for(Tavolo t:tavoliTemp){
		if(t.isLibero()==true){
			if(numero_persone_gruppo>= 0.5*t.getNum_posti()){
				if(t.getNum_posti()<numero_posti_min){
					numero_posti_min=t.getNum_posti();
					tavolo=t;
					
				}
			}
		}
		
	}
	return tavolo;
}
	public Statistiche getStatistiche() {
		return statistiche;
	}
	public void clear() {
		queue.clear();
		statistiche.clear();
	}
	
	

}
