package it.polito.tdp.poweroutages.model;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	private PowerOutageDAO podao;
	private List<PowerOutage> listaTutti;
	private List<PowerOutage> listaMigliore;
	private static Integer abitantiMax;
	private static Integer anni;
	private static Integer ore;
	
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutage> listaMigliore(int nerc, int x, int y){        //X=ANNI, Y=ORE_TOTALI
		anni=x;
		ore=y;
		listaMigliore=null;
		listaTutti=new ArrayList<PowerOutage>(podao.getAllPowerOutagesNerc(nerc));
		abitantiMax=-1;
		for(PowerOutage p : listaTutti) {
			List<PowerOutage> listaCandidati=new ArrayList<PowerOutage>(listaAnni(listaTutti, p));
			List<PowerOutage> lista=new ArrayList<PowerOutage>();
			lista.add(p);
			if(p.getDuration()<=this.ore)
				if(p.getCustomers_affected()>this.abitantiMax)
					listaMigliore=new ArrayList<PowerOutage>(lista);
			ricorsione(1, listaCandidati, lista, p.getDuration(), p.getCustomers_affected());
		}
		return listaMigliore;
	}
	
	public void ricorsione(int livello, List<PowerOutage> candidati, List<PowerOutage> lista, long oreTotali, int persone) {
		if(livello==(candidati.size()+1))
			return;
		if(oreTotali>=this.ore)
			return;
		
		ricorsione(livello+1, candidati, lista, oreTotali, persone);
		
		lista.add(candidati.get(livello-1));
		//long oreIniziali=oreTotali;
		oreTotali=+candidati.get(livello-1).getDuration();
		//int personeIniziali=persone;
		persone=+candidati.get(livello-1).getCustomers_affected();
		
		if(oreTotali<=this.ore)
			if(persone>this.abitantiMax)
				listaMigliore=new ArrayList<PowerOutage>(lista);
		
		ricorsione(livello+1, candidati, lista, oreTotali, persone);
		
		
		
	}

	public List<PowerOutage> listaAnni(List<PowerOutage> tutti, PowerOutage p){
		List<PowerOutage> risultato=new LinkedList<PowerOutage>();
		for(PowerOutage po : tutti) {
			if(!p.equals(po)) 
				if(p.getDate_event_began().until(po.getDate_event_began(), ChronoUnit.HOURS)>=0 && p.getDate_event_began().until(po.getDate_event_began(), ChronoUnit.HOURS)<=(long)(this.anni*365*24))
					risultato.add(po);	
		}
		return risultato;
	}
	

}
