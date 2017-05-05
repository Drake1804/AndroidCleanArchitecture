package com.androidcleanarchitecture.ui.users;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidcleanarchitecture.ACAApplication;
import com.androidcleanarchitecture.R;
import com.androidcleanarchitecture.business.models.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements IUsersView {

    @Inject
    IUsersPresenter usersPresenter;

    RecyclerView recyclerView;

    private Unbinder unbinder;
    private UsersAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ACAApplication.get(getActivity()).plusUsersComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ButterKnife.bind(getActivity(), view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        unbinder = ButterKnife.bind(getActivity(), view);
        usersPresenter.bindView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);
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
