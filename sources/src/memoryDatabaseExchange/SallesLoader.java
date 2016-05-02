package memoryDatabaseExchange;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import allTables.Salles;

public class SallesLoader {

	public static ArrayList<Salles> getSallesList() throws SQLException {
		ArrayList<Salles> sallesList = new ArrayList<Salles>();
		ResultSet result = DbConnection.getStatement().executeQuery("SELECT * FROM salles");
		while(result.next()){
			sallesList.add(new Salles(result.getInt(1), result.getString(2), result.getInt(3),
					result.getString(4),result.getInt(5),result.getInt(6),result.getInt(7)));
		}
		System.out.println("\n\n\n************ Salles List *************\n"
				+ "(id, type, etage, nom, batiment_id, id_voisin_precedent, id_voisin_suivant)");
		sallesList.stream().forEach((item)-> System.out.println(item.getId()+" "+item.getType()+
				" "+item.getEtage()+" "+item.getNom()+" "+item.getBatiment_id()+" "+
				" "+item.getId_voisin_precedent()+" "+item.getId_voisin_suivant()));
		
		return sallesList ;
	}
}
