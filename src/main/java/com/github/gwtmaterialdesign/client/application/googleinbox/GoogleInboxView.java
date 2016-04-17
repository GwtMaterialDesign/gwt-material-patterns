package com.github.gwtmaterialdesign.client.application.googleinbox;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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
