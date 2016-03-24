package com.github.gwtmaterialdesign.client.application.googleinbox;

import com.github.gwtmaterialdesign.client.application.googleinbox.collapsible.InboxCollapsible;
import com.github.gwtmaterialdesign.client.application.googleinbox.collapsible.InboxLinkCollapsible;
import com.github.gwtmaterialdesign.client.dto.DataHelper;
import com.github.gwtmaterialdesign.client.dto.InboxDTO;
import com.github.gwtmaterialdesign.client.dto.InboxLinkDTO;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialSplashScreen;

import javax.inject.Inject;


public class GoogleInboxView extends ViewImpl implements GoogleInboxPresenter.MyView {
    private boolean toggle = true;

    interface Binder extends UiBinder<Widget, GoogleInboxView> {
    }

    @UiField
    MaterialSplashScreen splash;

    @UiField
    MaterialCollapsible inboxColaps, inboxLinkColaps;

    @Inject
    GoogleInboxView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        for(InboxDTO dto : DataHelper.getAllTodayInbox()) {
            inboxColaps.add(new InboxCollapsible(dto));
        }
        for(InboxLinkDTO dto : DataHelper.getAllYesterdayInbox()) {
            inboxLinkColaps.add(new InboxLinkCollapsible(dto));
        }
        splash.show();
        Timer t = new Timer() {
            @Override
            public void run() {
                splash.hide();
            }
        };
        t.schedule(4500);
    }
}
