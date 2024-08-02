+---------------------------+
|        VideoReviewDao     |
+---------------------------+
| + insertReview(VideoReview): int  |
| + selectReview(videoNo: int): List<VideoReview> |
+---------------------------+

+-----------------------------+
|    VideoReviewDaoImpl       |
+-----------------------------+
| - reviewNo: int {readonly}  |
| - videoReviewDb: Map<Integer, List<VideoReview>> |
| - instance: VideoReviewDaoImpl {readonly, static} |
+-----------------------------+
| + getInstance(): VideoReviewDaoImpl {static} |
| + insertReview(VideoReview): int |
| + selectReview(videoNo: int): List<VideoReview> |
+-----------------------------+

+---------------------------+
|        VideoDao           |
+---------------------------+
| + selectVideoByNo(no: int): Video |
| + selectVideo(): List<Video> |
+---------------------------+

+-----------------------------+
|    VideoDaoImpl             |
+-----------------------------+
| - list: List<Video>         |
| - instance: VideoDaoImpl {readonly, static} |
+-----------------------------+
| + getInstance(): VideoDaoImpl {static} |
| + selectVideo(): List<Video> |
| + selectVideoByNo(no: int): Video |
+-----------------------------+

+---------------------------+
|        VideoReview        |
+---------------------------+
| - videoNo: int            |
| - reviewNo: int           |
| - nickName: String        |
| - content: String         |
+---------------------------+
| + getVideoNo(): int       |
| + setVideoNo(videoNo: int): void |
| + getReviewNo(): int      |
| + setReviewNo(reviewNo: int): void |
| + getNickName(): String   |
| + setNickName(nickName: String): void |
| + getContent(): String    |
| + setContent(content: String): void |
+---------------------------+

+---------------------------+
|        Video              |
+---------------------------+
| - videoNo: int            |
| - title: String           |
| - description: String     |
+---------------------------+
| + getVideoNo(): int       |
| + setVideoNo(videoNo: int): void |
| + getTitle(): String      |
| + setTitle(title: String): void |
| + getDescription(): String |
| + setDescription(description: String): void |
+---------------------------+

+---------------------------+
|           User            |
+---------------------------+
| - id: String              |
| - name: String            |
| - password: String        |
| - email: String           |
+---------------------------+
| + User(id: String, name: String, password: String, email: String) |
| + getId(): String         |
| + setId(id: String): void |
| + getName(): String       |
| + setName(name: String): void |
| + getPassword(): String   |
| + setPassword(password: String): void |
| + getEmail(): String      |
| + setEmail(email: String): void |
| + toString(): String      |
+---------------------------+

+---------------------------+
|        IUserManager       |
+---------------------------+
| + searchId(id: String): User |
| + logIn(id: String, password: String): User |
| + logOut(): void          |
| + getList(): String       |
| + addUser(user: User): boolean |
| + saveUserData(file_path: String): void |
+---------------------------+

+-----------------------------+
|        UserManagerImpl      |
+-----------------------------+
| - static final MAX_USER_SIZE: int |
| - userList: Map<String, User> |
| - static instance: UserManagerImpl {static} |
+-----------------------------+
| + getInstance(): UserManagerImpl {static} |
| + searchId(id: String): User |
| + logIn(id: String, password: String): User |
| + logOut(): void            |
| + getList(): String         |
| + addUser(user: User): boolean |
| + saveUserData(file_path: String): void |
+-----------------------------+

+---------------------------+
|        MainUi             |
+---------------------------+
| + service(): void         |
| - exit(): void            |
+---------------------------+


+-----------------------------+
|         VideoUi             |
+-----------------------------+
| - videoDao: VideoDao        |
| - instance: VideoUi {readonly, static} |
+-----------------------------+
| + getInstance(): VideoUi {static} |
| + service(): void           |
| - listVideo(): void         |
| - detail(video: Video): void |
+-----------------------------+

+-----------------------------+
|        VideoReviewUi        |
+-----------------------------+
| - videoReviewDao: VideoReviewDao |
| - instance: VideoReviewUi {readonly, static} |
| - videoNo: int              |
+-----------------------------+
| + getInstance(videoNo: int): VideoReviewUi {static} |
| + service(): void           |
| - listReview(): void        |
| - registReview(): void      |
+-----------------------------+

+---------------------------+
|        SsafitUtil         |
+---------------------------+
| - sc: Scanner {readonly}  |
+---------------------------+
| + input(msg: String): String |
| + inputInt(msg: String): int |
| + printLine(): void       |
| + printLine(ch: char): void |
| + printLine(ch: char, len: int): void |
| + screenClear(): void     |
+---------------------------+

+---------------------------+
|    SsafitApplication      |
+---------------------------+
| + main(args: String[]): void |
+---------------------------+


관계도
SsafitApplication <--> MainUi: 양방향 연관 관계
MainUi <--> VideoUi: 양방향 연관 관계
VideoUi --> VideoDao: 집합 관계
VideoDaoImpl --> VideoDao: 구현 관계
VideoDaoImpl --> Video: 집합 관계
VideoUi <--> VideoReviewUi: 양방향 연관 관계
VideoReviewUi --> VideoReviewDao: 집합 관계
VideoReviewDaoImpl --> VideoReviewDao: 구현 관계
VideoReviewDaoImpl --> VideoReview: 집합 관계
MainUi --> UserManagerImpl: 집합 관계
UserManagerImpl --> IUserManager: 구현 관계
UserManagerImpl --> User: 집합 관계

요약
회원 관리 기능 추가: 사용자 정보 관리 및 파일 저장/로드 기능 추가.
싱글톤 패턴: 여러 클래스에서 싱글톤 패턴을 사용하여 인스턴스 관리.
인터페이스와 구현 클래스 분리: 인터페이스와 구현 클래스를 분리하여 코드의 확장성과 유지보수성을 높임.
양방향 연관 관계 및 집합 관계 명시: 클래스 간의 명확한 관계 설정.
유틸리티 클래스 추가: 공통 기능을 별도의 유틸리티 클래스로 분리하여 재사용성을 높임.