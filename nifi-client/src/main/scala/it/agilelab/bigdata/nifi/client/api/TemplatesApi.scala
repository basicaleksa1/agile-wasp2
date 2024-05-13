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
import it.agilelab.bigdata.nifi.client.model.TemplateEntity
import sttp.client._
import sttp.model.Method

object TemplatesApi {

  def apply(baseUrl: String = "http://localhost/nifi-api")(implicit serializer: SttpSerializer) = new TemplatesApi(baseUrl)
}

class TemplatesApi(baseUrl: String)(implicit serializer: SttpSerializer) {

  
  import serializer._

  /**
   * Expected answers:
   *   code 200 : String (successful operation)
   *   code 400 :  (NiFi was unable to complete the request because it was invalid. The request should not be retried without modification.)
   *   code 401 :  (Client could not be authenticated.)
   *   code 403 :  (Client is not authorized to make this request.)
   *   code 404 :  (The specified resource could not be found.)
   *   code 409 :  (The request was valid but NiFi was not in the appropriate state to process it. Retrying the same request later may be successful.)
   * 
   * @param id The template id.
   */
  def exportTemplate(id: String): ApiRequestT[String] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/templates/${id}/download")
      .contentType("application/json")
      .response(asJson[String])

  /**
   * Expected answers:
   *   code 200 : TemplateEntity (successful operation)
   *   code 400 :  (NiFi was unable to complete the request because it was invalid. The request should not be retried without modification.)
   *   code 401 :  (Client could not be authenticated.)
   *   code 403 :  (Client is not authorized to make this request.)
   *   code 404 :  (The specified resource could not be found.)
   *   code 409 :  (The request was valid but NiFi was not in the appropriate state to process it. Retrying the same request later may be successful.)
   * 
   * @param id The template id.
   * @param disconnectedNodeAcknowledged Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  def removeTemplate(id: String, disconnectedNodeAcknowledged: Option[Boolean] = None): ApiRequestT[TemplateEntity] =
    basicRequest
      .method(Method.DELETE, uri"$baseUrl/templates/${id}?disconnectedNodeAcknowledged=$disconnectedNodeAcknowledged")
      .contentType("application/json")
      .response(asJson[TemplateEntity])

}
