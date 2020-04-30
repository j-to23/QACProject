package logic;

public interface crud {
	public void read();
	public void update(String set, String setto, String whereis);
	public void delete(String id);
}