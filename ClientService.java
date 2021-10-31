package monsterGame;

import java.util.*;

public class ClientService {

	// 회원가입
	public List<ClientDTO> memberShip(List<ClientDTO> clientList, List<CharacterDTO> characterList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String password = scan.next();
		System.out.print("닉네임: ");
		String name = scan.next();
		int memberNum = clientList.size() + 1;
		boolean onOut = false;
		boolean loginOut = false;
		CharacterDTO cMember = new CharacterDTO(memberNum, name, 100, 10, 1000);
		ClientDTO mMember = new ClientDTO(memberNum, id, password, name, onOut);
		clientList.add(mMember);
		characterList.add(cMember);

		return clientList;
	}

	// 회원조회
	public void memberCheck(List<ClientDTO> clientList) {
		for (ClientDTO n : clientList) {
			System.out.println(n);
		}
	}

	// 로그인
	public List<ClientDTO> memberLogin(List<ClientDTO> clientList) {
		int checkResult = clientCheck(clientList);

		if(checkResult >= 0) {
			clientList.get(checkResult).setOnOut(true);
			System.out.println(clientList.get(checkResult).getName()+ " 님 로그인 되었습니다.");
		} else {
			System.out.println("아이디와 비밀번호가 틀렸습니다.");
		}
			return clientList;
		}
	
	// 로그인 체크
	public int clientCheck(List<ClientDTO> clientList) {
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디: ");
		String id = scan.next();
		System.out.print("비밀번호: ");
		String password = scan.next();

		int clientNumber = -1;

		for (int i = 0; i < clientList.size(); i++) {
			if (id.equals(clientList.get(i).getId()) && password.equals(clientList.get(i).getPassword())) {
				clientNumber = i;
			}
		}
		return clientNumber;
	}

	// 로그아웃
	public List<ClientDTO> memberOnOut(List<ClientDTO> clientList) {
		for (int i = 0; i < clientList.size(); i++) {
			if (clientList.get(i).isOnOut() == true) {
				clientList.get(i).setOnOut(false);
				System.out.println("로그아웃 되었습니다.");
			} 
		}
		return clientList;
	}

}
