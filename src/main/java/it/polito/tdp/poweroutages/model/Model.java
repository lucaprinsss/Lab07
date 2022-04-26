package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private PowerOutageDAO podao;
	private List<PowerOutage> listaTutti;
	private List<PowerOutage> listaMigliore;
	private static Integer abitantiMax;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutage> listaMigliore(int nerc, int x, int y){        //X=ANNI, Y=ORE_TOTALI
		listaMigliore=null;
		listaTutti=new ArrayList<PowerOutage>(podao.getAllPowerOutagesNerc(nerc));
		abitantiMax=-1;
		for(PowerOutage p : listaTutti) {
			
		}
		return listaMigliore;
	}
	
	

}
