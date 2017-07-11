
package com.iqmsoft.camel.spark;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class UserService {

	private final Map<String, User> users = new TreeMap<>();

	public UserService() {
		users.put("123", new User(123, "John Doe"));
		users.put("456", new User(456, "Donald Duck"));
		users.put("789", new User(789, "Roberts"));
	}

	public User getUser(String id) {
		return users.get(id);
	}

	public Collection<User> listUsers() {
		return users.values();
	}

	public User updateUser(User user) {
		return users.put("" + user.getId(), user);
	}
}
