#!/usr/bin/env groovy

import Properties

def success(String status) {
    success("${status}", "")
}

def success(String status, String message) {
    success("${status}", "${message}", Properties.MSTeams.OFFICE365_TEST)
}

def success(String status, String message, String webhook) {
    office365ConnectorSend (status: "${status}", message: "${message}", webhookUrl: "${webhook}")
}

def fail(String status) {
    fail("${status}", "")
}

def fail(String status, String message) {
    fail("${status}", "${message}", Properties.MSTeams.OFFICE365_TEST)
}

def fail(String status, String message, String webhook) {
    office365ConnectorSend (status: "${status}", message: "${message}", webhookUrl: "${webhook}")
}

def deployMessage(String branch, String env, String user) {
    return "${branch} has been deployed on ${env} by ${user}"
}