package com.github.gwtmaterialdesign.client.application.googleinbox;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class GoogleInboxView extends ViewImpl implements GoogleInboxPresenter.MyView {
    private boolean toggle = true;

    interface Binder extends UiBinder<Widget, GoogleInboxView> {
    }

    @Inject
    GoogleInboxView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
