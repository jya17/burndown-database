package test.app.sample.bo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.*;
import test.app.sample.dao.*;
import test.app.sample.domain.User;
import test.app.sample.util.BoException;

public class UserBo {

    private static UserBo instance = new UserBo();

    public static UserBo getInstance() {
        return instance;
    } 

    private UserBo() {
    } 

    public int create( User value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            UserDao mapper = session.getMapper( UserDao.class );
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

    public int update( User value ) throws BoException {
        SqlSession session = null;
        int result = 0;

        try {
            session = SessionFactory.getSession();
            UserDao mapper = session.getMapper( UserDao.class );
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
            UserDao mapper = session.getMapper( UserDao.class );
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

    public User read( Long key ) throws BoException {
        SqlSession session = null;
        User result;
        String where = "KEY='" + key + "' ";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put( "where", where );

        try {
            session = SessionFactory.getSession();
            UserDao mapper = session.getMapper( UserDao.class );
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