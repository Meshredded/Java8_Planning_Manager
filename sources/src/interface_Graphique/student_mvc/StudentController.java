package interface_Graphique.student_mvc;

import interface_Graphique.student_mvc.StudentModel;
import interface_Graphique.student_mvc.StudentView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import allTables.Promos;
import allTables.Salles;
import allTables.Seances;
import allTables.Users;

public class StudentController {
	private StudentModel model;
	private StudentView view;
	private Users user ;
	    
	    public StudentController(StudentModel model, StudentView view){
	        this.model = model;
	        this.view = view;
	        this.user = null;
	    }
	    
	    public void control(){       
	              
	        view.getPromosCombo().addActionListener(e ->{
	            showPlanning();
	            
	        });
	        view.getDate().addActionListener(e ->{
	            showPlanning();
	            
	        });
	    }

	    private void showPlanning(){
	    	Promos selectedPromos = (Promos) view.getPromosCombo().getSelectedItem();
	    	int promosId = selectedPromos.getId();
	    	
	    	Date selectedDate = (Date)view.getDate().getModel().getValue();
	    	if (selectedDate == null)selectedDate = new Date();
	    	
	    	String toDisplay = "";
	    	List<Seances> returnedList =model.getDb().getPlanningByDayByPromos(selectedDate,promosId );
	    	if(returnedList.size()>0){
	    	for (Seances item : returnedList){
	    		DateFormat formatter = new SimpleDateFormat("HH:mm");
	    		String debut = formatter.format(item.getDebut().getTime());
	    		String fin =formatter.format(item.getFin().getTime());
	    		int idCours =item.getCours_id();
	    		Salles salle = model.getDb().getSallesById(item.getSalle_id());
	    		toDisplay = toDisplay+item.getType()+": "+model.getDb().getCoursById(idCours).getNom()+
	    				"	Debut: "+debut+
	    				"	Fin: "+fin+
	    				"	Salle: "+model.getDb().getSallesById(item.getSalle_id()).getNom()+
	    				"	Etage: "+salle.getEtage()+
	    				"	Batiment: "+model.getDb().getBatimentsById(salle.getBatiment_id()).getNom()+
	    				"	Prof Responsable: "+model.getDb().getCoursById(idCours).getProf_responsable()+
	    				"\n";
	    		
	    		item.getDebut().getTime();
	    	}
	    	}else toDisplay = "Planning Vide Pour cette Date";
	    	view.getTextArea().setText(toDisplay);
	    }    
	    
	    public Users getCurrentUser(){
	    	return this.user;
	    }
}
