package theFallen;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Role {

	@Id
	@GeneratedValue
	private long id;
	
	private String role;
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<FallenUser> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<FallenUser> getUsers() {
		return users;
	}

	public void setUsers(Set<FallenUser> users) {
		this.users = users;
	}
	
	
}
