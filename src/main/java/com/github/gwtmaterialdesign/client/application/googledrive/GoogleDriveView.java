package com.github.gwtmaterialdesign.client.application.googledrive;

import com.github.gwtmaterialdesign.client.application.googlecontacts.collapsible.CustomerCollapsible;
import com.github.gwtmaterialdesign.client.application.googledrive.collapsible.DriveCollapsible;
import com.github.gwtmaterialdesign.client.dto.DataHelper;
import com.github.gwtmaterialdesign.client.dto.DriveDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;


public class GoogleDriveView extends ViewImpl implements GoogleDrivePresenter.MyView {
    private boolean toggle;

    interface Binder extends UiBinder<Widget, GoogleDriveView> {
    }

    @UiField
    MaterialNavBar appNav, searchNav;

    @UiField
    MaterialSearch search;

    @UiField
    MaterialCollapsible driveColaps;

    @UiField
    MaterialIcon iconViewFile;

    @UiField
    MaterialLabel lblViewFile;

    @UiField
    MaterialPanel rightPanel;

    @UiField
    MaterialRow mainPanel, mainHeader;

    @Inject
    GoogleDriveView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        search.addCloseHandler(new CloseHandler<String>() {
            @Override
            public void onClose(CloseEvent<String> event) {
                appNav.setVisible(true);
                searchNav.setVisible(false);
            }
        });
        populateDrive();
    }

    private void populateDrive() {
        for(DriveDTO dto : DataHelper.getAllDrives()){
            driveColaps.add(new DriveCollapsible(this, dto));
        }
        if(DataHelper.getAllDrives().size() > 0){
            setViewInfo(DataHelper.getAllDrives().get(0));
        }
    }

    public void setViewInfo(DriveDTO dto) {
        lblViewFile.setText(dto.getFileName());
        iconViewFile.setIconType(dto.getIcon());
    }

    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        appNav.setVisible(false);
        searchNav.setVisible(true);
    }

    @UiHandler("iconInfo")
    void onInfo(ClickEvent e) {
        if(toggle){
            // show the right nav
            mainHeader.setRight(334);
            mainPanel.setGrid("l9");
            rightPanel.setRight(-40);
            toggle = false;
        }else{
            hidePanel();
        }
    }

    @UiHandler("iconClose")
    void onClose(ClickEvent e) {
        hidePanel();
    }

    private void hidePanel() {
        // hide the right nav
        mainHeader.setRight(0);
        mainPanel.setGrid("l12");
        rightPanel.setRight(-374);
        toggle = true;
    }
}
