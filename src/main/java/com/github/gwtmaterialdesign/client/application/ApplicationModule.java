package com.github.gwtmaterialdesign.client.application;

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


import com.github.gwtmaterialdesign.client.application.googlecontacts.GoogleContactsModule;
import com.github.gwtmaterialdesign.client.application.googledrive.GoogleDriveModule;
import com.github.gwtmaterialdesign.client.application.googleinbox.GoogleInboxModule;
import com.github.gwtmaterialdesign.client.application.googleplus.GooglePlusModule;
import com.github.gwtmaterialdesign.client.application.sidenavcard.CardSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavdrawer.DrawerSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavdrawerheader.DrawerHeaderSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavfixed.FixedSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavmini.MiniSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavminiexpand.MiniExpandSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavpush.PushSideNavModule;
import com.github.gwtmaterialdesign.client.application.sidenavpushheader.PushHeaderSideNavModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new GoogleDriveModule());
        install(new GoogleContactsModule());
        install(new GooglePlusModule());
        install(new GoogleInboxModule());
        install(new FixedSideNavModule());
        install(new DrawerSideNavModule());
        install(new DrawerHeaderSideNavModule());
        install(new PushSideNavModule());
        install(new PushHeaderSideNavModule());
        install(new MiniSideNavModule());
        install(new MiniExpandSideNavModule());
        install(new CardSideNavModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
