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

case class ConnectionDTO(
  /* The id of the component. */
  id: Option[String] = None,
  /* The ID of the corresponding component that is under version control */
  versionedComponentId: Option[String] = None,
  /* The id of parent process group of this component if applicable. */
  parentGroupId: Option[String] = None,
  position: Option[PositionDTO] = None,
  source: Option[ConnectableDTO] = None,
  destination: Option[ConnectableDTO] = None,
  /* The name of the connection. */
  name: Option[String] = None,
  /* The index of the bend point where to place the connection label. */
  labelIndex: Option[Int] = None,
  /* The z index of the connection. */
  getzIndex: Option[Long] = None,
  /* The selected relationship that comprise the connection. */
  selectedRelationships: Option[Set[String]] = None,
  /* The relationships that the source of the connection currently supports. */
  availableRelationships: Option[Set[String]] = None,
  /* The object count threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue. */
  backPressureObjectThreshold: Option[Long] = None,
  /* The object data size threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue. */
  backPressureDataSizeThreshold: Option[String] = None,
  /* The amount of time a flow file may be in the flow before it will be automatically aged out of the flow. Once a flow file reaches this age it will be terminated from the flow the next time a processor attempts to start work on it. */
  flowFileExpiration: Option[String] = None,
  /* The comparators used to prioritize the queue. */
  prioritizers: Option[Seq[String]] = None,
  /* The bend points on the connection. */
  bends: Option[Seq[PositionDTO]] = None,
  /* How to load balance the data in this Connection across the nodes in the cluster. */
  loadBalanceStrategy: Option[ConnectionDTOEnums.LoadBalanceStrategy] = None,
  /* The FlowFile Attribute to use for determining which node a FlowFile will go to if the Load Balancing Strategy is set to PARTITION_BY_ATTRIBUTE */
  loadBalancePartitionAttribute: Option[String] = None,
  /* Whether or not data should be compressed when being transferred between nodes in the cluster. */
  loadBalanceCompression: Option[ConnectionDTOEnums.LoadBalanceCompression] = None,
  /* The current status of the Connection's Load Balancing Activities. Status can indicate that Load Balancing is not configured for the connection, that Load Balancing is configured but inactive (not currently transferring data to another node), or that Load Balancing is configured and actively transferring data to another node. */
  loadBalanceStatus: Option[ConnectionDTOEnums.LoadBalanceStatus] = None
) extends ApiModel

object ConnectionDTOEnums {

  type LoadBalanceStrategy = LoadBalanceStrategy.Value
  type LoadBalanceCompression = LoadBalanceCompression.Value
  type LoadBalanceStatus = LoadBalanceStatus.Value
  object LoadBalanceStrategy extends Enumeration {
    val DONOTLOADBALANCE = Value("DO_NOT_LOAD_BALANCE")
    val PARTITIONBYATTRIBUTE = Value("PARTITION_BY_ATTRIBUTE")
    val ROUNDROBIN = Value("ROUND_ROBIN")
    val SINGLENODE = Value("SINGLE_NODE")
  }

  object LoadBalanceCompression extends Enumeration {
    val DONOTCOMPRESS = Value("DO_NOT_COMPRESS")
    val COMPRESSATTRIBUTESONLY = Value("COMPRESS_ATTRIBUTES_ONLY")
    val COMPRESSATTRIBUTESANDCONTENT = Value("COMPRESS_ATTRIBUTES_AND_CONTENT")
  }

  object LoadBalanceStatus extends Enumeration {
    val LOADBALANCENOTCONFIGURED = Value("LOAD_BALANCE_NOT_CONFIGURED")
    val LOADBALANCEINACTIVE = Value("LOAD_BALANCE_INACTIVE")
    val LOADBALANCEACTIVE = Value("LOAD_BALANCE_ACTIVE")
  }

}

