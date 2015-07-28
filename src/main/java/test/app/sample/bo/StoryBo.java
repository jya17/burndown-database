package test.app.sample.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.*;
import test.app.sample.dao.*;
import test.app.sample.domain.Story;
import test.app.sample.util.BoException;

public class StoryBo {

    private static StoryBo instance = new StoryBo();

    public static StoryBo getInstance() {
        return instance;
    } 

    private StoryBo() {
    } 

    public int create( Story value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            StoryDao mapper = session.getMapper( StoryDao.class );
            result = mapper.create( value );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public int update( Story value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            StoryDao mapper = session.getMapper( StoryDao.class );
            result = mapper.update( value );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public int delete( Long key ) throws BoException {
        SqlSession session = null;
        int result = 0;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            StoryDao mapper = session.getMapper( StoryDao.class );
            result = mapper.delete( map );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    public Story read( Long key ) throws BoException {
        SqlSession session = null;
        Story result;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            StoryDao mapper = session.getMapper( StoryDao.class );
            result = mapper.read( map );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return result;
    }

    // PROTECTED CODE -->

}