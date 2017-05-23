package it.polito.tdp.model;

import java.util.Random;

public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Simulator simulator=new Simulator();
		
		simulator.addTable(new Tavolo(10));
		simulator.addTable(new Tavolo(10));
		simulator.addTable(new Tavolo(8));
		simulator.addTable(new Tavolo(8));
		simulator.addTable(new Tavolo(8));
		simulator.addTable(new Tavolo(8));
		simulator.addTable(new Tavolo(6));
		simulator.addTable(new Tavolo(6));
		simulator.addTable(new Tavolo(6));
		simulator.addTable(new Tavolo(6));
		simulator.addTable(new Tavolo(4));
		simulator.addTable(new Tavolo(4));
		simulator.addTable(new Tavolo(4));
		simulator.addTable(new Tavolo(4));
		simulator.addTable(new Tavolo(4));

		
		
		for (int i = 0; i< 2000; i++) {
			
			int tempo = (int) (1 + Math.random()*10);
			int durata =  (int) (60 + Math.random() * 60);
			float tolleranza = (float) (0.0+Math.random()*0.9);
			int num_persone =(int) (1 + Math.random()*10);
			
			
			GruppoClienti gruppo = new GruppoClienti(tempo,num_persone,durata,tolleranza);
			
			
			Event e = new Event(tempo, Event.EventType.ARRIVO_GRUPPO_CLIENTI, gruppo);
			simulator.addEvent(e);
		}
		
		simulator.run();

		System.out.println(simulator.getStatistiche().print());
	}

}
