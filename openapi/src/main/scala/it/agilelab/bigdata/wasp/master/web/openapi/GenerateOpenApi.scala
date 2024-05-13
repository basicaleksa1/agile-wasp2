package it.agilelab.bigdata.wasp.master.web.openapi
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths, StandardOpenOption}
import io.swagger.v3.oas.models.{OpenAPI, PathItem}
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import io.swagger.v3.oas.models.tags.Tag
import it.agilelab.bigdata.wasp.core.build.BuildInfo

trait WaspOpenApi
  extends BatchJobRoutesOpenApiDefinition
    with PipegraphRoutesOpenApiDefinition
    with ProducersRoutesOpenApiDefinition
    with DocumentRoutesOpenApiDefinition
    with IndicesRoutesOpenApiDefinition
    with TopicRoutesOpenApiDefinition
    with MlModelsRoutesOpenApiDefinition
    with ConfigRoutesOpenApiDefinition
    with LogsRoutesOpenApiDefinition
    with EventsRoutesOpenApiDefinition
    with TelemetrRoutesOpenApiDefinition
    with KeyValueRoutesOpenApiDefinition
    with RawRoutesOpenApiDefinition
    with StatsRoutesOpenApiDefinition
    with EditorRoutesOpenApiDefinition
    with StrategyOpenApiDefinition
    with FreeCodeRoutesOpenApiDefinition
    with GenericRoutesOpenApiDefinition {

  protected def getRoutes(ctx: Context): Map[String, PathItem] = {
    batchJobRoutes(ctx) ++ pipegraphRoutes(ctx) ++
      producersRoutes(ctx) ++ indicesRoutes(ctx) ++
      topicRoute(ctx) ++ documentsRoutes(ctx) ++
      mlmodelsRoutes(ctx) ++ configRoute(ctx) ++
      logsRoutes(ctx) ++ eventsRoutes(ctx) ++
      telemetryRoutes(ctx) ++ keyValueRoutes(ctx) ++
      rawRoutes(ctx) ++ statsRoutes(ctx) ++
      editorRoutes(ctx) ++ freeCodeRoutes(ctx) ++
      strategiesRoutes(ctx) ++ genericRoutes(ctx)
  }

  protected def getOpenApi = new OpenAPI()
    .addServersItem(
      new Server()
        .description("default development server, beware of CORS")
        .url("http://localhost:2891")
    )
    .info(new Info().title("wasp-api").version(BuildInfo.version))
    .addTagsItem(
      new Tag()
        .name("batchjobs")
        .description("operation related to batchjobs management")
    )
    .addTagsItem(
      new Tag()
        .name("pipegraphs")
        .description("operation related to pipegraphs management")
    )
    .addTagsItem(
      new Tag()
        .name("producers")
        .description("operation related to producers management")
    )
    .addTagsItem(
      new Tag()
        .name("documents")
        .description("operation related to documents management")
    )
    .addTagsItem(
      new Tag()
        .name("topics")
        .description("operation related to topics management")
    )
    .addTagsItem(
      new Tag()
        .name("indices")
        .description("operation related to indices management")
    )
    .addTagsItem(
      new Tag()
        .name("mlmodels")
        .description(
          "operation related to machine learning models management"
        )
    )
    .addTagsItem(
      new Tag()
        .name("configuration")
        .description("operation related to configurations management")
    )
    .addTagsItem(
      new Tag()
        .name("logs")
        .description("operation related to logs inspection")
    )
    .addTagsItem(
      new Tag()
        .name("events")
        .description("operation related to events inspection")
    )
    .addTagsItem(
      new Tag()
        .name("telemetry")
        .description("operation related to telemetry inspection")
    )
    .addTagsItem(
      new Tag()
        .name("keyvalue")
        .description("operation related to keyvalue models management")
    )
    .addTagsItem(
      new Tag()
        .name("raw")
        .description("operation related to raw models management")
    )
    .addTagsItem(
      new Tag()
        .name("stats")
        .description("Statistics about logs events and metrics")
    )
    .addTagsItem(
      new Tag()
        .name("editor")
        .description("operation related to stateless nifi, used as editor and pipegraphs creation")
    ).addTagsItem(
    new Tag()
      .name("freeCode")
      .description("operation related to free code strategy management")
  )
    .addTagsItem(
      new Tag()
        .name("generic")
        .description("operation related to generic models management")
    )

}

object GenerateOpenApi extends WaspOpenApi{

  def main(args: Array[String]): Unit = {

    val generate = (ctx: Context) => {
      val routes = getRoutes(ctx)
      val openApi = getOpenApi

      routes.foreach {case (key, value) => openApi.path(key, value)}
      openApi
    }

    Files.write(
      Paths.get(args(0)),
      OpenApiRenderer.render(generate).getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE,
      StandardOpenOption.TRUNCATE_EXISTING
    )

    //println(OpenApiRenderer.render(generate))
  }
}
