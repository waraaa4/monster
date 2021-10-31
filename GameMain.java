package monsterGame;

import java.util.*;

public class GameMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<ClientDTO> clientList = new ArrayList<ClientDTO>();
		List<CharacterDTO> characterList = new ArrayList<CharacterDTO>();
		List<MonsterDTO> monsterList = new ArrayList<MonsterDTO>();
		ClientService clientSv = new ClientService();
		CharacterService characterSv = new CharacterService();
		MonsterService monsterSv = new MonsterService();
		BattleService battleSv = new BattleService();

		boolean run = true;
		boolean login = false;
		int num = 0;

		while (run) {
			if (login == false && num == 0) { // 로그인 전
				System.out.println("----------------------------------------------");
				System.out.println("1.회원가입 | 2.회원조회 | 3.로그인 | 4.종료");
				System.out.println("----------------------------------------------");
				System.out.print("번호선택: ");
			} else if (login == true && num == 1) { // 로그인 후
				System.out.println("------------------------------------------------------------------");
				System.out.println("1.몬스터사냥 | 2.무기강화 | 3.캐릭터상태 | 4.피회복 | 5.로그아웃");
				System.out.println("------------------------------------------------------------------");
				System.out.print("번호선택: ");
			} else if (login == true && num == 2) { // 몬스터 사냥
				System.out.println("---------------------------------------------------");
				System.out.println("1.일반공격 | 2.특수공격 | 3.나가기");
				System.out.println("---------------------------------------------------");
				System.out.print("번호선택: ");
			}
			int select = scan.nextInt();

			// 배틀
			if (select == 1 && login == true && num == 2) {
				// 일반공격
				monsterList = battleSv.monsterNormalAttack(monsterList, characterList, clientList);
				characterList = battleSv.characterNormalAttack(characterList, monsterList, clientList);
				monsterList = battleSv.battleEnd(characterList, monsterList, clientList);
			} else if (select == 2 && login == true && num == 2) {
				// 특수공격
				monsterList = battleSv.monsterSpecialttack(monsterList, characterList, clientList);
				characterList = battleSv.characterSpecialAttack(characterList, monsterList, clientList);
				monsterList = battleSv.battleEnd(characterList, monsterList, clientList);
			}

			// 로그인 후
			if (select == 1 && login == true && num == 1) {
				// 몬스터사냥
				num = 2;
				monsterList = monsterSv.monsterChoice(monsterList);
				characterSv.characterName(clientList, characterList);
			} else if (select == 2 && login == true && num == 1) {
				// 무기강화
				characterList = characterSv.weaponPowerUp(characterList, clientList);

			} else if (select == 3 && login == true && num == 1) {
				// 캐릭터상태
				characterSv.characterStatus(characterList, clientList);
			} else if (select == 4 && login == true && num == 1) {
				// 피회복
				characterList = characterSv.hpRecovery(characterList, clientList);
			} else if (select == 5 && login == true && num == 1) {
				// 로그아웃
				clientList = clientSv.memberOnOut(clientList);
				login = false;
				num = 0;
			}

			// 나가기
			if (select == 3 && login == true && num == 2) {
				num = 1;
				monsterList = monsterSv.monsterElimination(monsterList,characterList,clientList);
			}

			// 로그인 전
			if (select == 1 && login == false && num == 0) {
				// 회원가입
				clientList = clientSv.memberShip(clientList, characterList);
			} else if (select == 2 && login == false && num == 0) {
				// 회원조회
				clientSv.memberCheck(clientList);
			} else if (select == 3 && login == false && num == 0) {
				// 로그인
				clientList = clientSv.memberLogin(clientList);
				for (int i = 0; i < clientList.size(); i++) {
					if (clientList.get(i).isOnOut() == true) {
						login = true;
						num = 1;
					}
				}

			} else if (select == 4 && login == false && num == 0) {
				// 종료
				System.out.println("종료 합니다.");
				run = false;
			}

		}

	}

}
