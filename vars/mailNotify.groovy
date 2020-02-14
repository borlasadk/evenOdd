#!/usr/bin/env groovy

import Properties

def call(
    String _CTC_DB_VERSION

) {
    mail to: Properties.Emails.EMAIL_DIFFERENCE_DB_LIST,
         cc: Properties.Emails.EMAIL_LEADER_LIST,
        subject: "Report of CTC DB structure changes: ${_CTC_DB_VERSION}",
        body:  '''<p>Dear Colleagues,</p>
                        <p> </p>
                        <p></a>. </p>
                        <p> </p>
                        <p>Please find attached difference of database structure for coming CTC release 19.11.</a>.</p>
                        <p> </p>
                        <p>Thank you.</p>''',
        attachmentsPattern: "${_CTC_DB_VERSION}.txt"
}

def call(
    String fullDisplayName, 
    String buildNumber,
    String buildUrl,
    String email
) {
    mail to: "${email}", 
        subject: "The pipeline ${fullDisplayName}", 
        body:  "Build # ${buildNumber}: \nCheck console output at ${buildUrl} to view the results."
}
