package rmi.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rmi.ConcertService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Server {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws RemoteException {
        logger.info("ex2 Server Starting ...");
    
        ConcertServant concertServant = new ConcertServant(new HashMap<>());
        
        final Remote remote = UnicastRemoteObject.exportObject(concertServant,0);
        final Registry registry = LocateRegistry.getRegistry();
        
        registry.rebind("ConcertService", remote);
        registry.rebind("TicketService", remote);
        
        
        
    }
}
