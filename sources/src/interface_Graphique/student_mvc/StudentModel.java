package interface_Graphique.student_mvc;

import allTables.Database;

public class StudentModel {
	 private Database db;
	    
	    public StudentModel(Database db){
	        this.db = db;
	    }


	    
	    
	    public Database getDb(){
	    	return this.db;
	    }

}
