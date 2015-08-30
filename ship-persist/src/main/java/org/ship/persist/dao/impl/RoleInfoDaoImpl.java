package org.ship.persist.dao.impl;

import org.ship.persist.base.impl.BaseDaoImpl;
import org.ship.persist.dao.IRoleInfoDao;
import org.ship.persist.model.RoleInfo;
import org.springframework.stereotype.Repository;

@Repository("roleInfoDao")
public class RoleInfoDaoImpl extends BaseDaoImpl<RoleInfo, Long> implements IRoleInfoDao {

}
