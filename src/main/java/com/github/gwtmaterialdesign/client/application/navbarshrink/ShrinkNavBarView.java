package com.github.gwtmaterialdesign.client.application.navbarshrink;

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


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;

import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;


public class ShrinkNavBarView extends ViewImpl implements ShrinkNavBarPresenter.MyView {
    interface Binder extends UiBinder<Widget, ShrinkNavBarView> {
    }

    @UiField
    MaterialNavBarShrink navBar;

    @UiField
    MaterialFAB fab;

    @UiField
    MaterialSideNav sideNav;

    @Inject
    ShrinkNavBarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        navBar.addExpandHandler(event -> {
            fab.setVisible(true);
            MaterialToast.fireToast("Expanded");
        });

        navBar.addShrinkHandler(event -> {
            fab.setVisible(false);
            MaterialToast.fireToast("Shrink");
        });
    }

}