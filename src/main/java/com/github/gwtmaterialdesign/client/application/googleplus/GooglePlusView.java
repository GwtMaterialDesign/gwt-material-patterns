package com.github.gwtmaterialdesign.client.application.googleplus;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class GooglePlusView extends ViewImpl implements GooglePlusPresenter.MyView {
    interface Binder extends UiBinder<Widget, GooglePlusView> {
    }

    @Inject
    GooglePlusView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
