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

case class ProvenanceNodeDTO(
  /* The id of the node. */
  id: Option[String] = None,
  /* The uuid of the flowfile associated with the provenance event. */
  flowFileUuid: Option[String] = None,
  /* The uuid of the parent flowfiles of the provenance event. */
  parentUuids: Option[Seq[String]] = None,
  /* The uuid of the childrent flowfiles of the provenance event. */
  childUuids: Option[Seq[String]] = None,
  /* The identifier of the node that this event/flowfile originated from. */
  clusterNodeIdentifier: Option[String] = None,
  /* The type of the node. */
  `type`: Option[ProvenanceNodeDTOEnums.`Type`] = None,
  /* If the type is EVENT, this is the type of event. */
  eventType: Option[String] = None,
  /* The timestamp of the node in milliseconds. */
  millis: Option[Long] = None,
  /* The timestamp of the node formatted. */
  timestamp: Option[String] = None
) extends ApiModel

object ProvenanceNodeDTOEnums {

  type `Type` = `Type`.Value
  object `Type` extends Enumeration {
    val FLOWFILE = Value("FLOWFILE")
    val EVENT = Value("EVENT")
  }

}

