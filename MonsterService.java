package monsterGame;

import java.util.*;

public class MonsterService {

	// 몬스터 랜덤 선택
	public List<MonsterDTO> monsterChoice(List<MonsterDTO> monsterList) {
		int ran = (int) (Math.random() * 3);
		if (ran == 0 || ran == 1) {
			MonsterDTO monsterMember = new MonsterDTO(0, "노말 몬스터", 50, 10);
			monsterList.add(monsterMember);
		} else if (ran == 2) {
			MonsterDTO monsterMember = new MonsterDTO(1, "레어 몬스터", 60, 20);
			monsterList.add(monsterMember);
		}
		System.out.println(monsterList.get(0).getMonsterName()+"가 등장 했습니다.");
		System.out.println(monsterList.get(0).getMonsterName()+
				" hp:" + monsterList.get(0).getMonsterHp() + 
				" 공격력:" + monsterList.get(0).getMonsterPower());
		
		return monsterList;
	}

	// 몬스터 삭제
	public List<MonsterDTO> monsterElimination(List<MonsterDTO> monsterList, List<CharacterDTO> characterList, List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);
		if(monsterList.get(0).getMonsterNum() == 0 && monsterList.get(0).getMonsterHp() <= 0) {
			int money = characterList.get(checkResult).getCharacterMeney() + 100;
			characterList.get(checkResult).setCharacterMeney(money);
			System.out.println("몬스터를 처치해서 100 골드를 얻었습니다.");
		} else if(monsterList.get(0).getMonsterNum() == 1 && monsterList.get(0).getMonsterHp() <= 0){
			int money = characterList.get(checkResult).getCharacterMeney() + 200;
			characterList.get(checkResult).setCharacterMeney(money);
			System.out.println("몬스터를 처치해서 200 골드를 얻었습니다.");
		} else {
			System.out.println("아무것도 얻지 못했습니다.");
		}
		
		monsterList.remove(0);
		
		return monsterList;
	}
	
	
	// 공통 로그인 아이디 찾기
		public int characterCheck(List<ClientDTO> clientList) {
			int clientNumber = 0;
			for (int i = 0; i < clientList.size(); i++) {
				if (clientList.get(i).isOnOut() == true) {
					clientNumber = i;
				}
			}
			return clientNumber;
		}

}
