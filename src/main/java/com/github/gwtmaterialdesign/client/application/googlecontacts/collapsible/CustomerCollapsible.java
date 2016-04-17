package com.github.gwtmaterialdesign.client.application.googlecontacts.collapsible;

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


import com.github.gwtmaterialdesign.client.application.googlecontacts.GoogleContactsView;
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialCollapsibleItem;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;

public class CustomerCollapsible extends Composite {

    private static CustomerCollapsibleUiBinder uiBinder = GWT.create(CustomerCollapsibleUiBinder.class);
    private final UserDTO dto;
    private final GoogleContactsView googleContactsView;

    interface CustomerCollapsibleUiBinder extends UiBinder<Widget, CustomerCollapsible> {
    }

    @UiField
    MaterialLabel lblName, lblEmail, lblPosition;

    @UiField
    MaterialImage imgUser;

    @UiField
    MaterialIcon iconStar;

    @UiField
    MaterialCollapsibleItem colapsItem;

    public CustomerCollapsible(UserDTO dto, GoogleContactsView googleContactsView) {
        initWidget(uiBinder.createAndBindUi(this));
        this.dto = dto;
        this.googleContactsView = googleContactsView;
        lblName.setText(dto.getName());
        lblEmail.setText(dto.getEmail());
        lblPosition.setText(dto.getPosition().getValue());
        imgUser.setUrl(dto.getPicture());
        if(dto.isStarred()){
            iconStar.setIconType(IconType.STAR);
        }
    }

    public UserDTO getDto() {
        return dto;
    }

    @UiHandler("colapsItem")
    void onColapsItem(ClickEvent e){
        googleContactsView.openProfileOverlay(this);
    }

    public MaterialCollapsibleItem getColapsItem() {
        return colapsItem;
    }
}
