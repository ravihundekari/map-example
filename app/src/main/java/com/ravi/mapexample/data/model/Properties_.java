
package com.ravi.mapexample.data.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "permission",
    "soil_type",
    "field_id",
    "farm_slug",
    "team_id",
    "ownership",
    "team_name",
    "location_slug",
    "field_area",
    "farm_name",
    "field_name",
    "notes",
    "field_longitude",
    "field_slug",
    "workable_area",
    "field_latitude"
})
public class Properties_ {

    @JsonProperty("permission")
    private Boolean permission;
    @JsonProperty("soil_type")
    private String soilType;
    @JsonProperty("field_id")
    private Integer fieldId;
    @JsonProperty("farm_slug")
    private String farmSlug;
    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("ownership")
    private Boolean ownership;
    @JsonProperty("team_name")
    private String teamName;
    @JsonProperty("location_slug")
    private String locationSlug;
    @JsonProperty("field_area")
    private Double fieldArea;
    @JsonProperty("farm_name")
    private String farmName;
    @JsonProperty("field_name")
    private String fieldName;
    @JsonProperty("notes")
    private Object notes;
    @JsonProperty("field_longitude")
    private Double fieldLongitude;
    @JsonProperty("field_slug")
    private String fieldSlug;
    @JsonProperty("workable_area")
    private Double workableArea;
    @JsonProperty("field_latitude")
    private Double fieldLatitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("permission")
    public Boolean getPermission() {
        return permission;
    }

    @JsonProperty("permission")
    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    @JsonProperty("soil_type")
    public String getSoilType() {
        return soilType;
    }

    @JsonProperty("soil_type")
    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    @JsonProperty("field_id")
    public Integer getFieldId() {
        return fieldId;
    }

    @JsonProperty("field_id")
    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    @JsonProperty("farm_slug")
    public String getFarmSlug() {
        return farmSlug;
    }

    @JsonProperty("farm_slug")
    public void setFarmSlug(String farmSlug) {
        this.farmSlug = farmSlug;
    }

    @JsonProperty("team_id")
    public Integer getTeamId() {
        return teamId;
    }

    @JsonProperty("team_id")
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("ownership")
    public Boolean getOwnership() {
        return ownership;
    }

    @JsonProperty("ownership")
    public void setOwnership(Boolean ownership) {
        this.ownership = ownership;
    }

    @JsonProperty("team_name")
    public String getTeamName() {
        return teamName;
    }

    @JsonProperty("team_name")
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @JsonProperty("location_slug")
    public String getLocationSlug() {
        return locationSlug;
    }

    @JsonProperty("location_slug")
    public void setLocationSlug(String locationSlug) {
        this.locationSlug = locationSlug;
    }

    @JsonProperty("field_area")
    public Double getFieldArea() {
        return fieldArea;
    }

    @JsonProperty("field_area")
    public void setFieldArea(Double fieldArea) {
        this.fieldArea = fieldArea;
    }

    @JsonProperty("farm_name")
    public String getFarmName() {
        return farmName;
    }

    @JsonProperty("farm_name")
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @JsonProperty("field_name")
    public String getFieldName() {
        return fieldName;
    }

    @JsonProperty("field_name")
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @JsonProperty("notes")
    public Object getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(Object notes) {
        this.notes = notes;
    }

    @JsonProperty("field_longitude")
    public Double getFieldLongitude() {
        return fieldLongitude;
    }

    @JsonProperty("field_longitude")
    public void setFieldLongitude(Double fieldLongitude) {
        this.fieldLongitude = fieldLongitude;
    }

    @JsonProperty("field_slug")
    public String getFieldSlug() {
        return fieldSlug;
    }

    @JsonProperty("field_slug")
    public void setFieldSlug(String fieldSlug) {
        this.fieldSlug = fieldSlug;
    }

    @JsonProperty("workable_area")
    public Double getWorkableArea() {
        return workableArea;
    }

    @JsonProperty("workable_area")
    public void setWorkableArea(Double workableArea) {
        this.workableArea = workableArea;
    }

    @JsonProperty("field_latitude")
    public Double getFieldLatitude() {
        return fieldLatitude;
    }

    @JsonProperty("field_latitude")
    public void setFieldLatitude(Double fieldLatitude) {
        this.fieldLatitude = fieldLatitude;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Properties_{" +
                "permission=" + permission +
                ", soilType='" + soilType + '\'' +
                ", fieldId=" + fieldId +
                ", farmSlug='" + farmSlug + '\'' +
                ", teamId=" + teamId +
                ", ownership=" + ownership +
                ", teamName='" + teamName + '\'' +
                ", locationSlug='" + locationSlug + '\'' +
                ", fieldArea=" + fieldArea +
                ", farmName='" + farmName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", notes=" + notes +
                ", fieldLongitude=" + fieldLongitude +
                ", fieldSlug='" + fieldSlug + '\'' +
                ", workableArea=" + workableArea +
                ", fieldLatitude=" + fieldLatitude +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
