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


import com.github.gwtmaterialdesign.client.application.googlecontacts.GoogleContactsView;
import com.github.gwtmaterialdesign.client.dto.InboxLinkDTO;
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;

public class InboxLinkCollapsible extends Composite {

    private static CustomerCollapsibleUiBinder uiBinder = GWT.create(CustomerCollapsibleUiBinder.class);

    interface CustomerCollapsibleUiBinder extends UiBinder<Widget, InboxLinkCollapsible> {
    }

    @UiField
    MaterialImage imgUser, imgLink;

    @UiField
    MaterialLabel lblTitle, lblDescription, lblLinkTitle;

    @UiField
    MaterialLink lblName, link;

    public InboxLinkCollapsible(InboxLinkDTO dto) {
        initWidget(uiBinder.createAndBindUi(this));
        imgUser.setUrl(dto.getImgUser());
        imgLink.setUrl(dto.getLinkImage());

        lblTitle.setText(dto.getTitle());
        lblDescription.setText(dto.getDescription());
        lblLinkTitle.setText(dto.getLinkTitle());

        lblName.setText(dto.getName());
        link.setHref(dto.getLink());
    }

}
