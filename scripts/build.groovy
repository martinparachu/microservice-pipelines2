#!/usr/bin/env groovy

def buildapp() {
         sh 'mvn -B -DskipTests clean install package'
    }
buildapp()