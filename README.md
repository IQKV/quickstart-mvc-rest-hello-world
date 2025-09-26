# 🚀 Hello, World! - RESTful Application

Minimal Spring Boot based RESTful 'Hello World' example, including Swagger/OpenAPI, health, metrics, tests, and optional local observability stack.

## Technology stack

Java 25, Spring Boot, Undertow, OpenAPI/Swagger, JUnit, Mockito, JaCoCo

## Prerequisites

The following items should be installed on your system:

- Java 25 or newer
- Git command line tool (`https://help.github.com/articles/set-up-git`)
- Your preferred IDE (IntelliJ IDEA preferred)
- Optional: Docker (for local observability via Compose)
- Optional: Minikube + kubectl (for local Kubernetes)

### Running locally

This application is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built
using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

```shell script
git clone https://github.com/IQKV/quickstart-mvc-rest-hello-world.git
cd quickstart-mvc-rest-hello-world
./mvnw package
java -jar target/*.jar
```

You might also want to use Maven's `spring-boot:run` goal — applications run in an exploded form, as they do in your IDE:

```shell script
./mvnw spring-boot:run -Dspring-boot.run.profiles=local -P dev
```

- Default HTTP port: `8080`
- Base API path: `/api/v1`

### API endpoints

- GET `/api/v1/hello-world` → returns a JSON object `{ "message": "Hello, World!" }`

### Swagger / OpenAPI

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI spec: see `docs/openapi.yml`; a generated `swagger.json` is also in `docs/`

### Working with the Application in your IDE

1. On the command line

```shell script
git clone https://github.com/IQKV/quickstart-mvc-rest-hello-world.git
```

2. Inside IDE

In the main menu, choose `File -> Open` and select the project `pom.xml`. Click `Open`.
Activate the `local` profile in Run Configuration, or set it via environment variables (see
[instruction](https://stackoverflow.com/questions/38520638/how-to-set-spring-profile-from-system-variable)).
Wait for indexing completion and press the Run button.

3. Navigate to Swagger UI

Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser.

## Code conventions

The code adheres to the [Google Code Conventions](https://google.github.io/styleguide/javaguide.html). Code
quality is measured by:

- [SonarQube](https://docs.sonarsource.com/)
- [PMD](https://pmd.github.io/)
- [CheckStyle](https://checkstyle.sourceforge.io/)
- [SpotBugs](https://spotbugs.github.io/)
- [Qulice](https://www.qulice.com/)

### Tests

This project contains JUnit tests, Hamcrest matchers, Mockito test doubles, Wiremock stubs, etc. You can run the test suite using

```shell script
./mvnw verify -Puse-qulice
```

- Coverage is enforced via JaCoCo rules in `pom.xml` (bundle/class rules with ≥90% thresholds).
- The minimum percentage of code coverage required for the workflow to pass is **80%**.

## Observability (optional)

A local Prometheus + Grafana stack is provided via Docker Compose to visualize metrics exposed by Actuator/Micrometer.

```shell script
# Start Prometheus and Grafana on the host network (Linux/Windows)
docker compose up -d

# Access Grafana (default admin password is set to "changeme")
http://localhost:3000

# Prometheus (host network)
http://localhost:9090
```

Notes:

- Compose file uses `network_mode: host` for easier local testing. On macOS, remove that line and use `host.docker.internal` where applicable (see comments in `compose.yaml`).
- Actuator metrics endpoint is exposed by Spring Boot; Prometheus is pre-configured to scrape `localhost:8080`.

## Kubernetes with Minikube (optional)

Manifests and helper scripts are available under `src/main/minikube`.

- Manifests: `src/main/minikube/manifests`
- Scripts: `src/main/minikube/scripts`

Typical flow:

```shell script
# From the project root
bash src/main/minikube/scripts/setup-cluster.sh   # one-time tooling setup
bash src/main/minikube/scripts/start-cluster.sh   # start minikube
bash src/main/minikube/scripts/set-env.sh         # export environment vars

# Build application JAR
./mvnw package

# Apply manifests
auth kubectl apply -f src/main/minikube/manifests

# Optional helpers
bash src/main/minikube/scripts/ip-cluster.sh
bash src/main/minikube/scripts/stop-cluster.sh
```

> If using Windows, run the corresponding `.cmd` or use Git Bash/WSL to execute `.sh` scripts.

> Exposed endpoints may be fronted by an Ingress in the manifests; adjust hostnames according to your Minikube setup.

> Health checks and metrics are exposed via Spring Boot Actuator.

> For local-only testing, running directly with `spring-boot:run` is usually sufficient.

> For CI/linting rules, see `pom.xml` profiles (e.g., `use-qulice`).

> For API examples and schema, see `docs/` folder (OpenAPI, Swagger JSON, Postman collection).

> ### Versioning
>
> Project uses a three-segment [CalVer](https://calver.org/) scheme, with a short year in the major version slot, short month in the minor version slot, and micro/patch version in the third
> and final slot.
>
> ```
>  YY.MM.MICRO
> ```
>
> 1. **YY** - short year - 6, 16, 106
> 2. **MM** - short month - 1, 2 ... 11, 12
> 3. **MICRO** - "patch" segment
