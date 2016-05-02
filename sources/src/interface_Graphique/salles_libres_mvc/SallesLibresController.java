package interface_Graphique.salles_libres_mvc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import allTables.Salles;

public class SallesLibresController {
	SallesLibresModel model;
	SallesLibresView view;

	public SallesLibresController(SallesLibresModel model, SallesLibresView view) {
		this.model = model;
		this.view = view;
	}

	public void control() {
		view.getButton().addActionListener(e ->{
            this.getSallesLibres();
            
        });   
	}
	
	@SuppressWarnings("deprecation")
	public void getSallesLibres(){
		Date day = (Date)view.getDatePicker().getModel().getValue();
		if (day == null)day = new Date(0);
		Timestamp debut = new Timestamp(day.getTime());
		Timestamp fin = new Timestamp(day.getTime());
		
		debut.setHours((int)view.getHeuresDebut().getSelectedItem());
		debut.setMinutes((int)view.getMinutesDebut().getSelectedItem());
		debut.setSeconds(0);
		debut.setNanos(0);
		
		fin.setHours((int)view.getHeuresFin().getSelectedItem());
		fin.setMinutes((int)view.getMinutesFin().getSelectedItem());
		fin.setSeconds(0);
		fin.setNanos(0);
		

		
		String toDisplay = "Créneau séléctionné : de ("+debut.toString()+") à ("+fin.toString()+")\n";
		ArrayList<Salles> salles = model.getDb().freeFromTo(debut, fin);
		if(salles.size()>0){
			for(Salles item : salles){
				toDisplay = toDisplay+
						"	Numero de salle: "+item.getNom()+
						"	Batiment: "+model.getDb().getBatimentsById(item.getBatiment_id()).getNom()+
						"	Type de la Salle: "+item.getType()+"\n";
			}
			
		}else toDisplay = "Aucune salle dispo pour ce créneau !";
		view.getTextArea().setText(toDisplay);
    	if(debut.after(fin))view.getTextArea().setText("Date debut ne peut par etre apres date fin");
		
	}
}