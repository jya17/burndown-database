package test.app.sample.dao;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.ibatis.session.SqlSession;
import test.app.sample.domain.*;

public class TestUserDao {

    private static StringBuilder sb = new StringBuilder();
    private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static Random random = new Random();

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws Exception {

        SqlSession session = SessionFactory.getSession();
        UserDao userDao = session.getMapper( UserDao.class );

        try {

            User user = TestUserDao.createUser();
            String where = "KEY='" + user.getKey() + "' ";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "where", where );

            int count = userDao.create( user );
            assertEquals( 1, count );
            assertNotNull( user.getKey() );

            User readRecord = userDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( user, readRecord );

            List<User> list1= userDao.getListByProjectId( user.getProjectId() ) ; 
            assertEquals( 1, list1.size() );
            compareRecords( user, list1.get( 0 ) );

            List<User> list2= userDao.getListBySprintId( user.getSprintId() ) ; 
            assertEquals( 1, list2.size() );
            compareRecords( user, list2.get( 0 ) );

            modifyRecord( user );
            count = userDao.update( user );
            assertEquals( 1, count );

            readRecord = userDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( user, readRecord );

            count = userDao.delete( map );
            assertEquals( 1, count );

            readRecord = userDao.read( map );
            assertNull( readRecord );

        } finally {
            if ( session != null ) {
                session.rollback();
                session.close();
            }
        }
    }

    public static User createUser() {
        User user = new User();

        user.setUsername( randomString( "username", 40 ) );
        user.setPassword( randomString( "password", 200 ) );
        user.setFirstName( randomString( "firstName", 40 ) );
        user.setLastName( randomString( "lastName", 40 ) );
        user.setEmail( randomString( "email", 40 ) );
        user.setProjectId( (long) 0 );
        user.setSprintId( (long) 0 );

        return user;
    }

    public static void compareRecords( User user, User readRecord ) {

        assertEquals( user.getUsername(), readRecord.getUsername() );
        assertEquals( user.getPassword(), readRecord.getPassword() );
        assertEquals( user.getFirstName(), readRecord.getFirstName() );
        assertEquals( user.getLastName(), readRecord.getLastName() );
        assertEquals( user.getEmail(), readRecord.getEmail() );
        assertEquals( user.getProjectId(), readRecord.getProjectId() );
        assertEquals( user.getSprintId(), readRecord.getSprintId() );

    }

    public static void modifyRecord( User user ) {

        user.setUsername( randomString( "username", 40 ) );
        user.setPassword( randomString( "password", 200 ) );
        user.setFirstName( randomString( "firstName", 40 ) );
        user.setLastName( randomString( "lastName", 40 ) );
        user.setEmail( randomString( "email", 40 ) );
        user.setProjectId( (long) 0 );
        user.setSprintId( (long) 0 );

    }

    public static int randomNumber() {

        return (int) ( Math.random() * 10 ) + 0;

    }

    public static String randomString( String fldName, int length ) {

        if ( fldName.length() >= length ) {
            return fldName.substring( 0, length );
        }

        sb.setLength( 0 );
        sb.append( fldName );
        for ( int i = fldName.length(); i < length; i++ ) {
            sb.append( chars.charAt( random.nextInt( chars.length() ) ) );
        }
        return sb.toString();
    }

    public static byte[] randomByteArray( int length ) {

        byte[] byteArray = new byte[length];
        random.nextBytes( byteArray );
        return byteArray;
    }
    // PROTECTED CODE -->

}