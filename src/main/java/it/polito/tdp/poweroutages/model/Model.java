package it.polito.tdp.poweroutages.model;

import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private PowerOutageDAO podao;
	private Ricorsione ricorsione;
	
	
	public Model() {
		podao = new PowerOutageDAO();
		ricorsione=new Ricorsione();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutage> listaMigliore(int nerc, int x, int y){
		return ricorsione.listaMigliore(nerc, x, y);
	}
}
