#!/usr/bin/env groovy

def call(
    String gitBranch,
    String gitCredID,
    String gitUrl
) {
    checkout([
        $class: 'GitSCM', 
        branches: [[name: "${gitBranch}"]], 
        doGenerateSubmoduleConfigurations: false, 
        extensions: [
            [$class: 'LocalBranch', localBranch: "**"],
            [$class: 'CleanBeforeCheckout']
        ], 
        submoduleCfg: [], 
        userRemoteConfigs: [[
            credentialsId: gitCredID, 
            url: gitUrl
        ]]
    ])
}