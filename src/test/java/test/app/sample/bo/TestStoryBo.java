package test.app.sample.bo;

import static org.junit.Assert.*;
import org.junit.*;
import test.app.sample.domain.*;
import test.app.sample.dao.*;
import test.app.sample.util.*;

public class TestStoryBo {

    @Before
    public void setup() {
        SessionFactory.initializeForTest();
    }

    @Test
    public void test() throws BoException {

        StoryBo storyBo = StoryBo.getInstance();

        Story story = TestStoryDao.createStory();
        int count = storyBo.create( story );
        assertEquals( 1, count );

        Story readRecord = storyBo.read( story.getKey() );
        assertNotNull( readRecord.getKey() );

        TestStoryDao.compareRecords( story, readRecord );

        TestStoryDao.modifyRecord( story );
        count = storyBo.update( story );
        assertEquals( 1, count );

        count = storyBo.delete( story.getKey());
        assertEquals( 1, count );

        readRecord = storyBo.read( story.getKey());
        assertNull( readRecord );

    }
    // PROTECTED CODE -->

}