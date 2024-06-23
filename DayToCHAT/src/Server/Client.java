package Server;

public class Client {
	private String username,status;
	private int portpeer;
	public Client(String username,String status, int portpeer) {
		this.username = username;
		this.status = status;
		this.portpeer = portpeer;
	}
	public String getUsername() {
		return username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPort() {
		return portpeer;
	}
	public void setPort(int portpeer) {
		this.portpeer = portpeer;
	}
	
}
