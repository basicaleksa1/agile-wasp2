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
package it.agilelab.bigdata.nifi.client.model

import it.agilelab.bigdata.nifi.client.core.ApiModel

case class UpdateControllerServiceReferenceRequestEntity(
  /* The identifier of the Controller Service. */
  id: Option[String] = None,
  /* The new state of the references for the controller service. */
  state: Option[UpdateControllerServiceReferenceRequestEntityEnums.State] = None,
  /* The revisions for all referencing components. */
  referencingComponentRevisions: Option[Map[String, RevisionDTO]] = None,
  /* Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  disconnectedNodeAcknowledged: Option[Boolean] = None
) extends ApiModel

object UpdateControllerServiceReferenceRequestEntityEnums {

  type State = State.Value
  object State extends Enumeration {
    val ENABLED = Value("ENABLED")
    val DISABLED = Value("DISABLED")
    val RUNNING = Value("RUNNING")
    val STOPPED = Value("STOPPED")
  }

}

