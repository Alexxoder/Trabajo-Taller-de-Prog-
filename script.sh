#! /bin/sh

cd ServidorCentralMaven
mvn clean install package
cd ..
cd ServidorWebMaven
mvn clean install package
cd ..
cd ServidorMovilMaven
mvn clean install package