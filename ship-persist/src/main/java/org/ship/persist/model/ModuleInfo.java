package org.ship.persist.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module_info", catalog = "ship_system")
public class ModuleInfo implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long moduleId;
	private String moduleName;
	private String moduleType;
	private String moduleStr;
	private Integer modulePriority;
	private String moduleDescription;
	private Set<RoleInfo> roles = new HashSet<RoleInfo>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column( name = "module_id", unique = true, nullable = false)
	public Long getModuleId() {
		return moduleId;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
	@Column( name = "module_name", length = 50)
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Column( name = "module_type", length = 15)
	public String getModuleType() {
		return moduleType;
	}
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}
	
	@Column( name = "module_str", length = 255)
	public String getModuleStr() {
		return moduleStr;
	}
	public void setModuleStr(String moduleStr) {
		this.moduleStr = moduleStr;
	}
	
	@Column( name = "module_priority", nullable = false)
	public Integer getModulePriority() {
		return modulePriority;
	}
	public void setModulePriority(Integer modulePriority) {
		this.modulePriority = modulePriority;
	}
	
	@Column( name = "module_description", length = 255)
	public String getModuleDescription() {
		return moduleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}
	
	@ManyToMany(mappedBy = "modules", targetEntity = RoleInfo.class, fetch = FetchType.EAGER)  
	public Set<RoleInfo> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleInfo> roles) {
		this.roles = roles;
	}
	
	
}
