package com.androidcleanarchitecture.data;

import com.androidcleanarchitecture.data.db.DbService;
import com.androidcleanarchitecture.data.repositories.users.IUsersRepository;
import com.androidcleanarchitecture.data.repositories.users.UsersRepository;
import com.androidcleanarchitecture.data.rest.RestService;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by drake1804 on 5/9/17.
 */

public class UsersRepositoryTest {

    private RestService restService;
    private DbService dbService;
    private IUsersRepository usersRepository;

    @Before
    public void beforeTest() {
        restService = mock(RestService.class);
        dbService = mock(DbService.class);
        usersRepository = new UsersRepository(restService, dbService);
    }

    @Test
    public void getUsers_AllSuccess() {

    }

}
