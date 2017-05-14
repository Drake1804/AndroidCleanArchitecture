package com.androidcleanarchitecture.ui.users;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
public class UsersFragment extends Fragment implements IUsersView {

    @Inject
    IUsersPresenter usersPresenter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.emptyView)
    AppCompatTextView emptyView;

    private Unbinder unbinder;
    private UsersAdapter adapter;
    private ProgressDialog progressDialog;

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

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new UsersAdapter();
        recyclerView.setAdapter(adapter);
        progressDialog = new ProgressDialog(getContext(), ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(getContext().getString(R.string.loading));

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
        progressDialog.show();
    }

    @Override
    public void showError(String text) {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        emptyView.setText(text);
    }

    @Override
    public void dismissProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showUsers(List<User> users) {
        adapter.setUsers(users);
    }

    @Override
    public void showMessage(String message, int length) {
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, length).show();
    }
}
