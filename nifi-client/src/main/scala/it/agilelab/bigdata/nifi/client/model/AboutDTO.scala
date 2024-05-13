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

case class AboutDTO(
  /* The title to be used on the page and in the about dialog. */
  title: Option[String] = None,
  /* The version of this NiFi. */
  version: Option[String] = None,
  /* The URI for the NiFi. */
  uri: Option[String] = None,
  /* The URL for the content viewer if configured. */
  contentViewerUrl: Option[String] = None,
  /* The timezone of the NiFi instance. */
  timezone: Option[String] = None,
  /* Build tag */
  buildTag: Option[String] = None,
  /* Build revision or commit hash */
  buildRevision: Option[String] = None,
  /* Build branch */
  buildBranch: Option[String] = None,
  /* Build timestamp */
  buildTimestamp: Option[String] = None
) extends ApiModel

