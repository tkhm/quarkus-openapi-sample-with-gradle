# code-with-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

** Generates project using Quakus with Gradle and integrates with OpenAPI(v3) Generator **

`./gradlew build` will invoke openapi spec validation and code generation before the build. Also Generation Gap Pattern is applied, so this repo doesn't contain model and api code.

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


## OpenAPI Generator CLI Command

```
openapi-generator generate -g jaxrs-jersey -i src/main/resources/META-INF/openapi.yaml config.json
```

```
openapi-generator generate -g jaxrs-spec -i src/main/resources/META-INF/openapi.yaml -o ./ -c src/main/resources/config.json
```
