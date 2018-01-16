package com.example.arturbaboskin.planet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetListFragment extends MvpAppCompatFragment implements IListPlanetView {

    @InjectPresenter
    PlanetListFragmentPresenter presenter;

    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.list_swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;

    private PlanetListAdapter adapter;

    public PlanetListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PlanetListAdapter(new PlanetListAdapter.OnClickListener() {
            @Override
            public void onClick(Planet planet) {
            }
        });
        list.setAdapter(adapter);
        list.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadPlanetsList();
            }
        });

        if (savedInstanceState == null)
            presenter.loadPlanetsList();
    }

    @Override
    public void startLoad() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoad() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void success(ArrayList<Planet> planets) {
        adapter.setData(planets);
    }

    @Override
    public void error() {
        Snackbar.make(list, "Что - то пошло не так :(", Snackbar.LENGTH_LONG).show();
    }
}
