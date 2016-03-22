package com.github.gwtmaterialdesign.client.application.googleinbox;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class GoogleInboxModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(GoogleInboxPresenter.class, GoogleInboxPresenter.MyView.class, GoogleInboxView.class, GoogleInboxPresenter.MyProxy.class);
    }
}
