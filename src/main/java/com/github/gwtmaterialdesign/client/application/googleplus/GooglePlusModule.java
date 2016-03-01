package com.github.gwtmaterialdesign.client.application.googleplus;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class GooglePlusModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(GooglePlusPresenter.class, GooglePlusPresenter.MyView.class, GooglePlusView.class, GooglePlusPresenter.MyProxy.class);
    }
}
