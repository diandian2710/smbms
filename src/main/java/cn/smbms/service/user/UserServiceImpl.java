package cn.smbms.service.user;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String userCode, String userPassword) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getLoginUser(userCode);
        sqlSession.close();
        if(null != user){
            if(!user.getUserPassword().equals(userPassword)){
                user=null;
            }
        }
        return user;
    }
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getLoginUser("admin");
        System.out.println(admin);
        sqlSession.close();
    }

}
