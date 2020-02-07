# quarkus-openapi-samile-with-gradle
Quarkus and OpenAPI using Gradle.

I prefer to use Gradle, but Quarkus and OpenAPI has Maven example a lot. That's why I published this. I hope this will help to understand the combination of Quarkus and OpenAPI using Gradle.

`./gradlew build` or `./gradlew quarkusDev` will invoke openapi spec validation and code generation before the build. Also Generation Gap Pattern is applied, so this repo doesn't contain model and api code.

After `quarkusDev` run, you can reach the swagger-ui on `localhost:8080/swagger-ui`

## OpenAPI Generator CLI Command

JAX-RS Spec: Minimum output. You need to impl or make some conventions for it, but it works well.

```
openapi-generator generate -g jaxrs-spec -i src/main/resources/META-INF/openapi.yaml -o ./ -c src/main/resources/config.json
```

JAX-RS Jersey: It will be successful in the compile, but `quarkusDev` will be failed with `> Failed to build a runnable JAR` As a result, I dropped off it from my generator options.

```
openapi-generator generate -g jaxrs-jersey -i src/main/resources/META-INF/openapi.yaml config.json
```

## Docker Command

* Build the image: `docker build -f src/main/docker/Dockerfile.jvm -t tkhm/quarkus-openapi-sample-with-gradle .`
* Run the iamge: `docker run -i --rm -p 8080:8080 tkhm/quarkus-openapi-sample-with-gradle`

## References

* [Quarkus - Start coding with code.quarkus.io](https://code.quarkus.io/)
* [Building Quarkus apps with Gradle](https://quarkus.io/guides/gradle-tooling.html) 
* [Quarkus - Using OpenAPI and Swagger UI](https://quarkus.io/guides/openapi-swaggerui)
* [Generators List · OpenAPI Generator](https://openapi-generator.tech/docs/generators.html)
* [Swagger ではない OpenAPI Specification 3.0 による API サーバー開発](https://www.slideshare.net/techblogyahoo/swagger-openapi-specification-30-api) (Japanese)
* [平静を保ち、コードを生成せよ 〜 OpenAPI Generator誕生の背景と軌跡 〜 / gunmaweb34 - Speaker Deck](https://speakerdeck.com/akihito_nakano/gunmaweb34) (Japanese)


# Quarkus default README

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./gradlew quarkusDev
```

## Packaging and running the application

The application is packageable using `./gradlew quarkusBuild`.
It produces the executable `code-with-quarkus-1.0.0-SNAPSHOT-runner.jar` file in `build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

The application is now runnable using `java -jar build/code-with-quarkus-1.0.0-SNAPSHOT-runner.jar`.

If you want to build an _über-jar_, just add the `--uber-jar` option to the command line:
```
./gradlew quarkusBuild --uber-jar
```

## Creating a native executable

You can create a native executable using: `./gradlew buildNative`.

Or you can use Docker to build the native executable using: `./gradlew buildNative --docker-build=true`.

You can then execute your binary: `./build/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling#building-a-native-executable .
