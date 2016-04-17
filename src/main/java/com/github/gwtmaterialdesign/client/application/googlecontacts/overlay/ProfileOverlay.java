package com.github.gwtmaterialdesign.client.application.googlecontacts.overlay;

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
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.overlay.MaterialOverlay;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.ui.*;

public class ProfileOverlay extends Composite {

    private static ProfileViewUiBinder uiBinder = GWT.create(ProfileViewUiBinder.class);

    interface ProfileViewUiBinder extends UiBinder<Widget, ProfileOverlay> {
    }

    private CustomerCollapsible customerCollapsible;

    @UiField
    MaterialIcon btnCloseProfile;

    @UiField
    MaterialPanel infoEditPanel, infoPanel;

    @UiField
    MaterialOverlay overlay;

    @UiField
    MaterialLabel lblName, lblPosition;

    @UiField
    MaterialLink lblCompany, lblEmail, lblWorkEmail, lblNumber, lblWorkNumber, lblAddress;

    @UiField
    MaterialImage imgProfile;

    public ProfileOverlay() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnCloseProfile")
    void onCloseProfiled(ClickEvent e){
        MaterialPathAnimator.reverseAnimate(getCustomerCollapsible().getColapsItem().getElement(), overlay.getElement());
    }

    /**
     * Get the profile overlay panel
     * @return
     */
    public MaterialOverlay getOverlay() {
        return overlay;
    }

    public CustomerCollapsible getCustomerCollapsible() {
        return customerCollapsible;
    }

    /**
     * Set the customer collapsible and provide the details inside the profile overlay
     * @param customerCollapsible
     */
    public void setCustomerCollapsible(CustomerCollapsible customerCollapsible) {
        this.customerCollapsible = customerCollapsible;
        UserDTO user = customerCollapsible.getDto();
        imgProfile.setUrl(user.getPicture());
        lblName.setText(user.getName());
        lblPosition.setText(user.getPosition().getValue());
        lblCompany.setText(user.getCompany());
        lblEmail.setText(user.getEmail());
        lblWorkEmail.setText(user.getEmail());
        lblNumber.setText(user.getContactNo());
        lblWorkNumber.setText(user.getContactNo());
        lblAddress.setText(user.getAddress());
    }
}
