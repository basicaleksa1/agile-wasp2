/**
 * NiFi Rest Api
 * The Rest Api provides programmatic access to command and control a NiFi instance in real time. Start and                                              stop processors, monitor queues, query provenance data, and more. Each endpoint below includes a description,                                             definitions of the expected input and output, potential response codes, and the authorizations required                                             to invoke each service.
 *
 * The version of the OpenAPI document: 1.11.4
 * Contact: dev@nifi.apache.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package it.agilelab.bigdata.nifi.client.api

import it.agilelab.bigdata.nifi.client.core.SttpSerializer
import it.agilelab.bigdata.nifi.client.core.alias._
import it.agilelab.bigdata.nifi.client.model.ResourcesEntity
import sttp.client._
import sttp.model.Method

object ResourcesApi {

  def apply(baseUrl: String = "http://localhost/nifi-api")(implicit serializer: SttpSerializer) = new ResourcesApi(baseUrl)
}

class ResourcesApi(baseUrl: String)(implicit serializer: SttpSerializer) {

  
  import serializer._

  /**
   * Expected answers:
   *   code 200 : ResourcesEntity (successful operation)
   *   code 401 :  (Client could not be authenticated.)
   *   code 403 :  (Client is not authorized to make this request.)
   */
  def getResources(): ApiRequestT[ResourcesEntity] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/resources")
      .contentType("application/json")
      .response(asJson[ResourcesEntity])

}

