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
package com.connexta.transformation.rest.spring;

import com.connexta.transformation.rest.models.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Implementations of the {@code TransformApiRetrieve} interface provide a mechanism to implement
 * the rest GET/retrieve endpoint.
 */
@Validated
@Api(value = "transform", description = "the transform API")
public interface TransformApiRetrieve {

  @ApiOperation(
      value = "Retrieve metadata.",
      nickname = "retrieve",
      notes = "Used to retrieve the metadata for a transform request.",
      response = Resource.class,
      tags = {
        "transform",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message = "Successfully retrieved.",
            response = Resource.class,
            responseHeaders = {
              @ResponseHeader(
                  name = "Last-Modified",
                  description =
                      "The time at which this piece of metadata finished being generated.",
                  response = OffsetDateTime.class),
              @ResponseHeader(
                  name = "Content-Type",
                  description =
                      "An optional header indicating the content type of the response body contents.",
                  response = String.class),
              @ResponseHeader(
                  name = "Content-Length",
                  description =
                      "An optional header indicating the length, in bytes, of the response body contents.",
                  response = Long.class)
            }),
        @ApiResponse(
            code = 400,
            message =
                "The client message could not be understood by the server due to invalid format or syntax.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 401,
            message = "The client could not be authenticated.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 403,
            message = "The client is not authorized.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 404,
            message = "The transform request could not be found.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 501,
            message =
                "The requested API version is not supported and therefore not implemented. Possible codes reported are: - 501001 - Unable to parse *Accept-Version* - 501002 - The provided major version is no longer supported - 501003 - The provided major version is not yet supported by the server - 501004 - The provided minor version is not yet supported by the server ",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 503,
            message = "The service is unavailable. Try again later.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 500,
            message = "Any other possible errors not currently known.",
            response = ErrorResponse.class)
      })
  @RequestMapping(
      value = "/transform/{TransformId}/{MetadataType}",
      produces = {"application/json", "*/*"},
      method = RequestMethod.GET)
  @ResponseHeader(
      name = "Content-Version",
      description =
          "The API version used by the server to produce the REST message. The server will accept messages for any minor versions prior to this one.",
      response = String.class)
  default ResponseEntity<Resource> retrieve(
      @ApiParam(
              value =
                  "The API version used by the client to produce the REST message. The client must accept responses marked with any minor versions after this one. This implies that all future minor versions of the message are backward compatible with all previous minor versions of the same message. ",
              required = true)
          @RequestHeader(value = "Accept-Version", required = true)
          @NotNull
          @Pattern(regexp = "^\\d+.\\d+.\\d+(-SNAPSHOT)?$")
          String acceptVersion,
      @ApiParam(value = "The ID of the transform request. ", required = true)
          @PathVariable("TransformId")
          @Size(min = 1, max = 80)
          String transformId,
      @ApiParam(value = "The metadata format ID.", required = true)
          @PathVariable("MetadataType")
          @Size(min = 1, max = 80)
          String metadataType)
      throws Exception {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
