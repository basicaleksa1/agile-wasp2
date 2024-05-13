package it.agilelab.bigdata.wasp.whitelabel.models.test

import com.typesafe.config.ConfigFactory
import it.agilelab.bigdata.wasp.models.{BatchETLModel, BatchJobModel, LegacyStreamingETLModel, ReaderModel, StrategyModel, WriterModel}

private[wasp] object TestBatchJobModels {

  object FromSolr {

    /**
      * Fail if the HDFS directory already exists
      */
    lazy val toHdfsFlat = BatchJobModel(
      name = "TestBatchJobFromSolrToHdfs",
      description = "Description pf TestBatchJobFromSolr",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromSolr",
        inputs = List(
          ReaderModel.solrReader("Solr Reader", TestIndexModel.solr)
        ),
        output = WriterModel.rawWriter("Raw Writer", TestRawModel.flat),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }

  object FromElastic {

    /**
      * Fail if the HDFS directory already exists
      */
    lazy val toHdfsNested = BatchJobModel(
      name = "TestBatchJobFromElasticToHdfs",
      description = "Description pf TestBatchJobFromElasticToHdfs",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromElasticToHdfs",
        inputs = List(
          ReaderModel.elasticReader("Elastic Reader", TestIndexModel.elastic)
        ),
        output = WriterModel.rawWriter("Raw Writer", TestRawModel.nested),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }

  object PostMaterializationHook {
    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val flatToConsole = BatchJobModel(
      name = "TestBatchJobFromHdfsFlatToConsole",
      description = "Description of TestBatchJobFromHdfsFlatToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsFlatToConsole",
        inputs = List(
          ReaderModel.rawReader("Raw Reader", TestRawModel.flat)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }


  object FromHdfs {

    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val flatToConsole = BatchJobModel(
      name = "TestBatchJobFromHdfsFlatToConsole",
      description = "Description of TestBatchJobFromHdfsFlatToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsFlatToConsole",
        inputs = List(
          ReaderModel.rawReader("Raw Reader", TestRawModel.flat)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )

    lazy val toKafka = BatchJobModel(
      name = "TestBatchJobFromHdfsFlatToKafka",
      description = "Description of TestBatchJobFromHdfsFlatToKafka",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsFlatToKafka",
        inputs = List(
          ReaderModel.rawReader(TestRawModel.text.name, TestRawModel.text)
        ),
        output = WriterModel.kafkaWriter(TestTopicModel.plaintext1.name, TestTopicModel.plaintext1),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestToKafkaPlainStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )

    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val nestedToConsole = BatchJobModel(
      name = "TestBatchJobFromHdfsNestedToConsole",
      description = "Description of TestBatchJobFromHdfsNestedToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsNestedToConsole",
        inputs = List(
          ReaderModel.rawReader("TestRawNestedSchemaModel", TestRawModel.nested)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )


    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val nestedToMongo = BatchJobModel(
      name = "TestBatchJobFromHdfsNestedToMongo",
      description = "Description of TestBatchJobFromHdfsNestedToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsNestedToConsole",
        inputs = List(
          ReaderModel.rawReader("TestRawNestedSchemaModel", TestRawModel.nested)
        ),
        output = WriterModel.mongoDbWriter("Console Writer", TestMongoModel.writeToMongo, Map.empty),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }

  object FromMongo {
    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val nestedToConsole = BatchJobModel(
      name = "TestBatchJobFromMongoNestedToConsole",
      description = "Description of TestBatchJobFromHdfsNestedToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsNestedToConsole",
        inputs = List(
          ReaderModel.mongoDbReader("TestRawNestedSchemaModel", TestMongoModel.writeToMongo, Map.empty)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }

  object FromJdbc {

    lazy val mySqlToConsole = BatchJobModel(
      name = "TestBatchJobFromJdbcMySqlToConsole",
      description = "Description of TestBatchJobFromJdbcMySqlToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromJdbcMySqlToConsole",
        inputs = List(
          ReaderModel.jdbcReader("JDBC Reader", TestSqlSouceModel.mySql)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestJdbcMySqlStrategy",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }


  object WithPostHook {


    /**
      * Fail if the HDFS directory does not exist
      */
    lazy val nestedToConsole = BatchJobModel(
      name = "TestBatchJobFromHdfsNestedToConsolePostHook",
      description = "Description of TestBatchJobFromHdfsNestedToConsole",
      owner = "user",
      system = false,
      creationTime = System.currentTimeMillis(),
      etl = BatchETLModel(
        name = "EtlModel for TestBatchJobFromHdfsNestedToConsole",
        inputs = List(
          ReaderModel.rawReader("TestRawNestedSchemaModel", TestRawModel.nested)
        ),
        output = WriterModel.consoleWriter("Console Writer"),
        mlModels = List(),
        strategy = Some(StrategyModel.create("it.agilelab.bigdata.wasp.whitelabel.consumers.spark.strategies.test.TestIdentityStrategyPostHook",
          ConfigFactory.parseString("""stringKey = "stringValue", intKey = 1"""))),
        kafkaAccessType = LegacyStreamingETLModel.KAFKA_ACCESS_TYPE_DIRECT
      )
    )
  }

}