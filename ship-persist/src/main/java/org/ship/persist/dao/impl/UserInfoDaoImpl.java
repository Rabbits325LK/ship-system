package org.ship.persist.dao.impl;



import org.ship.persist.base.impl.BaseDaoImpl;
import org.ship.persist.dao.IUserInfoDao;
import org.ship.persist.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo, Long> implements IUserInfoDao{


}
