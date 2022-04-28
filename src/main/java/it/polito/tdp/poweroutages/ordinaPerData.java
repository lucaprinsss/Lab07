package it.polito.tdp.poweroutages;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;

import it.polito.tdp.poweroutages.model.PowerOutage;

public class ordinaPerData implements Comparator<PowerOutage> {

	@Override
	public int compare(PowerOutage o1, PowerOutage o2) {
		
		return (int)o2.getDate_event_began().until(o1.getDate_event_began(), ChronoUnit.HOURS);
	}

}
