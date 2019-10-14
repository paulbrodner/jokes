ARTEFACT:=target/jokes-0.0.1-SNAPSHOT.jar

build:
	@mvn clean package

run:
	nohup java -jar $(ARTEFACT) & echo $$! > joke.PID

stop:
	@[ -f ./joke.PID ] && kill `cat joke.PID` && rm joke.PID || true