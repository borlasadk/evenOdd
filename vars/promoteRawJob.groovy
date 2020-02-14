#!/usr/bin/env groovy
import Properties
import Repo

def call(Properties.RawArtifact artifact, String ARTIFACT_VERSION) {
    stage("Promote ${artifact.name}") {
        promoteRaw(
            artifact.code,
            ARTIFACT_VERSION
        )

    }
}