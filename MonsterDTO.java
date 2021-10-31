package monsterGame;

public class MonsterDTO {
	
	private int monsterNum;
	private String monsterName;
	private int monsterHp;
	private int monsterPower;
	
	public MonsterDTO() {
		
	}
	
	public MonsterDTO(int monsterNum, String monsterName, int monsterHp, int monsterPower) {
		super();
		this.monsterNum = monsterNum;
		this.monsterName = monsterName;
		this.monsterHp = monsterHp;
		this.monsterPower = monsterPower;
	}

	public int getMonsterNum() {
		return monsterNum;
	}

	public void setMonsterNum(int monsterNum) {
		this.monsterNum = monsterNum;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public int getMonsterHp() {
		return monsterHp;
	}

	public void setMonsterHp(int monsterHp) {
		this.monsterHp = monsterHp;
	}

	public int getMonsterPower() {
		return monsterPower;
	}

	public void setMonsterPower(int monsterPower) {
		this.monsterPower = monsterPower;
	}

	@Override
	public String toString() {
		return "MonsterDTO [monsterNum=" + monsterNum + ", monsterName=" + monsterName + ", monsterHp=" + monsterHp
				+ ", monsterPower=" + monsterPower + "]";
	}
	
	
	
	
}
