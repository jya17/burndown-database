package test.app.sample.dao;

import java.util.Map;

import test.app.sample.domain.Story;
import test.app.sample.util.DaoException;

public interface StoryDao { 

    public int create( Story value ) throws DaoException;

    public int update( Story value ) throws DaoException;

    public int delete( Map<String, Object> map ) throws DaoException;

    public Story read( Map<String, Object> map ) throws DaoException;


    // PROTECTED CODE -->

}