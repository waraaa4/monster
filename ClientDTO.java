package monsterGame;

public class ClientDTO {

	private int memberNum;
	private String id;
	private String password;
	private String name;
	private boolean onOut = false;
	
	public ClientDTO() {
		
	}

	public ClientDTO(int memberNum, String id, String password, String name, boolean onOut) {
		super();
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.name = name;
		this.onOut = onOut;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnOut() {
		return onOut;
	}

	public void setOnOut(boolean onOut) {
		this.onOut = onOut;
	}

	@Override
	public String toString() {
		return "ClientDTO [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", onOut=" + onOut + "]";
	}

}
