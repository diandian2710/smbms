package cn.smbms.dao.user;

import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User getLoginUser(@Param("userCode") String userCode );
}
