#!/usr/bin/env groovy

import Properties

def success(String status) {
    success("${status}", "")
}

def success(String status, String message) {
    success("${status}", "${message}", Properties.MSTeams.OFFICE365_SUCCESS_TEST)
}

def success(String status, String message, String webhook) {
    office365ConnectorSend (status: "${status}", message: "${message}", webhookUrl: "${webhook}")
}

def fail(String status) {
    fail("${status}", "")
}

def fail(String status, String message) {
    fail("${status}", "${message}", Properties.MSTeams.OFFICE365_FAILURE_TEST)
}

def fail(String status, String message, String webhook) {
    office365ConnectorSend (status: "${status}", message: "${message}", webhookUrl: "${webhook}")
}

