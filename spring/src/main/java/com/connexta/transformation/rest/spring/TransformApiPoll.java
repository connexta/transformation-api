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
import com.connexta.transformation.rest.models.TransformationPollResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.util.Optional;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Implementations of the {@code TransformApiPoll} interface provide a mechanism to implement the
 * rest GET/poll endpoint.
 */
@Validated
@Api(value = "transform", description = "the transform API")
public interface TransformApiPoll {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  @ApiOperation(
      value = "Poll transformation request status",
      nickname = "poll",
      notes =
          "After posting a transformation request, the client can use the returned URI to poll for the transform's completion at this endpoint. ",
      response = TransformationPollResponse.class,
      tags = {
        "transform",
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            code = 200,
            message =
                "Information on each of the metadata types that came out of the transformation.",
            response = TransformationPollResponse.class),
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
                "The requested API version is not supported and therefore not implemented. Possible codes reported are:"
                    + "- 501001 - Unable to parse *Accept-Version*"
                    + "- 501002 - The provided major version is no longer supported"
                    + "- 501003 - The provided major version is not yet supported by the server"
                    + "- 501004 - The provided minor version is not yet supported by the server",
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
      value = "/transform/{TransformId}",
      produces = {"application/json"},
      method = RequestMethod.GET)
  @ResponseHeader(
      name = "Content-Version",
      description =
          "The API version used by the server to produce the REST message. The server will accept messages for any minor versions prior to this one.",
      response = String.class)
  default ResponseEntity<TransformationPollResponse> poll(
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
          UUID transformId)
      throws Exception {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
