package com.example.arturbaboskin.planet;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

public interface IListPlanetView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void startLoad();
    @StateStrategyType(AddToEndSingleStrategy.class)
    void stopLoad();
    @StateStrategyType(AddToEndSingleStrategy.class)
    void success(ArrayList<Planet> planets);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void error();
}
