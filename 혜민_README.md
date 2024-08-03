# 혜민

## 준비 단계
1. 조직 문화
    * 팀 분석
        * 예민한 구석이 없고 적극성이 높은 성향으로 구성이 되어 있음.
        * 한 명의 연장자와 두 명의 동갑인 인원으로 구성되어 있으나 연장자 특유의 부드러운 성향 덕에 위계가 보이지 않는 구성임.
        * 모두가 자신도 모르는 사이에 다른 사람의 기분을 상하게 할까 걱정하는 마음에 공감함.
    * 갈등 관리를 위한 전략
        * 갈등이 생기면 그 자리에서 바로 해결하기.
        * 기분이 나쁘면 솔직히 이야기하고 오해가 아닌지 확인하기.
        * 이야기를 곧이 곧대로 받아들이기. 혼자 넘겨짚지 말기
    * 원활한 협업을 위한 전략
        * 주기적으로 어디까지 했는지, 어떤 걸 하고있는지 공유
            * 불필요하게 업무가 중복되는 경우를 막음
        * 모두의 코드를 알고있기(자기 파트만 알고 있으면 전체적인 흐름을 볼 수 없음)
        * 주변 사람이 집중 중일때는 급한 사항이 아니면 우선 mm으로 남겨두기.

2. git 관리
    * 팀장 정우가 레포 만들어서 관리
    * 각자 정우 레포 포크해와서 자기 레포에 push
    * 이후 정우 레포에 PR보내기

3. 프로그램 발전 수준
    * 제시된 프로그램의 명세 수준에서 크게 벗어나지 않기
    * 심화 수준까지 구현하되, 기본 수준에서 시작해서 시간되는대로 점차 더 구현하기

## ChatGPT를 이용한 클래스다이어그램 그리기
### ChatGPT 전 사전 작업
* 명세서에 주어진 클래스 다이어그램 (정우)
* 클래스와 인터페이스 사이의 관계 표현하기 (은서)
* 명세서에 주어지지 않은 User관련 클래스 다이어그램 구성하기 (혜민)

### ChatGPT 에게 요구한 것
* 프로그램의 요구를 알려주고, 더 나은 클래스 다이어그램이 있는지 물어보기
* 클래스다이어그램을 만들기 위한 planttext 문법 형태로 변환하기


## **개발 단계**
### 내 담당 : 로그인, 로그아웃, 회원가입, 회원정보조회
* User, IUserManager, UserManagerImpl, UserUi, MainUi를 작성하였다.

### User
```java
package com.ssafy.fit.model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String id;
	private String password;
	private String email;
	
    // 생성자, getter, setter, toString 생략//
	
	// 회원 비교를 위해(회원가입 가능 여부 및 로그인 여부)
	// id가 같은 경우를 같은 회원으로 볼게요.
	@Override
	public boolean equals(Object o) {
		if (o instanceof User) {
			return ((User)o).getId().equals(this.getId());
		}
		return false;
	}
	
	public int hashCode(Object o) {
		if (o instanceof User) {
			return ((User)o).hashCode();
		}
		return o.hashCode();
	}
	
}

```
* User끼리 비교할 수 있도록 equals()와 hashCode를 재정의함.
    * 이때 key값으로 id를 지정함
    * 동명 이인이 있을 수도 있고, 비밀번호는 같을 수 도 있기 때문
* 파일로 객체를 저장하고 불러들이기 위해서 Serializable 인터페이스를 구현함.

### UserManagerImpl
```java 
package com.ssafy.fit.model.dao;

//import 생략//

import com.ssafy.fit.model.User;

public class UserManagerImpl implements IUserManager, Serializable {
	private static final long serialVersionUID = 1L;
	//싱글톤으로 구성
	private List<User> userList = new ArrayList<User>();
	private static UserManagerImpl instance = new UserManagerImpl();
	
	private UserManagerImpl() {}
	
	public static UserManagerImpl getInstance() {
		return instance;
	}
	
	
	//회원가입을 위한 addUser
	//기존에 해당 회원이 있으면 false
	//없으면 리스트에 추가하고 true 리
	@Override
	public boolean addUser(User user) {
		for (int i = 0; i<userList.size(); i++) {
			if(userList.contains(user)) {
				return false;
			}
		}
		userList.add(user);
		return true;
	}
	
	// 로그인을 위한 searchId
	// Id를 찾아서 password랑 비교해주기 위해 사용됨
	@Override
	public User searchId(String id) {
		for(int i = 0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id)) {
				return userList.get(i);
			}
		}
		return null;
	}


	@Override
	public List<User> getList() {
		if (!userList.isEmpty()) {
			for(int i = 0; i<userList.size(); i++) {
				System.out.println(""+(i+1)+" "+userList.get(i).toString());
			}
		}
		return null;
	}


	@Override
	public void saveUserData() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))){
			oos.writeObject(this.userList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void loadUserData() {
		File file = new File("user.dat");
		if(file != null) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				Object o = ois.readObject();
				this.userList = (ArrayList<User>)o;
			} catch (IOException | ClassNotFoundException e) {
			}
		}
		
	}

	@Override
	public boolean matching(String id, String password) {
		if(searchId(id).getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}

```

### 클래스 다이어그램이랑 다르게 된 점
* savaUserData 메서드에 파라메터가 없어도 될 것 같다.
* UserImpl 을 Array가 아니라 List로 관리하면 굳이 maxsize를 설정해 놓을 이유가 없을수도?!?!(제거)
* 하나의 user에 여러개의 정보를 저장할게 없으니까 HashMap을 사용하기 보다는 그냥 List로 관리하는게 맞는듯
* login, logout은 UI 클래스에서 구성하는게 나을듯 (Iusermanager에서도 userimpl에서도 제거)
* loaddata를 Iusermanager와 userimpl에 추가해야함


### 개선 방향
* 시간이 더 있었으면 다른 조원들의 코드 수정을 하면서 '로그인이 되어있으면 글을 작성할때 자동으로 그 User의 정보가 포함 될 수 있도록 (굳이 자기 닉네임을 입력하지 않아도) 하는 기능'을 구현할 수 있었을 것 같다.