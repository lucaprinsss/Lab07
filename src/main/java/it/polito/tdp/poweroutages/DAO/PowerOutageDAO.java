package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutage;


public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {
		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return nercList;
	}

	
	public List<PowerOutage> getAllPowerOutagesNerc(int nerc) {
		final String sql = "SELECT id, nerc_id, customers_affected, date_event_began, date_event_finished FROM poweroutages WHERE nerc_id=? ORDER BY id";
		List<PowerOutage> lista = new ArrayList<PowerOutage>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				PowerOutage p=new PowerOutage(rs.getInt("id"), rs.getInt("nerc_id"), rs.getInt("customers_affected"), rs.getTimestamp("date_event_began").toLocalDateTime(), rs.getTimestamp("date_event_finished").toLocalDateTime());
				lista.add(p);
			}
			conn.close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/*public List<PowerOutage> getAllPowerOutages() {
		final String sql = "SELECT id, nerc_id, customers_affected, date_event_began, date_event_finished FROM poweroutages ORDER BY id";
		List<PowerOutage> lista = new ArrayList<PowerOutage>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			PowerOutage p=new PowerOutage(rs.getInt("id"), rs.getInt("nerc_id"), rs.getInt("customers_affected"), rs.getDate("date_event_began").toLocalDate(), rs.getDate("date_event_finished").toLocalDate());
			lista.add(p);
		}
		conn.close();
		return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		throw new RuntimeException(e);
		}
	}*/
}
