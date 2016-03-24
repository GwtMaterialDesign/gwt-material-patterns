package com.github.gwtmaterialdesign.client.application.googleinbox.collapsible;

import com.github.gwtmaterialdesign.client.application.googledrive.GoogleDriveView;
import com.github.gwtmaterialdesign.client.dto.DriveDTO;
import com.github.gwtmaterialdesign.client.dto.InboxDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.*;

public class InboxCollapsible extends Composite {

    private static CustomerCollapsibleUiBinder uiBinder = GWT.create(CustomerCollapsibleUiBinder.class);

    interface CustomerCollapsibleUiBinder extends UiBinder<Widget, InboxCollapsible> {
    }

    @UiField
    MaterialLink lblCategory;

    @UiField
    MaterialLabel lblDescription;

    @UiField
    MaterialCollapsibleBody colapsBody;

    @UiField
    MaterialColumn imgCol;

    @UiField
    MaterialImage imgCategory;

    public InboxCollapsible(InboxDTO dto) {
        initWidget(uiBinder.createAndBindUi(this));
        lblCategory.setText(dto.getCategory());
        lblCategory.setTextColor(dto.getColor());
        if(dto.getIconType() != null) {
            lblCategory.setIconType(dto.getIconType());
            imgCol.removeFromParent();
        }
        if(dto.getImageUrl() != null) {
            imgCategory.setUrl(dto.getImageUrl());
        }
        lblDescription.setText(dto.getDescription());

        if(dto.getChildren().size() > 0) {
            MaterialCollapsible colapsChildren = new MaterialCollapsible();
            for(InboxDTO child : dto.getChildren()) {
                colapsChildren.add(new InboxCollapsible(child));
                colapsBody.add(colapsChildren);
            }
        }else {
            colapsBody.removeFromParent();
        }
    }
}
