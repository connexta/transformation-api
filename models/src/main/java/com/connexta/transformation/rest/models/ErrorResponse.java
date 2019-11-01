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
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** Error response. */
@ApiModel(description = "Error response.")
public class ErrorResponse {
  @JsonProperty("timestamp")
  private OffsetDateTime timestamp;

  @JsonProperty("path")
  private String path;

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("error")
  private String error;

  @JsonProperty("errorMessage")
  private ErrorMessage errorMessage = null;

  public ErrorResponse timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The server time when the error was generated.
   *
   * @return timestamp
   */
  @ApiModelProperty(required = true, value = "The server time when the error was generated.")
  @NotNull
  @Valid
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorResponse path(String path) {
    this.path = path;
    return this;
  }

  /**
   * The path for the REST endpoint that generated this error.
   *
   * @return path
   */
  @ApiModelProperty(
      example = "/transform",
      required = true,
      value = "The path for the REST endpoint that generated this error.")
  @NotNull
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ErrorResponse status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The corresponding HTTP status code. minimum: 100 maximum: 599
   *
   * @return status
   */
  @ApiModelProperty(example = "400", required = true, value = "The corresponding HTTP status code.")
  @NotNull
  @Min(100)
  @Max(599)
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorResponse code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * An optional and more specific code corresponding to the error (specific codes need to be
   * documented as part of the API operation). This code allows a given category of errors (e.g.
   * 501: Not Implemented) to be more specific as to why.
   *
   * @return code
   */
  @ApiModelProperty(
      value =
          "An optional and more specific code corresponding to the error (specific codes need to be documented as part of the API operation). This code allows a given category of errors (e.g. 501: Not Implemented) to be more specific as to why. ")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorResponse error(String error) {
    this.error = error;
    return this;
  }

  /**
   * The corresponding HTTP reason phrase.
   *
   * @return error
   */
  @ApiModelProperty(
      example = "Bad Request",
      required = true,
      value = "The corresponding HTTP reason phrase.")
  @NotNull
  @Size(min = 1)
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public ErrorResponse errorMessage(ErrorMessage errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   *
   * @return errorMessage
   */
  @ApiModelProperty(value = "")
  @Valid
  public ErrorMessage getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(ErrorMessage errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.timestamp, errorResponse.timestamp)
        && Objects.equals(this.path, errorResponse.path)
        && Objects.equals(this.status, errorResponse.status)
        && Objects.equals(this.code, errorResponse.code)
        && Objects.equals(this.error, errorResponse.error)
        && Objects.equals(this.errorMessage, errorResponse.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, path, status, code, error, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");

    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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
