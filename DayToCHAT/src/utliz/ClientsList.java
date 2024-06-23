package utliz;

import java.util.ArrayList;

import Server.Client;

public class ClientsList {
    private static ClientsList instance;
    private static ArrayList<Client> Clientslist;

    private ClientsList() {
        Clientslist = new ArrayList<>();
    }
    public static ClientsList getInstance() {
        if (instance == null) {
            instance = new ClientsList();
        }
        return instance;
    }
	public static void PrintInfor(int i) {
		System.out.println(Clientslist.get(i).getUsername());
		System.out.println(Clientslist.get(i).getStatus());
		System.out.println(Clientslist.get(i).getPort());
	}
	public void AddClient(Client client) {
		Clientslist.add(client);
		System.out.println("Added!");
	}
	public static ArrayList<Client> getClientsList() {
		return Clientslist;
	}
}
