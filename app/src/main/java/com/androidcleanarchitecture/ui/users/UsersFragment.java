package com.androidcleanarchitecture.ui.users;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidcleanarchitecture.ACAApplication;
import com.androidcleanarchitecture.R;
import com.androidcleanarchitecture.business.models.User;
import com.androidcleanarchitecture.di.interfaces.ui.IUsersPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements IUsersView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    IUsersPresenter usersPresenter;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.emptyView)
    AppCompatTextView emptyView;

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
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);
        usersPresenter.bindView(this);
        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        usersPresenter.loadUsers();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersPresenter.unbindView();
        unbinder.unbind();
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showError(String text) {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        emptyView.setText(text);
    }

    @Override
    public void dismissProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showUsers(List<User> users) {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        adapter.setUsers(users);
    }

    @Override
    public void showMessage(String message, int length) {
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, length).show();
    }

    @Override
    public void onRefresh() {
        usersPresenter.loadUsers();
    }
}
