package it.agilelab.bigdata.wasp.repository.core.bl

import it.agilelab.bigdata.wasp.models.{DatastoreModel, MultiTopicModel, TopicModel}

trait TopicBL {

  def getByName(name: String): Option[DatastoreModel]
	
	/**
		* Gets a TopicModel by name; an exception is thrown if a MultiTopicModel or anything else is found instead.
		*/
	@throws[Exception]
	def getTopicModelByName(name: String): Option[TopicModel] = {
		getByName(name) map {
			case topicModel: TopicModel => topicModel
			case multiTopicModel: MultiTopicModel =>
				throw new Exception(s"Found MultiTopicModel instead of TopicModel for name $name")
		}
	}

  def getAll : Seq[DatastoreModel]

  def persist(topicModel: DatastoreModel): Unit

  def upsert(topicModel: DatastoreModel): Unit

  def insertIfNotExists(topicDatastoreModel: DatastoreModel): Unit

}