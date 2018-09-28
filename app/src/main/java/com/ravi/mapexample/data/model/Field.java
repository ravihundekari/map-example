
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
    "geometry",
    "type",
    "properties"
})
public class Field {

    @JsonProperty("geometry")
    private Geometry_ geometry;
    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private Properties_ properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("geometry")
    public Geometry_ getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry_ geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("properties")
    public Properties_ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties_ properties) {
        this.properties = properties;
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
        return "Field{" +
                "geometry=" + geometry +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
