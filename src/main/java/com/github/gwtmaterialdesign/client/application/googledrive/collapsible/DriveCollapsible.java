package com.github.gwtmaterialdesign.client.application.googledrive.collapsible;

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
