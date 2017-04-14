package com.github.gwtmaterialdesign.client.application.sidenavedge;

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


import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.base.TransitionConfig;
import gwt.material.design.client.ui.MaterialFAB;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNav;

import javax.inject.Inject;


public class EdgeSideNavView extends ViewImpl implements EdgeSideNavPresenter.MyView {
    interface Binder extends UiBinder<Widget, EdgeSideNavView> {
    }

    @UiField
    MaterialNavBar navBar;

    @UiField
    MaterialSideNav sideNav;

    @UiField
    MaterialFAB fab;

    @Inject
    EdgeSideNavView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        navBar.getNavMenu().setFloat(Style.Float.RIGHT);

        fab.setTransition(new TransitionConfig(sideNav.getInDuration(), "right"));
        sideNav.addOpeningHandler(event -> {
            fab.setRight(sideNav.getWidth() + 40);
        });

        sideNav.addClosingHandler(event -> {
            fab.setRight(20);
        });
    }
}
