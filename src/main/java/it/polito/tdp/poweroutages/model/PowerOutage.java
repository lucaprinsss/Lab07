package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class PowerOutage {
	int id;
	//int event_type_id;
	//int tag_id;
	//int area_id;
	int nerc_id;
	//int responsible_id;
	int customers_affected;
	LocalDateTime date_event_began;
	LocalDateTime date_event_finished;
	long duration;
	//int demand_loss;
	
	public PowerOutage(int id/*, int event_type_id, int tag_id, int area_id*/, int nerc_id/*, int responsible_id*/,
			int customers_affected, LocalDateTime date_event_began, LocalDateTime date_event_finished/*,
			int demand_loss*/) {
		this.id = id;
		/*this.event_type_id = event_type_id;
		this.tag_id = tag_id;
		this.area_id = area_id;*/
		this.nerc_id = nerc_id;
		/*this.responsible_id = responsible_id;*/
		this.customers_affected = customers_affected;
		this.date_event_began = date_event_began;
		this.date_event_finished = date_event_finished;
		this.duration = date_event_began.until(date_event_finished, ChronoUnit.HOURS);
		/*this.demand_loss = demand_loss;*/
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public int getEvent_type_id() {
		return event_type_id;
	}

	public void setEvent_type_id(int event_type_id) {
		this.event_type_id = event_type_id;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}*/

	public int getNerc_id() {
		return nerc_id;
	}

	public void setNerc_id(int nerc_id) {
		this.nerc_id = nerc_id;
	}

	/*public int getResponsible_id() {
		return responsible_id;
	}

	public void setResponsible_id(int responsible_id) {
		this.responsible_id = responsible_id;
	}*/

	public int getCustomers_affected() {
		return customers_affected;
	}

	public void setCustomers_affected(int customers_affected) {
		this.customers_affected = customers_affected;
	}

	public LocalDateTime getDate_event_began() {
		return date_event_began;
	}

	public void setDate_event_began(LocalDateTime date_event_began) {
		this.date_event_began = date_event_began;
	}

	public LocalDateTime getDate_event_finished() {
		return date_event_finished;
	}

	public void setDate_event_finished(LocalDateTime date_event_finished) {
		this.date_event_finished = date_event_finished;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	/*public int getDemand_loss() {
		return demand_loss;
	}

	public void setDemand_loss(int demand_loss) {
		this.demand_loss = demand_loss;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutage other = (PowerOutage) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override    //tolto anche nerc_id dalla stampa
	public String toString() {
		//return id +"  Persone coinvolte:"+ customers_affected +"  "+ date_event_began +"  "+ date_event_finished +"  Durata(in ore):"+ duration;
		return "id="+id+" "+/*date_event_began.getYear()+" "+*/date_event_began+" "+date_event_finished+" "+duration+" "+customers_affected;
	}
	
	/*@Override
	public String toString() {
		return "PowerOutage [id=" + id + ", event_type_id=" + event_type_id + ", tag_id=" + tag_id + ", area_id="
				+ area_id + ", nerc_id=" + nerc_id + ", responsible_id=" + responsible_id + ", customers_affected="
				+ customers_affected + ", date_event_began=" + date_event_began + ", date_event_finished="
				+ date_event_finished + ", duration=" + duration + ", demand_loss=" + demand_loss + "]";
	}*/
	
	
	
}
