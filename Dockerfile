FROM azul/zulu-openjdk:21 AS builder

COPY . .

RUN ./gradlew --no-daemon build -x test

FROM azul/zulu-openjdk:21

RUN mkdir /vehicles

WORKDIR /vehicles

COPY --from=builder /build/libs/vehicles-*.jar /vehicles/vehicles.jar

CMD java -Dserver.port=8080 -Dspring.profiles.active=docker --enable-preview -jar vehicles.jar