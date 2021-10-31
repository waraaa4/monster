package monsterGame;

public class CharacterDTO {

	private int characterNum;
	private String characterName;
	private int characterHp;
	private int characterPower;
	private int characterMeney;
	
	public CharacterDTO(){
		
	}
	
	public CharacterDTO(int characterNum, String characterName, int characterHp, int characterPower,
			int characterMeney) {
		super();
		this.characterNum = characterNum;
		this.characterName = characterName;
		this.characterHp = characterHp;
		this.characterPower = characterPower;
		this.characterMeney = characterMeney;
	}

	public int getCharacterNum() {
		return characterNum;
	}

	public void setCharacterNum(int characterNum) {
		this.characterNum = characterNum;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getCharacterHp() {
		return characterHp;
	}

	public void setCharacterHp(int characterHp) {
		this.characterHp = characterHp;
	}

	public int getCharacterPower() {
		return characterPower;
	}

	public void setCharacterPower(int characterPower) {
		this.characterPower = characterPower;
	}

	public int getCharacterMeney() {
		return characterMeney;
	}

	public void setCharacterMeney(int characterMeney) {
		this.characterMeney = characterMeney;
	}

	@Override
	public String toString() {
		return "CharacterDTO [characterNum=" + characterNum + ", characterName=" + characterName + ", characterHp="
				+ characterHp + ", characterPower=" + characterPower + ", characterMeney=" + characterMeney + "]";
	}
	
	

	
	
	
}
