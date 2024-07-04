package demo7.repo;

import java.util.HashMap;
import java.util.Map;

import demo7.vo.User;

public class UserRepository {

	private Map<String, User> db = new HashMap<String, User>();
	
	public UserRepository() {
		db.put("hong", new User("hong", "홍길동", "hong@gmail.com", "010-1111-1111", 5000));
		db.put("kim", new User("kim", "김유신", "kim@gmail.com", "010-1111-2222", 2000));
		db.put("lee", new User("lee", "이순신", "lee@gmail.com", "010-1111-3333", 3000));
		db.put("kang", new User("kang", "강감찬", "kang@gmail.com", "010-1111-4444", 5000));
	}
	
	/**
	 * 사용자 id를 전달받아서 사용자 정보를 반환한다.
	 * @param id 사용자 아이디
	 * @return 사용자 정보, null이 반환될 수 있다.
	 */
	public User getUserById(String id) {
		User foundUser = null;
		foundUser = db.get(id);
		
		return foundUser;
	}
	
	/**
	 * 신규 사용자정보를 전달받아서 저장한다.
	 * @param user 신규 사용자정보
	 */
	public void saveUser(User user) {
		db.put(user.getId(), user);
	}
}