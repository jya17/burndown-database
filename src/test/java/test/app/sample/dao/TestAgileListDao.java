package test.app.sample.dao;

import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.ibatis.session.SqlSession;
import test.app.sample.domain.*;

public class TestAgileListDao {

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
        AgileListDao agileListDao = session.getMapper( AgileListDao.class );

        try {

            AgileList agileList = TestAgileListDao.createAgileList();
            String where = "STORY_ID='" + agileList.getStoryId() + "' ";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "where", where );

            int count = agileListDao.create( agileList );
            assertEquals( 1, count );
            assertNotNull( agileList.getStoryId() );

            AgileList readRecord = agileListDao.read( map );
            assertNotNull( readRecord.getStoryId() );

            compareRecords( agileList, readRecord );

            List<AgileList> list1= agileListDao.getListByStoryId( agileList.getStoryId() ) ; 
            assertEquals( 1, list1.size() );
            compareRecords( agileList, list1.get( 0 ) );

            modifyRecord( agileList );
            count = agileListDao.update( agileList );
            assertEquals( 1, count );

            readRecord = agileListDao.read( map );
            assertNotNull( readRecord.getStoryId() );

            compareRecords( agileList, readRecord );

            count = agileListDao.delete( map );
            assertEquals( 1, count );

            readRecord = agileListDao.read( map );
            assertNull( readRecord );

        } finally {
            if ( session != null ) {
                session.rollback();
                session.close();
            }
        }
    }

    public static AgileList createAgileList() {
        AgileList agileList = new AgileList();

        agileList.setStoryId( (long) 0 );
        agileList.setTitle( randomString( "title", 40 ) );

        return agileList;
    }

    public static void compareRecords( AgileList agileList, AgileList readRecord ) {

        assertEquals( agileList.getTitle(), readRecord.getTitle() );

    }

    public static void modifyRecord( AgileList agileList ) {

        agileList.setTitle( randomString( "title", 40 ) );

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