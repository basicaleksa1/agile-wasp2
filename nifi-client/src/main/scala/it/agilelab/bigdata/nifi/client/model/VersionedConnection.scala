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

case class VersionedConnection(
  /* The component's unique identifier */
  identifier: Option[String] = None,
  /* The component's name */
  name: Option[String] = None,
  /* The user-supplied comments for the component */
  comments: Option[String] = None,
  position: Option[Position] = None,
  source: Option[ConnectableComponent] = None,
  destination: Option[ConnectableComponent] = None,
  /* The index of the bend point where to place the connection label. */
  labelIndex: Option[Int] = None,
  /* The z index of the connection. */
  zIndex: Option[Long] = None,
  /* The selected relationship that comprise the connection. */
  selectedRelationships: Option[Set[String]] = None,
  /* The object count threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue. */
  backPressureObjectThreshold: Option[Long] = None,
  /* The object data size threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue. */
  backPressureDataSizeThreshold: Option[String] = None,
  /* The amount of time a flow file may be in the flow before it will be automatically aged out of the flow. Once a flow file reaches this age it will be terminated from the flow the next time a processor attempts to start work on it. */
  flowFileExpiration: Option[String] = None,
  /* The comparators used to prioritize the queue. */
  prioritizers: Option[Seq[String]] = None,
  /* The bend points on the connection. */
  bends: Option[Seq[Position]] = None,
  /* The Strategy to use for load balancing data across the cluster, or null, if no Load Balance Strategy has been specified. */
  loadBalanceStrategy: Option[VersionedConnectionEnums.LoadBalanceStrategy] = None,
  /* The attribute to use for partitioning data as it is load balanced across the cluster. If the Load Balance Strategy is configured to use PARTITION_BY_ATTRIBUTE, the value returned by this method is the name of the FlowFile Attribute that will be used to determine which node in the cluster should receive a given FlowFile. If the Load Balance Strategy is unset or is set to any other value, the Partitioning Attribute has no effect. */
  partitioningAttribute: Option[String] = None,
  /* Whether or not compression should be used when transferring FlowFiles between nodes */
  loadBalanceCompression: Option[VersionedConnectionEnums.LoadBalanceCompression] = None,
  componentType: Option[VersionedConnectionEnums.ComponentType] = None,
  /* The ID of the Process Group that this component belongs to */
  groupIdentifier: Option[String] = None
) extends ApiModel

object VersionedConnectionEnums {

  type LoadBalanceStrategy = LoadBalanceStrategy.Value
  type LoadBalanceCompression = LoadBalanceCompression.Value
  type ComponentType = ComponentType.Value
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

  object ComponentType extends Enumeration {
    val CONNECTION = Value("CONNECTION")
    val PROCESSOR = Value("PROCESSOR")
    val PROCESSGROUP = Value("PROCESS_GROUP")
    val REMOTEPROCESSGROUP = Value("REMOTE_PROCESS_GROUP")
    val INPUTPORT = Value("INPUT_PORT")
    val OUTPUTPORT = Value("OUTPUT_PORT")
    val REMOTEINPUTPORT = Value("REMOTE_INPUT_PORT")
    val REMOTEOUTPUTPORT = Value("REMOTE_OUTPUT_PORT")
    val FUNNEL = Value("FUNNEL")
    val LABEL = Value("LABEL")
    val CONTROLLERSERVICE = Value("CONTROLLER_SERVICE")
  }

}
