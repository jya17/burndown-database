package test.app.sample.bo;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.*;
import test.app.sample.dao.*;
import test.app.sample.domain.AgileList;
import test.app.sample.util.BoException;

public class AgileListBo {

    private static AgileListBo instance = new AgileListBo();

    public static AgileListBo getInstance() {
        return instance;
    } 

    private AgileListBo() {
    } 

    public int create( AgileList value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            AgileListDao mapper = session.getMapper( AgileListDao.class );
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

    public int update( AgileList value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            AgileListDao mapper = session.getMapper( AgileListDao.class );
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

    public int delete( Long storyId ) throws BoException {
        SqlSession session = null;
        int result = 0;
        String where = "STORY_ID='" + storyId + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            AgileListDao mapper = session.getMapper( AgileListDao.class );
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

    public AgileList read( Long storyId ) throws BoException {
        SqlSession session = null;
        AgileList result;
        String where = "STORY_ID='" + storyId + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            AgileListDao mapper = session.getMapper( AgileListDao.class );
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

    public List<AgileList> getListByStoryId( Long key ) throws BoException {
        SqlSession session = null;
        List<AgileList> list;

        try {
            session = SessionFactory.getSession();
            AgileListDao mapper = session.getMapper( AgileListDao.class );
            list = mapper.getListByStoryId( key );
            session.commit();

        } catch ( Exception e ) {
            session.rollback();
            throw new BoException( e );

        } finally { 
            if ( session != null )
                session.close();
        }

        return list;
    }

    // PROTECTED CODE -->

}