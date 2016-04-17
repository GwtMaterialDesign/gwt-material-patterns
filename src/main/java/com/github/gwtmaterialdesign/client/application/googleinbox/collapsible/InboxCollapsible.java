package com.github.gwtmaterialdesign.client.application.googleinbox.collapsible;

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
