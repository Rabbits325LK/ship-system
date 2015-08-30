package org.ship.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ship.persist.base.impl.BaseDaoImpl;
import org.ship.persist.dao.IModuleInfoDao;
import org.ship.persist.model.ModuleInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Repository("moduleInfoDao")
public class ModuleInfoDaoImpl extends BaseDaoImpl<ModuleInfo, Long> implements IModuleInfoDao{


}
