package svc;

import java.util.ArrayList;

import dao.CustomerDAO;
import dao.HotelDAO;
import model.Customer;
import model.Hotel;


public class AdminService {

	public ArrayList<Customer> getcustomerlist() {
		ArrayList <Customer> customerlist = new ArrayList <Customer>();
		CustomerDAO dao = new CustomerDAO();
		customerlist = dao.getMemberList();
		return customerlist;
	}
	
	public ArrayList<Hotel> gethotellist(){
		ArrayList<Hotel> hotellist = new ArrayList <Hotel>();
		HotelDAO hdao = new HotelDAO();
		hotellist = hdao.getHotelList();
		return hotellist;
	}
}
