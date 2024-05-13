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

case class UserDTO(
  /* The id of the component. */
  id: Option[String] = None,
  /* The ID of the corresponding component that is under version control */
  versionedComponentId: Option[String] = None,
  /* The id of parent process group of this component if applicable. */
  parentGroupId: Option[String] = None,
  position: Option[PositionDTO] = None,
  /* The identity of the tenant. */
  identity: Option[String] = None,
  /* Whether this tenant is configurable. */
  configurable: Option[Boolean] = None,
  /* The groups to which the user belongs. This field is read only and it provided for convenience. */
  userGroups: Option[Set[TenantEntity]] = None,
  /* The access policies this user belongs to. */
  accessPolicies: Option[Set[AccessPolicySummaryEntity]] = None
) extends ApiModel

