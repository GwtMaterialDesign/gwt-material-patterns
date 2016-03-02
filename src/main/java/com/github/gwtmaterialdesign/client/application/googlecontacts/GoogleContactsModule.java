package com.github.gwtmaterialdesign.client.application.googlecontacts;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class GoogleContactsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(GoogleContactsPresenter.class, GoogleContactsPresenter.MyView.class, GoogleContactsView.class, GoogleContactsPresenter.MyProxy.class);
    }
}
