#!/usr/bin/env groovy

def call(
    String params
) {
    if (isUnix()) {
        sh "${params}"
    } else {
        bat "${params}"
    }
}

def call(
    String params,
    Boolean returnStdout
) {
    if (isUnix()) {
        sh(script: "${params}", returnStdout: returnStdout)
    } else {
        bat(script: "${params}", returnStdout: returnStdout)
    }
}
