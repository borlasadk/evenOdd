#!/usr/bin/env groovy

import Properties

def call(


) {
    emailext recipientProviders: [[$class: 'RequesterRecipientProvider']],
             to: Properties.Emails.EMAIL_TEST,
             bcc: Properties.Emails.EMAIL_TEST2,
             subject: "Report of CTC DB structure changes: ${dbUtils.versionGet()}",
             body:  "Dear Colleagues, \n\nPlease find attached difference of database structure for coming CTC release 19.11.\n\nThank you.",
             attachmentsPattern: "${Properties.Paths.DIFFERENCE_DB_DIR}*.txt"
}



