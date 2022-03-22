import com.aiguigu.crowd.entity.Admin;
import com.aiguigu.crowd.entity.Role;
import com.org.crowd.mapper.AdminMapper;
import com.org.crowd.mapper.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void testMapper(){
        Admin admin = new Admin(2,"tom222","123123","汤姆","tom@qq.com",null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响的行数："+count);
    }


    @Test
    public void testRoleSave(){
        for (int i = 0; i < 235; i++) {
            Role role = new Role(null, "role" + i);
            roleMapper.insert(role);
        }
    }

}
