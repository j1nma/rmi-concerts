package rmi.server;

import rmi.Concert;
import rmi.ConcertService;
import rmi.TicketClient;
import rmi.TicketService;

import java.rmi.RemoteException;
import java.util.Set;

public class ConcertServant implements ConcertService, TicketService {
	
	private volatile Set<Concert> concerts;
	
	public ConcertServant(Set<Concert> concerts) {
		this.concerts = concerts;
	}
	
	@Override
	public void create(String name, int confirmationTickets, int maxTickets, int vipTickets) throws RemoteException {
		this.concerts.add(new Concert(name, confirmationTickets, maxTickets, vipTickets));
	}
	
	@Override
	public void cancel(String name) throws RemoteException {
		
		for (Concert concert : concerts) {
			
			if (concert.getName().equals(name)) {
				concert.cancel();
				return;
			}
			
		}
		
	}
	
	@Override
	public void applyForTicket(String concertName, TicketClient handler) throws RemoteException {
	
	}
}
