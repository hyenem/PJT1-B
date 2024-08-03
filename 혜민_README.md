# 혜민

### 클래스 다이어그램이랑 다르게 된 점
* savaUserData 메서드에 파라메터가 없어도 될 것 같다.
* UserImpl 을 Array가 아니라 List로 관리하면 굳이 maxsize를 설정해 놓을 이유가 없을수도?!?!
* 하나의 user에 여러개의 정보를 저장할게 없으니까 HashMap을 사용하기 보다는 그냥 List로 관리하는게 맞는듯
* login, logout은 UI 클래스에서 구성하는게 나을듯 (Iusermanager에서도 userimpl에서도 제거)
* loaddata를 Iusermanager와 userimpl에 추가해야함
* getList도 UI로 빼는게 나을듯