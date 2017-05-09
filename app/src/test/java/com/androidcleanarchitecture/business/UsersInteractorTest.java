package com.androidcleanarchitecture.business;

import com.androidcleanarchitecture.business.interactors.UsersInteractor;
import com.androidcleanarchitecture.business.models.Address;
import com.androidcleanarchitecture.business.models.Company;
import com.androidcleanarchitecture.business.models.Geo;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.data.repositories.users.IUsersRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by drake1804 on 5/9/17.
 */

public class UsersInteractorTest {

    private IUsersRepository usersRepository;
    private UsersInteractor usersInteractor;

    @Before
    public void beforeEachTest() {
        usersRepository = mock(IUsersRepository.class);
        usersInteractor = new UsersInteractor(usersRepository);
    }

    @Test
    public void getUsers_allSuccess() {
//        mock
        List<User> userModelList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = User.builder()
                    .setId((short) (i + 1))
                    .setName("Name" + i)
                    .setUsername("Username" + i)
                    .setEmail("Email" + i)
                    .setAddress(Address.builder()
                            .setStreet("street")
                            .setSuite("suite")
                            .setCity("city")
                            .setZipcode("zipcode")
                            .setGeo(Geo.builder().setLat(10).setLng(20).build()).build())
                    .setPhone("Phone" + i)
                    .setWebsite("Website" + i)
                    .setCompany(Company.builder().setName("Name").setCatchPhrase("cp").setBs("bs").build())
                    .build();
            userModelList.add(user);
        }
        when(usersRepository.getUsers()).thenReturn(Observable.just(userModelList));

//        create TestSubscriber
        TestObserver<List<User>> testObserver = TestObserver.create();
//        call method and get result
        usersInteractor.getUsers().subscribe(testObserver);
        testObserver.awaitTerminalEvent();
        testObserver.assertNoErrors();
        testObserver.assertComplete();
    }

}
