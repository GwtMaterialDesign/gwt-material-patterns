package com.github.gwtmaterialdesign.client.application.googledrive.collapsible;

import com.github.gwtmaterialdesign.client.application.googledrive.GoogleDriveView;
import com.github.gwtmaterialdesign.client.dto.DriveDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;

public class DriveCollapsible extends Composite {

    private static CustomerCollapsibleUiBinder uiBinder = GWT.create(CustomerCollapsibleUiBinder.class);
    private final GoogleDriveView googleDriveView;
    private final DriveDTO dto;

    interface CustomerCollapsibleUiBinder extends UiBinder<Widget, DriveCollapsible> {
    }

    @UiField
    MaterialIcon icon;

    @UiField
    MaterialLabel lblFileName, lblOwner, lblDate;

    @UiField
    MaterialImage imgOwner;


    public DriveCollapsible(GoogleDriveView googleDriveView, DriveDTO dto) {
        initWidget(uiBinder.createAndBindUi(this));
        this.googleDriveView = googleDriveView;
        this.dto = dto;
        icon.setIconType(dto.getIcon());
        lblFileName.setText(dto.getFileName());
        lblOwner.setText(dto.getOwner());
        lblDate.setText(dto.getDate());
        imgOwner.setUrl(dto.getOwnerImage());
    }
    
    @UiHandler("colapsItem")
    void onPreview(ClickEvent e) {  
        googleDriveView.setViewInfo(dto);
    }
}
