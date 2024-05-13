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

case class GarbageCollectionDTO(
  /* The name of the garbage collector. */
  name: Option[String] = None,
  /* The number of times garbage collection has run. */
  collectionCount: Option[Long] = None,
  /* The total amount of time spent garbage collecting. */
  collectionTime: Option[String] = None,
  /* The total number of milliseconds spent garbage collecting. */
  collectionMillis: Option[Long] = None
) extends ApiModel


