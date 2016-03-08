package com.github.gwtmaterialdesign.client.application.googleplus;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialSplashScreen;

import javax.inject.Inject;


public class GooglePlusView extends ViewImpl implements GooglePlusPresenter.MyView {
    interface Binder extends UiBinder<Widget, GooglePlusView> {
    }

    @UiField
    MaterialSplashScreen splash;

    @Inject
    GooglePlusView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        splash.show();
        Timer t = new Timer() {
            @Override
            public void run() {
                splash.hide();
            }
        };
        t.schedule(5000);
    }
}
