package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Event;
import it.polito.tdp.model.GruppoClienti;
import it.polito.tdp.model.Simulator;
import it.polito.tdp.model.Tavolo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnSimula;
    Simulator simulator;
    @FXML
    void doSimula(ActionEvent event) {
    	simulator.clear();
    
		
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

		txtResult.appendText(simulator.getStatistiche().print());
	

    }
    
 public void setModel(Simulator model){
	this.simulator=model;
}
    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
