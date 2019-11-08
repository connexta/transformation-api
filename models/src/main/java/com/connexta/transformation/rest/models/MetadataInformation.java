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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** MetadataInformation */
@JsonInclude(Include.NON_NULL)
public class MetadataInformation {
  @JsonProperty("metadataType")
  private String metadataType;

  @JsonProperty("transformationStatus")
  private Status transformationStatus;

  @JsonProperty("failureReason")
  private String failureReason;

  @JsonProperty("failureMessage")
  private String failureMessage;

  @JsonProperty("location")
  private URL location;

  @JsonProperty("transformedTimestamp")
  private OffsetDateTime transformedTimestamp;

  public MetadataInformation metadataType(String metadataType) {
    this.metadataType = metadataType;
    return this;
  }

  /**
   * The type of metadata.
   *
   * @return metadataType
   */
  @ApiModelProperty(example = "irm", required = true, value = "The type of metadata.")
  @NotNull
  @Size(min = 1, max = 80)
  public String getMetadataType() {
    return metadataType;
  }

  public void setMetadataType(String metadataType) {
    this.metadataType = metadataType;
  }

  public MetadataInformation transformationStatus(Status transformationStatus) {
    this.transformationStatus = transformationStatus;
    return this;
  }

  /**
   * Get transformationStatus
   *
   * @return transformationStatus
   */
  @ApiModelProperty(required = true, value = "")
  @NotNull
  @Valid
  public Status getTransformationStatus() {
    return transformationStatus;
  }

  public void setTransformationStatus(Status transformationStatus) {
    this.transformationStatus = transformationStatus;
  }

  public MetadataInformation failureReason(String failureReason) {
    this.failureReason = failureReason;
    return this;
  }

  /**
   * A short reason why this metadata transformation failed, in the case it did fail.
   *
   * @return failureReason
   */
  @ApiModelProperty(
      example = "Transformation Error",
      value = "A short reason why this metadata transformation failed, in the case it did fail.")
  public String getFailureReason() {
    return failureReason;
  }

  public void setFailureReason(String failureReason) {
    this.failureReason = failureReason;
  }

  public MetadataInformation failureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
    return this;
  }

  /**
   * A detailed message describing what error occured, in the event this metadata transformation
   * failed.
   *
   * @return failureMessage
   */
  @ApiModelProperty(
      example = "A transformation flow for metadataType 'irm' could not be found.",
      value =
          "A detailed message describing what error occured, in the event this metadata transformation failed.")
  public String getFailureMessage() {
    return failureMessage;
  }

  public void setFailureMessage(String failureMessage) {
    this.failureMessage = failureMessage;
  }

  public MetadataInformation location(URL location) {
    this.location = location;
    return this;
  }

  /**
   * The URL for where the metadata is located. NOTE this will not be populated until the
   * transformationStatus is Complete.
   *
   * @return location
   */
  @ApiModelProperty(
      example = "https://www.example.com/mis/30f14c6c1fc85cba12bfd093aa8f90e3",
      value =
          "The URL for where the metadata is located. NOTE this will not be populated until the transformationStatus is Complete.")
  public URL getLocation() {
    return location;
  }

  public void setLocation(URL location) {
    this.location = location;
  }

  public MetadataInformation transformedTimestamp(OffsetDateTime transformedTimestamp) {
    this.transformedTimestamp = transformedTimestamp;
    return this;
  }

  /**
   * The server time when the metadata was generated. NOTE this will not be populated until the
   * transformationStatus is Complete.
   *
   * @return transformedTimestamp
   */
  @ApiModelProperty(
      value =
          "The server time when the metadata was generated. NOTE this will not be populated until the transformationStatus is Complete.")
  @Valid
  public OffsetDateTime getTransformedTimestamp() {
    return transformedTimestamp;
  }

  public void setTransformedTimestamp(OffsetDateTime transformedTimestamp) {
    this.transformedTimestamp = transformedTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataInformation metadataInformation = (MetadataInformation) o;
    return Objects.equals(this.metadataType, metadataInformation.metadataType)
        && Objects.equals(this.transformationStatus, metadataInformation.transformationStatus)
        && Objects.equals(this.failureReason, metadataInformation.failureReason)
        && Objects.equals(this.failureMessage, metadataInformation.failureMessage)
        && Objects.equals(this.location, metadataInformation.location)
        && Objects.equals(this.transformedTimestamp, metadataInformation.transformedTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        metadataType,
        transformationStatus,
        failureReason,
        failureMessage,
        location,
        transformedTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataInformation {\n");

    sb.append("    metadataType: ").append(toIndentedString(metadataType)).append("\n");
    sb.append("    transformationStatus: ")
        .append(toIndentedString(transformationStatus))
        .append("\n");
    sb.append("    failureReason: ").append(toIndentedString(failureReason)).append("\n");
    sb.append("    failureMessage: ").append(toIndentedString(failureMessage)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    transformedTimestamp: ")
        .append(toIndentedString(transformedTimestamp))
        .append("\n");
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
