package test.app.sample.dao;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.*;
import org.apache.ibatis.session.SqlSession;
import test.app.sample.domain.*;

public class TestStoryDao {

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
        StoryDao storyDao = session.getMapper( StoryDao.class );

        try {

            Story story = TestStoryDao.createStory();
            String where = "KEY='" + story.getKey() + "' ";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "where", where );

            int count = storyDao.create( story );
            assertEquals( 1, count );
            assertNotNull( story.getKey() );

            Story readRecord = storyDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( story, readRecord );

            modifyRecord( story );
            count = storyDao.update( story );
            assertEquals( 1, count );

            readRecord = storyDao.read( map );
            assertNotNull( readRecord.getKey() );

            compareRecords( story, readRecord );

            count = storyDao.delete( map );
            assertEquals( 1, count );

            readRecord = storyDao.read( map );
            assertNull( readRecord );

        } finally {
            if ( session != null ) {
                session.rollback();
                session.close();
            }
        }
    }

    public static Story createStory() {
        Story story = new Story();

        story.setDescription( randomString( "description", 500 ) );
        story.setEstimatedHours( randomNumber() );
        story.setRemainingHours( randomNumber() );
        story.setProjectId( randomNumber() );

        return story;
    }

    public static void compareRecords( Story story, Story readRecord ) {

        assertEquals( story.getDescription(), readRecord.getDescription() );
        assertEquals( story.getEstimatedHours(), readRecord.getEstimatedHours() );
        assertEquals( story.getRemainingHours(), readRecord.getRemainingHours() );
        assertEquals( story.getProjectId(), readRecord.getProjectId() );

    }

    public static void modifyRecord( Story story ) {

        story.setDescription( randomString( "description", 500 ) );
        story.setEstimatedHours( randomNumber() );
        story.setRemainingHours( randomNumber() );
        story.setProjectId( randomNumber() );

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