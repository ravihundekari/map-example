
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
    "farm_latitude",
    "permission",
    "farm_longitude",
    "farm_name",
    "farm_slug",
    "team_id",
    "farm_location",
    "ownership",
    "location_slug"
})
public class Properties {

    @JsonProperty("farm_latitude")
    private Double farmLatitude;
    @JsonProperty("permission")
    private Boolean permission;
    @JsonProperty("farm_longitude")
    private Double farmLongitude;
    @JsonProperty("farm_name")
    private String farmName;
    @JsonProperty("farm_slug")
    private String farmSlug;
    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty("farm_location")
    private String farmLocation;
    @JsonProperty("ownership")
    private Boolean ownership;
    @JsonProperty("location_slug")
    private String locationSlug;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("farm_latitude")
    public Double getFarmLatitude() {
        return farmLatitude;
    }

    @JsonProperty("farm_latitude")
    public void setFarmLatitude(Double farmLatitude) {
        this.farmLatitude = farmLatitude;
    }

    @JsonProperty("permission")
    public Boolean getPermission() {
        return permission;
    }

    @JsonProperty("permission")
    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    @JsonProperty("farm_longitude")
    public Double getFarmLongitude() {
        return farmLongitude;
    }

    @JsonProperty("farm_longitude")
    public void setFarmLongitude(Double farmLongitude) {
        this.farmLongitude = farmLongitude;
    }

    @JsonProperty("farm_name")
    public String getFarmName() {
        return farmName;
    }

    @JsonProperty("farm_name")
    public void setFarmName(String farmName) {
        this.farmName = farmName;
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

    @JsonProperty("farm_location")
    public String getFarmLocation() {
        return farmLocation;
    }

    @JsonProperty("farm_location")
    public void setFarmLocation(String farmLocation) {
        this.farmLocation = farmLocation;
    }

    @JsonProperty("ownership")
    public Boolean getOwnership() {
        return ownership;
    }

    @JsonProperty("ownership")
    public void setOwnership(Boolean ownership) {
        this.ownership = ownership;
    }

    @JsonProperty("location_slug")
    public String getLocationSlug() {
        return locationSlug;
    }

    @JsonProperty("location_slug")
    public void setLocationSlug(String locationSlug) {
        this.locationSlug = locationSlug;
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
        return "Properties{" +
                "farmLatitude=" + farmLatitude +
                ", permission=" + permission +
                ", farmLongitude=" + farmLongitude +
                ", farmName='" + farmName + '\'' +
                ", farmSlug='" + farmSlug + '\'' +
                ", teamId=" + teamId +
                ", farmLocation='" + farmLocation + '\'' +
                ", ownership=" + ownership +
                ", locationSlug='" + locationSlug + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
