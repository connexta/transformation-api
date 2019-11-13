/**
 * Copyright (c) Connexta
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.connexta.transformation.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;
import javax.validation.constraints.NotNull;

/** TransformRequest */
public class TransformRequest {
  @JsonProperty("datasetId")
  private UUID datasetId;

  @JsonProperty("currentLocation")
  private URL currentLocation;

  @JsonProperty("finalLocation")
  private URL finalLocation;

  @JsonProperty("metacardLocation")
  private URL metacardLocation;

  public TransformRequest datasetId(UUID datasetId) {
    this.datasetId = datasetId;
    return this;
  }

  /**
   * A standard 36-character uuid identifying the dataset being transformed. It will be used by the
   * Transformation service to put in the transformed metadata.
   *
   * @return the dataset id
   */
  @ApiModelProperty(
      example = "e86b3f57-c282-4cad-aa93-d58ea1709b9c",
      required = true,
      value =
          "A standard 36-character uuid identifying the dataset being transformed. It will be used by the Transformation service to put in the transformed metadata.")
  @NotNull
  public UUID getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(UUID datasetId) {
    this.datasetId = datasetId;
  }

  public TransformRequest currentLocation(URL currentLocation) {
    this.currentLocation = currentLocation;
    return this;
  }

  /**
   * This URL must support HTTP GET to retrieve the file. This MUST be available until the
   * transformation request is \"Done\".
   *
   * @return currentLocation
   */
  @ApiModelProperty(
      example = "https://www.example.com/mis/30f14c6c1fc85cba12bfd093aa8f90e3",
      required = true,
      value =
          "This URL must support HTTP GET to retrieve the file. This MUST be available until the transformation request is \"Done\". ")
  @NotNull
  public URL getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(URL currentLocation) {
    this.currentLocation = currentLocation;
  }

  public TransformRequest finalLocation(URL finalLocation) {
    this.finalLocation = finalLocation;
    return this;
  }

  /**
   * This URL will not actually be called by the Transform service. It will only be used by the
   * Transform service to put in the transformed metadata for the \"resource download location\".
   *
   * @return finalLocation
   */
  @ApiModelProperty(
      example = "https://www.example.com/mis/30f14c6c1fc85cba12bfd093aa8f90e3",
      required = true,
      value =
          "This URL will not actually be called by the Transform service. It will only be used by the Transform service to put in the transformed metadata for the \"resource download location\". ")
  @NotNull
  public URL getFinalLocation() {
    return finalLocation;
  }

  public void setFinalLocation(URL finalLocation) {
    this.finalLocation = finalLocation;
  }

  public TransformRequest metacardLocation(URL metacardLocation) {
    this.metacardLocation = metacardLocation;
    return this;
  }

  /**
   * This URL must support HTTP GET to retrieve the metacard xml.
   *
   * @return metacardLocation
   */
  @ApiModelProperty(
      example = "https://www.example.com/mis/30f14c6c1fc85cba12bfd093aa8f90e3",
      required = true,
      value = "This URL must support HTTP GET to retrieve the metacard xml. ")
  @NotNull
  public URL getMetacardLocation() {
    return metacardLocation;
  }

  public void setMetacardLocation(URL metacardLocation) {
    this.metacardLocation = metacardLocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformRequest transformRequest = (TransformRequest) o;
    return Objects.equals(this.currentLocation, transformRequest.currentLocation)
        && Objects.equals(this.finalLocation, transformRequest.finalLocation)
        && Objects.equals(this.metacardLocation, transformRequest.metacardLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentLocation, finalLocation, metacardLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformRequest {\n");

    sb.append("    currentLocation: ").append(toIndentedString(currentLocation)).append("\n");
    sb.append("    finalLocation: ").append(toIndentedString(finalLocation)).append("\n");
    sb.append("    metacardLocation: ").append(toIndentedString(metacardLocation)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
