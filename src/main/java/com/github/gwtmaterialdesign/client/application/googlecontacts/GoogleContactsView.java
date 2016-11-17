package com.github.gwtmaterialdesign.client.application.googlecontacts;

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


import com.github.gwtmaterialdesign.client.application.googlecontacts.collapsible.CustomerCollapsible;
import com.github.gwtmaterialdesign.client.application.googlecontacts.overlay.ProfileOverlay;
import com.github.gwtmaterialdesign.client.dto.DataHelper;
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class GoogleContactsView extends ViewImpl implements GoogleContactsPresenter.MyView {
    interface Binder extends UiBinder<Widget, GoogleContactsView> {
    }

    @UiField
    MaterialNavBar appNav, searchNav;

    @UiField
    MaterialSearch search;

    @UiField
    MaterialIcon btnSearch;

    @UiField
    MaterialCollapsible starredColaps, frequentColaps;

    @UiField
    ProfileOverlay profileOverlay;

    @UiField
    MaterialSplashScreen splash;

    @Inject
    GoogleContactsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        splash.show();
        Timer t = new Timer() {
            @Override
            public void run() {
                splash.hide();
            }
        };
        t.schedule(5000);
        search.addCloseHandler(event -> {
            appNav.setVisible(true);
            searchNav.setVisible(false);
        });
        search.addKeyUpHandler(event -> {
            List<UserDTO> filteredUser = DataHelper.getAllUsers().stream().filter(dto -> dto.getName().toLowerCase().contains(search.getText().toLowerCase())).collect(Collectors.toList());
            populateUsers(filteredUser);
        });
        populateUsers(DataHelper.getAllUsers());
    }

    /**
     * Populate the starred and frequent collapsibles
     * @param allUsers
     */
    private void populateUsers(List<UserDTO> allUsers) {
        starredColaps.clear();
        frequentColaps.clear();
        allUsers.stream().filter(UserDTO::isStarred).forEach(dto -> {
            starredColaps.add(new CustomerCollapsible(dto, this));
        });
        for(UserDTO dto : allUsers) {
            frequentColaps.add(new CustomerCollapsible(dto, this));
        }
    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        appNav.setVisible(false);
        searchNav.setVisible(true);
    }

    @UiHandler("sortName")
    void onSortFirst(ClickEvent e) {
        List<UserDTO> sortedUsers = DataHelper.getAllUsers();
        Collections.sort(sortedUsers, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        populateUsers(sortedUsers);
    }

    @UiHandler("sortPosition")
    void onSortPosition(ClickEvent e) {
        List<UserDTO> sortedUsers = DataHelper.getAllUsers();
        Collections.sort(sortedUsers, (o1, o2) -> o1.getPosition().getValue().compareToIgnoreCase(o2.getPosition().getValue()));
        populateUsers(sortedUsers);
    }

    /**
     * Open the profile overlay to view the user details
     * @param colaps
     */
    public void openProfileOverlay(CustomerCollapsible colaps) {
        profileOverlay.setCustomerCollapsible(colaps);
        MaterialPathAnimator.animate(colaps.getColapsItem().getElement(), profileOverlay.getOverlay().getElement());
    }
}
