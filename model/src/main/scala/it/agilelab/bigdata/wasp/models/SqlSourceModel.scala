package it.agilelab.bigdata.wasp.models

import it.agilelab.bigdata.wasp.datastores.DatastoreProduct.JDBCProduct
import it.agilelab.bigdata.wasp.datastores.{DatastoreProduct}
import it.agilelab.bigdata.wasp.models.configuration.JdbcPartitioningInfo


/**
  * Class representing a SqlSource model
  *
  * @param name             The name of the SqlSource model
  * @param connectionName   The name of the connection to use.
  *                         N.B. have to be present in jdbc-subConfig
  * @param dbtable          The name of the table
  * @param partitioningInfo optional - Partition info (column, lowerBound, upperBound)
  * @param numPartitions    optional - Number of partitions
  * @param fetchSize        optional - Fetch size
  */
case class SqlSourceModel(name: String,
                          connectionName: String,
                          dbtable: String,
                          partitioningInfo: Option[JdbcPartitioningInfo],
                          numPartitions: Option[Int],
                           fetchSize: Option[Int])
    extends DatastoreModel {
  override def datastoreProduct: DatastoreProduct = JDBCProduct
}