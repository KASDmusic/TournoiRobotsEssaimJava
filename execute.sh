#!/bin/bash

rm -rf bin

cd src

javac -d ../bin/ model/*.java
javac -d ../bin/ -cp ../bin/ view/*.java
javac -d ../bin/ Controleur.java

cd ..
cd bin

str="'$*'"

java Controleur $str

cd ..