FROM hseeberger/scala-sbt
RUN mkdir /sampleService
WORKDIR /sampleService
COPY . /sampleService
CMD ["sbt", "run"]