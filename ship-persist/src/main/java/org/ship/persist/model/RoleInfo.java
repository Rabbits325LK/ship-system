package org.ship.persist.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * RoleInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_info", catalog = "ship_system")
public class RoleInfo implements java.io.Serializable {

	// Fields

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8135629533691186952L;
	/**
	 * 
	 */
	private Long roleId;
	private String roleName;
	private String roleDescription;
	private Set<UserInfo> users = new HashSet<UserInfo>();
	private Set<ModuleInfo> modules = new HashSet<ModuleInfo>();
	// Constructors

	/** default constructor */
	public RoleInfo() {
	}

	/** full constructor */
	public RoleInfo(String roleName) {
		this.roleName = roleName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 32)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_description", length = 255)
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@ManyToMany(mappedBy = "roles")
	public Set<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserInfo> users) {
		this.users = users;
	}

	 @ManyToMany(targetEntity = ModuleInfo.class, fetch = FetchType.EAGER)  
	    @JoinTable(name = "role_module", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))  
	public Set<ModuleInfo> getModules() {
		return modules;
	}

	public void setModules(Set<ModuleInfo> modules) {
		this.modules = modules;
	}
	
	
}