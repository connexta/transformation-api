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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/** TransformationPollResponse */
@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class TransformationPollResponse {
  @JsonProperty("transformationStatus")
  private Status transformationStatus;

  @JsonProperty("metadataInformations")
  @Valid
  private List<MetadataInformation> metadataInformations = new ArrayList<>();

  public TransformationPollResponse transformationStatus(Status transformationStatus) {
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

  public TransformationPollResponse metadataInformations(
      List<MetadataInformation> metadataInformations) {
    this.metadataInformations = metadataInformations;
    return this;
  }

  public TransformationPollResponse addMetadataInformationsItem(
      MetadataInformation metadataInformationsItem) {
    this.metadataInformations.add(metadataInformationsItem);
    return this;
  }

  /**
   * An array of the information for each metadata type that will be provided from the
   * transformation request. NOTE this could be omitted if no metadata has been generated yet.
   *
   * @return metadataInformations
   */
  @ApiModelProperty(
      value =
          "An array of the information for each metadata type that will be provided from the transformation request. NOTE this could be omitted if no metadata has been generated yet. ")
  @Valid
  public List<MetadataInformation> getMetadataInformations() {
    return metadataInformations;
  }

  public void setMetadataInformations(List<MetadataInformation> metadataInformations) {
    this.metadataInformations = metadataInformations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformationPollResponse transformationPollResponse = (TransformationPollResponse) o;
    return Objects.equals(
            this.transformationStatus, transformationPollResponse.transformationStatus)
        && Objects.equals(
            this.metadataInformations, transformationPollResponse.metadataInformations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transformationStatus, metadataInformations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationPollResponse {\n");
    sb.append("    transformationStatus: ")
        .append(toIndentedString(transformationStatus))
        .append("\n");
    sb.append("    metadataInformations: ")
        .append(toIndentedString(metadataInformations))
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
