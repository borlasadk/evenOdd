#!/usr/bin/env groovy

def call() {
    return this.currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}