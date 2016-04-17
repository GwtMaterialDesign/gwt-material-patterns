package com.github.gwtmaterialdesign.client.dto;

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


import gwt.material.design.client.constants.IconType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark Kevin on 1/7/2016.
 */
public class DataHelper {

    /**
     * Get all Users for GContacts Pattern
     * @return
     */
    public static List<UserDTO> getAllUsers() {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", UserDTO.Position.DEVELOPER, true, "Luis Hoppe", "luis@mail.com", "123123123", "718-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", UserDTO.Position.DEVELOPER, true, "Irwin Mueller", "irwin@mail.com", "123123123", "718-432-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", UserDTO.Position.DEVELOPER, true, "Levin Card", "levin@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/lmjabreu/128.jpg", UserDTO.Position.DEVELOPER, false, "Dr. Cassie Keeling", "cassie@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/ariil/128.jpg", UserDTO.Position.DEVELOPER, false, "Dr. Madelynn Schamberger", "madelyn@mail.com", "123123123", "543-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/devankoshal/128.jpg", UserDTO.Position.MARKETING, false, "Dominique Schmidt", "dom@mail.com", "123123123", "718-657-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/karthipanraj/128.jpg", UserDTO.Position.CTO, false, "Rowland Heller", "rowland@mail.com", "123123123", "718-765-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg", UserDTO.Position.CEO, false, "Quincy Schimmel", "quincy@mail.com", "123123123", "46-555-876", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/roybarberuk/128.jpg", UserDTO.Position.MARKETING, false, "Tierra VonRueden", "tierra@mail.com", "123123123", "654-56-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/kimcool/128.jpg", UserDTO.Position.MARKETING, false, "Travis Larson", "travis@mail.com", "123123123", "465-456-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new UserDTO("https://s3.amazonaws.com/uifaces/faces/twitter/tonymillion/128.jpg", UserDTO.Position.MARKETING, false, "Clint Heller", "clint@mail.com", "123123123", "645-555-65", "Makati City, Philippines", "Gwt Material"));
        return list;
    }

    /**
     * Get all drives for GDrive Pattern
     * @return
     */
    public static List<DriveDTO> getAllDrives() {
        List<DriveDTO> list = new ArrayList<>();
        list.add(new DriveDTO(IconType.FOLDER, "File 1", "https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", "Luis Hoppe", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER_SHARED, "File 2", "https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", "Irwin Mueller", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER, "File 3", "https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", "Levin Card", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER_SHARED, "File 4", "https://s3.amazonaws.com/uifaces/faces/twitter/lmjabreu/128.jpg", "Dr. Cassie Keeling", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER_SHARED, "File 5", "https://s3.amazonaws.com/uifaces/faces/twitter/ariil/128.jpg", "Madelynn Schamberger", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER, "File 6", "https://s3.amazonaws.com/uifaces/faces/twitter/devankoshal/128.jpg", "Dominique Schmidt", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER, "File 7", "https://s3.amazonaws.com/uifaces/faces/twitter/karthipanraj/128.jpg", "Rowland Heller", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER_SHARED, "File 8", "https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg", "Quincy Schimmel", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER_SHARED, "File 9", "https://s3.amazonaws.com/uifaces/faces/twitter/roybarberuk/128.jpg", "Tierra VonRueden", "March 3, 2016"));
        list.add(new DriveDTO(IconType.FOLDER, "File 10", "https://s3.amazonaws.com/uifaces/faces/twitter/tonymillion/128.jpg", "Clint Heller", "March 3, 2016"));
        return list;
    }

    /**
     * Get all inbox for GInbox Patter
     * @return
     */
    public static List<InboxDTO> getAllTodayInbox() {
        List<InboxDTO> list = new ArrayList<>();

        // Children
        List<InboxDTO> children = new ArrayList<>();
        children.add(new InboxDTO("https://lh5.googleusercontent.com/-SWaCREsCOUQ/AAAAAAAAAAI/AAAAAAAAAAA/0B6hSKehnxg/w28-h28/photo.jpg", "Paypal", "John Doe, how to receive important PayPal messages in your inbox", "black"));
        children.add(new InboxDTO("https://lh5.googleusercontent.com/-SWaCREsCOUQ/AAAAAAAAAAI/AAAAAAAAAAA/0B6hSKehnxg/w28-h28/photo.jpg", "Paypal", "John Doe, how to receive important PayPal messages in your inbox", "black"));
        children.add(new InboxDTO("https://lh5.googleusercontent.com/-SWaCREsCOUQ/AAAAAAAAAAI/AAAAAAAAAAA/0B6hSKehnxg/w28-h28/photo.jpg", "Paypal", "John Doe, how to receive important PayPal messages in your inbox", "black"));

        InboxDTO promos = new InboxDTO(IconType.LOCAL_OFFER, "Promos", "Paypal, LAZADA, CashCashPinoy, Dribble, Inbox by Inbox", "blue lighten-2");
        promos.setChildren(children);
        list.add(promos);

        InboxDTO updates = new InboxDTO(IconType.FLAG, "Updates", "Wattpad, Code Fights, Job Central, Gitter Notifications", "deep-orange");
        updates.setChildren(children);
        list.add(updates);

        InboxDTO finance = new InboxDTO(IconType.POLL, "Finance", "Globe Telecom, Paypal, China Bank", "green");
        finance.setChildren(children);
        list.add(finance);

        InboxDTO purchase = new InboxDTO(IconType.LOCAL_GROCERY_STORE, "Purchase", "Lazada, Starbucks, Sony", "brown");
        purchase.setChildren(children);
        list.add(purchase);

        return list;
    }

    /**
     * Get All yesterday inbox for GInbox Pattern
     * @return
     */
    public static List<InboxLinkDTO> getAllYesterdayInbox() {
        List<InboxLinkDTO> list = new ArrayList<>();
        list.add(new InboxLinkDTO("https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", "Brandon", "Welcome to Google Cardboard", "Experience the awesome virtual reality using cardboard and your phone", "https://i.ytimg.com/vi/eT9vmpE8WcY/maxresdefault.jpg", "Google Cardboard", "https://www.google.com/get/cardboard/"));
        list.add(new InboxLinkDTO("https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", "Irwin Mueller", "Welcome to Project Loon", "BALLOON-POWERED INTERNET FOR EVERYONE", "http://www.unionroom.com/wp-content/uploads/2014/11/google-loon.jpg", "Project Loon", "https://www.google.com/loon/"));
        list.add(new InboxLinkDTO("https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", "Luis Hoppe", "Welcome to Project Tango", "Project Tango combines 3D motion tracking with depth sensing to give your mobile device the ability to know where it is and how it moves through space.", "https://i.ytimg.com/vi/Qe10ExwzCqk/maxresdefault.jpg", "Project Tango", "https://www.google.com/atap/project-tango/"));
        return list;
    }

}
