package test.app.sample.dao;

import java.util.Map;
import java.util.List;

import test.app.sample.domain.User;
import test.app.sample.util.DaoException;

public interface UserDao { 

    public int create( User value ) throws DaoException;

    public int update( User value ) throws DaoException;

    public int delete( Map<String, Object> map ) throws DaoException;

    public User read( Map<String, Object> map ) throws DaoException;

    public List<User> getListByProjectId( Long key ) throws DaoException;
    public List<User> getListBySprintId( Long key ) throws DaoException;

    // PROTECTED CODE -->

}