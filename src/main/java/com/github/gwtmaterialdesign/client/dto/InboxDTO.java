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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InboxDTO implements Serializable {

    private String imageUrl;
    private IconType iconType;
    private String category;
    private String description;
    private String color;
    private List<InboxDTO> children = new ArrayList<>();

    public InboxDTO(){}

    public InboxDTO(IconType iconType, String category, String description, String color) {
        this.iconType = iconType;
        this.category = category;
        this.description = description;
        this.color = color;
    }

    public InboxDTO(String imageUrl, String category, String description, String color) {
        this.imageUrl = imageUrl;
        this.category = category;
        this.description = description;
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public IconType getIconType() {
        return iconType;
    }

    public void setIconType(IconType iconType) {
        this.iconType = iconType;
    }

    public List<InboxDTO> getChildren() {
        return children;
    }

    public void setChildren(List<InboxDTO> children) {
        this.children = children;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
