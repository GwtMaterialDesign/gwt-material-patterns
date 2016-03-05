package com.github.gwtmaterialdesign.client.application.googlecontacts.overlay;

import com.github.gwtmaterialdesign.client.application.googlecontacts.collapsible.CustomerCollapsible;
import com.github.gwtmaterialdesign.client.dto.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.addins.client.ui.MaterialOverlay;
import gwt.material.design.addins.client.ui.MaterialPathAnimator;
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
