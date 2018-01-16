package com.example.arturbaboskin.planet;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.orm.SugarRecord;

import java.util.ArrayList;

@InjectViewState
public class PlanetListFragmentPresenter extends MvpPresenter<IListPlanetView> {

    void loadPlanetsList(){
        getViewState().startLoad();
        APIHelper.getInstance().loadPlanets(new APIHelper.OnPlanetLoad() {
            @Override
            public void success(ArrayList<Planet> result) {
                getViewState().stopLoad();
                getViewState().success(result);
                for(Planet p: result)
                    SugarRecord.save(p);
            }

            @Override
            public void error() {
                getViewState().error();
                getViewState().stopLoad();
            }
        });
    }

}
