package com.github.gwtmaterialdesign.client.application.googlecontacts;

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
        search.addCloseHandler(new CloseHandler<String>() {
            @Override
            public void onClose(CloseEvent<String> event) {
                appNav.setVisible(true);
                searchNav.setVisible(false);
            }
        });
        search.addKeyUpHandler(new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent event) {
                List<UserDTO> filteredUser = new ArrayList<>();
                for(UserDTO dto : DataHelper.getAllUsers()) {
                    if(dto.getName().toLowerCase().contains(search.getText().toLowerCase())){
                        filteredUser.add(dto);
                    }
                }
                populateUsers(filteredUser);
            }
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
        for(UserDTO dto : allUsers) {
            if(dto.isStarred()) {
                starredColaps.add(new CustomerCollapsible(dto, this));
            }
        }
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
        Collections.sort(sortedUsers, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        populateUsers(sortedUsers);
    }

    @UiHandler("sortPosition")
    void onSortPosition(ClickEvent e) {
        List<UserDTO> sortedUsers = DataHelper.getAllUsers();
        Collections.sort(sortedUsers, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getPosition().getValue().compareToIgnoreCase(o2.getPosition().getValue());
            }
        });
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
