package monsterGame;

import java.util.*;

public class CharacterService {
	
	// 몬스터 사냥 클릭시 유저 hp 공격력 표시
	public void characterName(List<ClientDTO> clientList, List<CharacterDTO> characterList) {
		int checkResult = characterCheck(clientList);
		System.out.println(characterList.get(checkResult).getCharacterName()+
				" hp:"+characterList.get(checkResult).getCharacterHp()+
				" 공격력:"+characterList.get(checkResult).getCharacterPower());
	}
	
	// 무기강화
	public List<CharacterDTO> weaponPowerUp(List<CharacterDTO> characterList, List<ClientDTO> clientList){
		int checkResult = characterCheck(clientList);
		Scanner scan = new Scanner(System.in);
		System.out.println("확률로 무기가 강화 됩니다.");
		System.out.println("강화 성공시 무기공격력이 10 상승합니다");
		System.out.println("강화 비용은 300골드가 소모됩니다.");
		System.out.println("현재 소지금은 " + characterList.get(checkResult).getCharacterMeney() + "골드 입니다.");
		System.out.print("강화 하시겠습니까? yes or no: ");
		String choice = scan.next();
		
		if(choice.equals("yes") && characterList.get(checkResult).getCharacterMeney() >= 300) {
			int ran = (int) (Math.random() * 3);
			if(ran == 0) {
				int pNum = characterList.get(checkResult).getCharacterPower() + 10;
				characterList.get(checkResult).setCharacterPower(pNum);
				int num = characterList.get(checkResult).getCharacterMeney() -300;
				characterList.get(checkResult).setCharacterMeney(num);
				System.out.println("강화 성공!!!!!");
			} else {
				int num = characterList.get(checkResult).getCharacterMeney() -300;
				characterList.get(checkResult).setCharacterMeney(num);
				System.out.println("강화 실패...");
			}
		} else if(choice.equals("no")) {
			
		} else if(choice.equals("yes") && characterList.get(checkResult).getCharacterMeney() <= 300) {
			System.out.println("소지금이 모자랍니다.");
		}
		return characterList;
	}
	
	// 캐릭터 상태 확인
	public void characterStatus(List<CharacterDTO> characterList, List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);
		System.out.println(
			"캐릭터 이름:"+characterList.get(checkResult).getCharacterName()+
			" 체력:"+characterList.get(checkResult).getCharacterHp()+
			" 공격력:"+characterList.get(checkResult).getCharacterPower()+
			" 소지금:"+characterList.get(checkResult).getCharacterMeney());
		
	}
	
	// 피회복
	public List<CharacterDTO> hpRecovery(List<CharacterDTO> characterList, List<ClientDTO> clientList){
		int checkResult = characterCheck(clientList);
		Scanner scan = new Scanner(System.in);
		System.out.println("최대 hp는 100 입니다.");
		System.out.println("현재 남은 체력은 "+characterList.get(checkResult).getCharacterHp()+" 입니다.");
		System.out.println("hp회복에 100골드가 소모 됩니다.");
		System.out.print("회복 하시겠습니까? yes or no: ");
		String choice = scan.next();
		if(choice.equals("yes") && characterList.get(checkResult).getCharacterMeney() >= 100) {
			characterList.get(checkResult).setCharacterHp(100);
			int num = characterList.get(checkResult).getCharacterMeney() -100;
			characterList.get(checkResult).setCharacterMeney(num);
			System.out.println("hp가 회복 되었습니다.");
		} else if(choice.equals("yes") && characterList.get(checkResult).getCharacterMeney() <= 100) {
			System.out.println("소지금이 모자랍니다.");
		}
		
		return characterList;
	}
	
	// 공통 로그인 아이디 찾기
	public int characterCheck(List<ClientDTO> clientList){
		int clientNumber = 0;
		for (int i = 0; i < clientList.size(); i++) {
			if (clientList.get(i).isOnOut() == true) {
				clientNumber = i;
			}
		}
		return clientNumber;
	}
	
}
