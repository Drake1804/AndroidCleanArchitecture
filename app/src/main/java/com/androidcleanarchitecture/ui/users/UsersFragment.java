package com.androidcleanarchitecture.ui.users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidcleanarchitecture.R;
import com.androidcleanarchitecture.business.models.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements IUsersView {

    @Inject
    IUsersPresenter usersPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private UsersAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.bind(getActivity());
        unbinder = ButterKnife.bind(getActivity(), view);
        usersPresenter.bindView(this);
        adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        usersPresenter.loadUsers();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showUsers(List<User> users) {
        adapter.setUsers(users);
    }
}
