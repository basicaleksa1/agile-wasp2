package it.agilelab.bigdata.wasp.master.web.openapi

import java.time.Instant

import io.swagger.v3.oas.models.media.{Content, MediaType}
import io.swagger.v3.oas.models.parameters.Parameter
import io.swagger.v3.oas.models.responses.{ApiResponse, ApiResponses}
import io.swagger.v3.oas.models.{Operation, PathItem}
import it.agilelab.bigdata.wasp.models.{Aggregate, MetricEntry, Metrics, SourceEntry, Sources, TelemetryPoint, TelemetrySeries}

trait TelemetryOpenApiComponentSupport
    extends ProductOpenApi
    with LangOpenApi
    with CollectionsOpenApi
    with EnumOpenApi {
  implicit lazy val sourcesOpenApi: ToOpenApiSchema[Sources]         = product2(Sources.apply)
  implicit lazy val metricsOpenApi: ToOpenApiSchema[Metrics]         = product2(Metrics.apply)
  implicit lazy val sourceEntryOpenApi: ToOpenApiSchema[SourceEntry] = product1(SourceEntry.apply)
  implicit lazy val metricEntryOpenApi: ToOpenApiSchema[MetricEntry] = product2(MetricEntry.apply)
  implicit lazy val seriesOpenApi: ToOpenApiSchema[TelemetrySeries]  = product3(TelemetrySeries.apply)
  implicit lazy val telemetryPointOpenApi: ToOpenApiSchema[TelemetryPoint] =
    product2(TelemetryPoint.apply)

  implicit lazy val aggregateOpenApi: ToOpenApiSchema[Aggregate.Value] = enumOpenApi(Aggregate)
}

trait TelemetrRoutesOpenApiDefinition
    extends TelemetryOpenApiComponentSupport
    with AngularResponseOpenApiComponentSupport {

  def telemetryRoutes(ctx: Context): Map[String, PathItem] = {
    Map("/telemetry/sources" -> sources(ctx), "/telemetry/metrics" -> metrics(ctx), "/telemetry/series" -> series(ctx))
  }

  private def sources(ctx: Context) = {
    new PathItem()
      .get(
        new Operation()
          .operationId("list-telemetry-source")
          .description("List top telemetry sources matching search")
          .addTagsItem("telemetry")
          .addParametersItem(
            new Parameter()
              .name("search")
              .in("query")
              .required(true)
              .schema(stringOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("size")
              .in("query")
              .required(true)
              .schema(integerOpenApi.schema(ctx))
          )
          .responses(
            new ApiResponses()
              .addApiResponse(
                "200",
                new ApiResponse()
                  .description("Top sources matching query")
                  .content(
                    new Content()
                      .addMediaType(
                        "text/json",
                        new MediaType()
                          .schema(
                            ToOpenApiSchema[AngularResponse[Sources]]
                              .schema(ctx)
                          )
                      )
                  )
              )
          )
      )
  }

  private def metrics(ctx: Context) = {
    new PathItem()
      .get(
        new Operation()
          .operationId("list-telemetry-metric")
          .description("List top telemetry metrics for source matching search")
          .addTagsItem("telemetry")
          .addParametersItem(
            new Parameter()
              .name("search")
              .in("query")
              .required(true)
              .schema(stringOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("source")
              .in("query")
              .required(true)
              .schema(stringOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("size")
              .in("query")
              .required(true)
              .schema(integerOpenApi.schema(ctx))
          )
          .responses(
            new ApiResponses()
              .addApiResponse(
                "200",
                new ApiResponse()
                  .description("Top sources matching query")
                  .content(
                    new Content()
                      .addMediaType(
                        "text/json",
                        new MediaType()
                          .schema(
                            ToOpenApiSchema[AngularResponse[Metrics]]
                              .schema(ctx)
                          )
                      )
                  )
              )
          )
      )
  }

  private def series(ctx: Context) = {
    new PathItem()
      .get(
        new Operation()
          .operationId("get-telemetry-series")
          .description("Retrieves series data pre aggregated by the server for display")
          .addTagsItem("telemetry")
          .addParametersItem(
            new Parameter()
              .name("metric")
              .in("query")
              .required(true)
              .schema(stringOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("source")
              .in("query")
              .required(true)
              .schema(stringOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("size")
              .in("query")
              .description(
                "The number of buckets to aggregate data in, the start and end timestamp" +
                  " will be divided in [size] number buckets "
              )
              .required(true)
              .schema(integerOpenApi.schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("startTimestamp")
              .in("query")
              .required(true)
              .schema(ToOpenApiSchema[Instant].schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("endTimestamp")
              .in("query")
              .required(true)
              .schema(ToOpenApiSchema[Instant].schema(ctx))
          )
          .addParametersItem(
            new Parameter()
              .name("aggregate")
              .in("query")
              .required(true)
              .schema(aggregateOpenApi.schema(ctx))
          )
          .responses(
            new ApiResponses()
              .addApiResponse(
                "200",
                new ApiResponse()
                  .description("Series data matching query")
                  .content(
                    new Content()
                      .addMediaType(
                        "text/json",
                        new MediaType()
                          .schema(
                            ToOpenApiSchema[AngularResponse[TelemetrySeries]]
                              .schema(ctx)
                          )
                      )
                  )
              )
          )
      )
  }

}
