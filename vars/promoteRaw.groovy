#!/usr/bin/env groovy

import Properties
import Repo

def call(
    String artifactName,
    String artifactVersion
) {
    artifactVersion = dbUtils.createReport(fileContents)
    mvnExec("wagon:download-single \
        -Dwagon.url=${Properties.Repo.NEXUS_RAW_PATH} \
        -Dwagon.fromFile=${Repo.nexusRawFilePath(artifactVersion, artifactName)} \
        -Dwagon.toFile=${artifactVersion}_${artifactName}.txt")
}
