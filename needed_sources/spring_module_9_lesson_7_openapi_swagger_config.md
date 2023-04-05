# OpenAPI Configuration with Annotation Config

````java
@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "${api.version}",
                contact = @Contact(
                        name = "Elmurodov Javohir", email = "john.lgd65@gmail.com", url = "https://github.com/jlkesh"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
````

# OpenAPI Configuration with Java Config

````java

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("${api.version}")
                        .contact(new Contact()
                                .name("Elmurodov Javohir")
                                .email("john.lgd65@gmail.com")
                                .url("https://github.com/jlkesh"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Production")
                ))
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

    @Bean
    public GroupedOpenApi annotationGroupAPI() {
        return GroupedOpenApi.builder()
                .group("annotation")
                .pathsToMatch("/store/**", "/config/**")
                .build();
    }
}
````

# Annotations

* `@Tag`
* `@Parameter`
* `@Hidden`
* `@Schema`
* `@Schema(accessMode = READ_ONLY)`
* `@Schema`
* `@Operation(summary = "foo", description = "bar")`
* `@ApiResponse(responseCode = "404", description = "foo")`

# Example

````java
@Tag(name = "Store APIs", description = "It is a long established fact that a reader")
````

````java
 @Operation(summary = "Create New Store", description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully Created", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = Store.class))
        }),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = RuntimeException.class))
        }),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = RuntimeException.class))
        })
})
````

````java
@Schema(name = "Store", description = "Store Entity")
````


# Yaml Configuration

````yaml
openapi: 3.0.2
info:
  title: Spring 6 Swagger 2 YAML Example
  description: Spring 6 Swagger Simple Application
  termsOfService: http://swagger.io/terms/
  contact:
    email: apiteam@swagger.io
  license:
    name: Apache 2.0
    url: http://www.apache.org/licenses/LICENSE-2.0.html
  version: 1.0.4
externalDocs:
  description: Find out more about Swagger
  url: http://swagger.io
servers:
  - url: http://localhost:8080
    description: Production Service
  - url: http://localhost:9090
    description: Test Service
tags:
  - name: Category
    description: Category Entity
    externalDocs:
      description: Find out more
      url: 'http://swagger.io'
paths:
  /category/create:
    post:
      tags:
        - Category
      summary: Create Category Entity
      description: Create Category Entity
      requestBody:
        description: Category Fill to All Fields
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Category'
      responses:
        201:
          description: Successfully Created Entity
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Category'
        400:
          description: Invalid Validation
          content:
            application/json:
              schema:
                $ref: '#/components/responses/InvalidValidationException'
      security:
        - api_key: [ ]
  /category/update:
    put:
      tags:
        - Category
      summary: Update Category Entity
      description: Update Category Entity
      requestBody:
        description: Category Fill to All Fields
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Category'
      responses:
        200:
          description: Successfully Updated Entity
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Category'
        400:
          description: Invalid Validation
          content:
            application/json:
              schema:
                $ref: '#/components/responses/InvalidValidationException'
        404:
          description: Category Not Found
          content:
            application/json:
              schema:
                $ref: '#/components/responses/NotFound'
      security:
        - api_key: [ ]
  /category/delete/{id}:
    delete:
      tags:
        - Category
      summary: Deleted Category Entity
      description: Deleted Category Entity
      parameters:
        - name: id
          in: query
          description: Must Be Enter Id
          required: true
          schema:
            type: integer
      responses:
        204:
          description: Successfully Deleted - Category
        400:
          description: Invalid Validation
          content:
            application/json:
              schema:
                $ref: '#/components/responses/InvalidValidationException'
        404:
          description: Category Not Found
          content:
            application/json:
              schema:
                $ref: '#/components/responses/NotFound'
      security:
        - api_key: [ ]
  /category/get/{id}:
    get:
      tags:
        - Category
      summary: Get Category Entity
      description: Get Category Entity
      parameters:
        - name: id
          in: query
          description: Must Be Enter Id
          required: true
          schema:
            type: integer
      responses:
        200:
          description: Successfully Get - Category
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Category'
        400:
          description: Invalid Validation
          content:
            application/json:
              schema:
                $ref: '#/components/responses/InvalidValidationException'
        404:
          description: Category Not Found
          content:
            application/json:
              schema:
                $ref: '#/components/responses/NotFound'
components:
  schemas:
    Category:
      type: object
      properties:
        id:
          type: integer
          format: int32
          example: 1
        name:
          type: string
          example: Swamp
        code:
          type: string
          example: SWAMP
  responses:
    NotFound:
      description: Entity not found
    InvalidValidationException:
      description: Invalid Validation
    RuntimeException:
      description: Entity Created Exception
````

# Json Configuration

````json
{
  "openapi": "3.0.1",
  "info": {
    "title": "Spring 6 Swagger 2 JSON Example",
    "description": "Spring 6 Swagger Simple Application",
    "license": {
      "name": "Apache 2.0",
      "url": "http://springdoc.org"
    },
    "version": "v0.0.01"
  },
  "externalDocs": {
    "description": "SpringShop Wiki Documentation",
    "url": "https://springshop.wiki.github.org/docs"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/item/create": {
      "post": {
        "tags": [
          "item-controller"
        ],
        "operationId": "create",
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "required": false,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          },
          {
            "name": "name",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "description",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "price",
            "in": "query",
            "required": false,
            "schema": {
              "type": "number",
              "format": "double"
            }
          }
        ],
        "responses": {
          "201": {
            "description": "CREATED",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Item"
                }
              }
            }
          }
        },
        "security": [
          {
            "api_key": []
          }
        ]
      }
    },
    "/item/update": {
      "put": {
        "tags": [
          "item-controller"
        ],
        "operationId": "update",
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "required": false,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          },
          {
            "name": "name",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "description",
            "in": "query",
            "required": false,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "price",
            "in": "query",
            "required": false,
            "schema": {
              "type": "number",
              "format": "double"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Item"
                }
              }
            }
          }
        },
        "security": [
          {
            "api_key": []
          }
        ]
      }
    },
    "/item/get/{id}": {
      "get": {
        "tags": [
          "item-controller"
        ],
        "operationId": "get",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/Item"
                }
              }
            }
          }
        },
        "security": [
          {
            "api_key": []
          }
        ]
      }
    },
    "/item/delete/{id}": {
      "delete": {
        "tags": [
          "item-controller"
        ],
        "operationId": "delete",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "required": true,
            "schema": {
              "type": "integer",
              "format": "int64"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          }
        },
        "security": [
          {
            "api_key": []
          }
        ]
      }
    }
  },
  "components": {
    "schemas": {
      "Item": {
        "type": "object",
        "properties": {
          "id": {
            "type": "integer",
            "format": "int64"
          },
          "name": {
            "type": "string",
            "example": "Nurislom"
          },
          "description": {
            "type": "string",
            "example": "Lorem Ipsum"
          },
          "price": {
            "type": "number",
            "format": "double"
          }
        }
      }
    },
    "securitySchemes": {
      "api_key": {
        "type": "http",
        "scheme": "bearer",
        "bearerFormat": "JWT"
      }
    }
  }
}
````

# Enabling YAML OR JSON

````properties
springdoc.swagger-ui.config-url=/swagger-url.json
springdoc.paths-to-match=/store/**, /config/**
````

<details>
<summary style="font-size:40px; font-weight:bold;">Security Config</summary>

# Security Support (JWT Bearer) With Java Config

````java
...
        .components(new Components()
        .addSecuritySchemes("bearerAuth",new SecurityScheme()
        .name("bearerAuth")
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT")));
        ... 
````

# Security Support (HTTP Basic) With Java Config

````java
...
        .components(new Components()
        .addSecuritySchemes("basicAuth",new SecurityScheme()
        .name("basicAuth")
        .type(SecurityScheme.Type.HTTP)
        .scheme("basic")));
        ... 
````

# Security Support (JWT Bearer) With Annotation

````java
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
````

# Security Support (HTTP Basic) With Annotation

````java
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
````

</details>