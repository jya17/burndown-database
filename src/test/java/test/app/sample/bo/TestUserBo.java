package test.app.sample.bo;

import static org.junit.Assert.*;
import org.junit.*;
import test.app.sample.domain.*;
import test.app.sample.dao.*;
import test.app.sample.util.*;

public class TestUserBo {

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws BoException {

        UserBo userBo = UserBo.getInstance();

        User user = TestUserDao.createUser();
        int count = userBo.create( user );
        assertEquals( 1, count );

        User readRecord = userBo.read( user.getKey() );
        assertNotNull( readRecord.getKey() );

        TestUserDao.compareRecords( user, readRecord );

        TestUserDao.modifyRecord( user );
        count = userBo.update( user );
        assertEquals( 1, count );

        count = userBo.delete( user.getKey());
        assertEquals( 1, count );

        readRecord = userBo.read( user.getKey());
        assertNull( readRecord );

    }
    // PROTECTED CODE -->

}