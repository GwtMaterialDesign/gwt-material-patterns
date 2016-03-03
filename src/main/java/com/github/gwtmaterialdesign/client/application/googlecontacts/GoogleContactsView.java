package com.github.gwtmaterialdesign.client.application.googlecontacts;

import com.github.gwtmaterialdesign.client.application.googlecontacts.collapsible.CustomerCollapsible;
import com.github.gwtmaterialdesign.client.dto.DataHelper;
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialCollapsible;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSearch;

import javax.inject.Inject;


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

    @Inject
    GoogleContactsView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        search.addCloseHandler(new CloseHandler<String>() {
            @Override
            public void onClose(CloseEvent<String> event) {
                appNav.setVisible(true);
                searchNav.setVisible(false);
            }
        });
        populateUsers();
    }

    private void populateUsers() {
        for(UserDTO dto : DataHelper.getAllUsers()) {
            if(dto.isStarred()) {
                starredColaps.add(new CustomerCollapsible(dto));
            }
        }
        for(UserDTO dto : DataHelper.getAllUsers()) {
            frequentColaps.add(new CustomerCollapsible(dto));
        }
    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        appNav.setVisible(false);
        searchNav.setVisible(true);
    }
}
