package test.app.sample.dao;

import java.util.Date;
import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.ibatis.session.SqlSession;
import test.app.sample.domain.*;

public class TestSprintDao {

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
        SprintDao sprintDao = session.getMapper( SprintDao.class );

        try {

            Sprint sprint = TestSprintDao.createSprint();
            String where = "KEY='" + sprint.getKey() + "' ";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "where", where );

            int count = sprintDao.create( sprint );
            assertEquals( 1, count );
            assertNotNull( sprint.getKey() );

            Sprint readRecord = sprintDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( sprint, readRecord );

            List<Sprint> list1= sprintDao.getListByBacklogId( sprint.getBacklogId() ) ; 
            assertEquals( 1, list1.size() );
            compareRecords( sprint, list1.get( 0 ) );

            List<Sprint> list2= sprintDao.getListByDoingId( sprint.getDoingId() ) ; 
            assertEquals( 1, list2.size() );
            compareRecords( sprint, list2.get( 0 ) );

            List<Sprint> list3= sprintDao.getListByDoneId( sprint.getDoneId() ) ; 
            assertEquals( 1, list3.size() );
            compareRecords( sprint, list3.get( 0 ) );

            modifyRecord( sprint );
            count = sprintDao.update( sprint );
            assertEquals( 1, count );

            readRecord = sprintDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( sprint, readRecord );

            count = sprintDao.delete( map );
            assertEquals( 1, count );

            readRecord = sprintDao.read( map );
            assertNull( readRecord );

        } finally {
            if ( session != null ) {
                session.rollback();
                session.close();
            }
        }
    }

    public static Sprint createSprint() {
        Sprint sprint = new Sprint();

        sprint.setTitle( randomString( "title", 200 ) );
        sprint.setDescription( randomString( "description", 1000 ) );
        sprint.setBacklogId( (long) 0 );
        sprint.setDoingId( (long) 0 );
        sprint.setDoneId( (long) 0 );
        sprint.setStartDate( new Date() );
        sprint.setEndDate( new Date() );

        return sprint;
    }

    public static void compareRecords( Sprint sprint, Sprint readRecord ) {

        assertEquals( sprint.getTitle(), readRecord.getTitle() );
        assertEquals( sprint.getDescription(), readRecord.getDescription() );
        assertEquals( sprint.getBacklogId(), readRecord.getBacklogId() );
        assertEquals( sprint.getDoingId(), readRecord.getDoingId() );
        assertEquals( sprint.getDoneId(), readRecord.getDoneId() );
        assertNotSame( sprint.getStartDate(), readRecord.getStartDate() );
        assertNotSame( sprint.getEndDate(), readRecord.getEndDate() );

    }

    public static void modifyRecord( Sprint sprint ) {

        sprint.setTitle( randomString( "title", 200 ) );
        sprint.setDescription( randomString( "description", 1000 ) );
        sprint.setBacklogId( (long) 0 );
        sprint.setDoingId( (long) 0 );
        sprint.setDoneId( (long) 0 );
        sprint.setStartDate( new Date() );
        sprint.setEndDate( new Date() );

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