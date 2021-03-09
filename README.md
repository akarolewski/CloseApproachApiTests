# Close Approach API Tests

Welcome to NASA's Close Approach Api tests example repository.

Project is using Gatling tool with Scala as programming language.

Gatling is mainly an API performance tool, however it can be perfectly used 
for functional/acceptance API testing.

In order to run a scenario class, please follow:

## Project setup

```
git clone git@github.com:akarolewski/CloseApproachApiTests.git
cd CloseApproachApiTests

mvn clean gatling:test    # run all simulations
or
mvn clean gatling:test -Dgatling.simulationClass=com.CloseApproachSimulation    # run specific simulation
```

After test scenario will finish an example output should be presented with an URI
in target directory in project's root for a generated test report:

```
================================================================================

Simulation com.CloseApproachSimulation completed in 1 seconds
Parsing log file(s)...
Parsing log file(s) done
Generating reports...

================================================================================
---- Global Information --------------------------------------------------------
> request count                                          3 (OK=3      KO=0     )
> min response time                                    192 (OK=192    KO=-     )
> max response time                                    942 (OK=942    KO=-     )
> mean response time                                   456 (OK=456    KO=-     )
> std deviation                                        344 (OK=344    KO=-     )
> response time 50th percentile                        233 (OK=233    KO=-     )
> response time 75th percentile                        588 (OK=588    KO=-     )
> response time 95th percentile                        871 (OK=871    KO=-     )
> response time 99th percentile                        928 (OK=928    KO=-     )
> mean requests/sec                                    1.5 (OK=1.5    KO=-     )
---- Response Time Distribution ------------------------------------------------
> t < 800 ms                                             2 ( 67%)
> 800 ms < t < 1200 ms                                   1 ( 33%)
> t > 1200 ms                                            0 (  0%)
> failed                                                 0 (  0%)
================================================================================

Reports generated in 0s.
Please open the following file: /Users/antonikarolewski/CloseApproachApiTests/target/gatling/closeapproachsimulation-20210305114249384/index.html
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.870 s
[INFO] Finished at: 2021-03-05T12:42:53+01:00
[INFO] ------------------------------------------------------------------------
antonikarolewski@antek CloseApproachApiTests (master) $
```

Here you can see it was: `/Users/antonikarolewski/CloseApproachApiTests/target/gatling/closeapproachsimulation-20210305114249384/index.html`


Feel free to open that in you browser to see a Gatling's generic simulation report.

## Docker

In order to run the application as a Docker container, while in project's root directory please run following commands:

```
docker build . -t gatlingtest
docker run -it gatlingtest -rm

OR

docker build . -t gatlingtest
docker run -it gatlingtest bash -rm

Once the container is running and you have access to bash:
mvn clean gatling:test 
```



Other questions? - > `akarolewskia@gmail.com`
