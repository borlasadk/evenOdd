#!/usr/bin/env groovy

def call(
    String params
) {
    withMaven() {
        exec("mvn ${params}")
    }
}
