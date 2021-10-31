package monsterGame;

import java.util.List;

public class BattleService {

	// 일반 공격 -------------------------------------------
	// 일반 공격 몬스터 hp
	public List<MonsterDTO> monsterNormalAttack(List<MonsterDTO> monsterList, List<CharacterDTO> characterList,
			List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);

		if (monsterList.get(0).getMonsterHp() > 0 && characterList.get(checkResult).getCharacterHp() > 0) {
			int monsterHp = monsterList.get(0).getMonsterHp() - characterList.get(checkResult).getCharacterPower();
			monsterList.get(0).setMonsterHp(monsterHp);

			System.out.println(characterList.get(checkResult).getCharacterName() + "님이 일반공격을 하고 "
					+ monsterList.get(0).getMonsterName() + "가 반격 했습니다.");

			System.out.println(monsterList.get(0).getMonsterName() + " hp:" + monsterList.get(0).getMonsterHp()
					+ " 공격력:" + monsterList.get(0).getMonsterPower());
		}

		return monsterList;

	}

	// 일반 공격 유저 hp
	public List<CharacterDTO> characterNormalAttack(List<CharacterDTO> characterList, List<MonsterDTO> monsterList,
			List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);

		if (characterList.get(checkResult).getCharacterHp() >= monsterList.get(0).getMonsterPower()) {
			int characterHp = characterList.get(checkResult).getCharacterHp() - monsterList.get(0).getMonsterPower();
			characterList.get(checkResult).setCharacterHp(characterHp);

			System.out.println(characterList.get(checkResult).getCharacterName() + " hp:"
					+ characterList.get(checkResult).getCharacterHp() + " 공격력:"
					+ characterList.get(checkResult).getCharacterPower());
		}

		return characterList;

	}
	
	// 특수 공격 ---------------------------
	// 특수 공격 몬스터 hp
	public List<MonsterDTO> monsterSpecialttack(List<MonsterDTO> monsterList, List<CharacterDTO> characterList,
			List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);
		int ran = (int) (Math.random() * 30);

		if (monsterList.get(0).getMonsterHp() > 0 && characterList.get(checkResult).getCharacterHp() > 0) {
			int monsterHp = monsterList.get(0).getMonsterHp() - ran;
			monsterList.get(0).setMonsterHp(monsterHp);

			System.out.println(characterList.get(checkResult).getCharacterName() + "님이 크리티컬 공격을 하고 "
					+ monsterList.get(0).getMonsterName() + "가 반격 했습니다.");

			System.out.println(monsterList.get(0).getMonsterName() + " hp:" + monsterList.get(0).getMonsterHp()
					+ " 공격력:" + monsterList.get(0).getMonsterPower());
		}

		return monsterList;

	}
	
	// 특수 공격 유저 hp
	public List<CharacterDTO> characterSpecialAttack(List<CharacterDTO> characterList, List<MonsterDTO> monsterList,
			List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);

		if (characterList.get(checkResult).getCharacterHp() >= monsterList.get(0).getMonsterPower()) {
			int characterHp = characterList.get(checkResult).getCharacterHp() - monsterList.get(0).getMonsterPower();
			characterList.get(checkResult).setCharacterHp(characterHp);

			System.out.println(characterList.get(checkResult).getCharacterName() + " hp:"
					+ characterList.get(checkResult).getCharacterHp() + " 공격력:"
					+ characterList.get(checkResult).getCharacterPower());
		}

		return characterList;

	}

	// 전투 종료
	public List<MonsterDTO> battleEnd(List<CharacterDTO> characterList, List<MonsterDTO> monsterList,
			List<ClientDTO> clientList) {
		int checkResult = characterCheck(clientList);
		if (monsterList.get(0).getMonsterHp() <= 0) {
			monsterList.get(0).setMonsterPower(10000);
			System.out.println("몬스터가 죽어서 전투가 종료 되었습니다.");
			System.out.println("나가기를 눌러주세요.");
		} else if (characterList.get(checkResult).getCharacterHp() < monsterList.get(0).getMonsterPower()) {
			System.out.println("유저가 죽어서 전투가 종료 되었습니다.");
			System.out.println("나가기를 눌러주세요.");
		}
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
