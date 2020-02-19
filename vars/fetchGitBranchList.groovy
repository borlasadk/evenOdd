#!/usr/bin/env groovy

def call(String gitURL) {
    return "git ls-remote -h ${gitURL}"
        .execute()
        .text
        .replaceAll(/[a-z0-9]*\trefs\/heads\//, '')
}