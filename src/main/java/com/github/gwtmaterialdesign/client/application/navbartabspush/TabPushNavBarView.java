package com.github.gwtmaterialdesign.client.application.navbartabspush;

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


import com.github.gwtmaterialdesign.client.application.navbartabs.TabNavBarPresenter;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.design.client.ui.MaterialTab;

import javax.inject.Inject;


public class TabPushNavBarView extends ViewImpl implements TabPushNavBarPresenter.MyView {
    interface Binder extends UiBinder<Widget, TabPushNavBarView> {
    }

    @UiField
    MaterialSideNav sidenav;

    @UiField
    MaterialTab tab;

    @Inject
    TabPushNavBarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        sidenav.addOpenedHandler(event -> {
            tab.resize();
        });
        sidenav.addClosedHandler(event -> {
            tab.resize();
        });
    }
}
