package com.github.gwtmaterialdesign.client.application.googledrive;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class GoogleDriveModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(GoogleDrivePresenter.class, GoogleDrivePresenter.MyView.class, GoogleDriveView.class, GoogleDrivePresenter.MyProxy.class);
    }
}
