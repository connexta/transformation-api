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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Error message. */
@ApiModel(description = "Error message.")
public class ErrorMessage {
  @JsonProperty("message")
  private String message;

  @JsonProperty("details")
  @Valid
  private List<String> details = null;

  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Specific information about the error.
   *
   * @return message
   */
  @ApiModelProperty(
      example = "Validation failed for object='systemInfo'.",
      required = true,
      value = "Specific information about the error.")
  @NotNull
  @Size(min = 1)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorMessage details(List<String> details) {
    this.details = details;
    return this;
  }

  public ErrorMessage addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Optional detailed information about the error.
   *
   * @return details
   */
  @ApiModelProperty(value = "Optional detailed information about the error.")
  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.message, errorMessage.message)
        && Objects.equals(this.details, errorMessage.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");

    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
