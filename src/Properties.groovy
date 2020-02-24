#!/usr/bin/env groovy

class Properties {
    class Emails {
        static String EMAIL_DIFFERENCE_DB_LIST="Pavel_Horbach1@epam.com, Dmitry_Rubin@epam.com, Ihar_Ilmovsky@epam.com, WFTInternalApplicationsReporting@epam.com"
        static String EMAIL_LEADER_LIST="SpecialEPM-CTCLeaders@epam.com"
        static String EMAIL_TEST="altayev.dauren@yandex.kz"
    }

    class Repo {
        static String NEXUS_URL = "http://ci.epm-ctc.projects.epam.com:8081"
        static String RAW_URL = "http://ci.epm-ctc.projects.epam.com:8081/service/rest/beta/components?repository=raw-artifacts"
        static String NEXUS_RAW_PATH = NEXUS_URL + "/repository/raw-artifacts/"
        static String NEXUS_RELEASE_PATH = NEXUS_URL + "/repository/releases/"
    }

    class Paths {
        static String DIFFERENCE_DB_DIR="Scripts/difference_db/"
            }

    class MSTeams {
        static String OFFICE365_TEST="https://outlook.office.com/webhook/240218d9-8acb-4ac3-a4ad-462a6b1f1613@b41b72d0-4e9f-4c26-8a69-f949f367c91d/JenkinsCI/d1d90b3222544339811f6c1741f44a0b/ad1c7055-6ecf-44cd-a59e-7f65222119bd"
    }

    class Git {
        static String API_URL = "git@github.com:borlasadk/evenOdd.git"
        static String API_CRED_ID = "JenkinsSSH"
    }



    enum Environment {
        TST1('tst1.epm-ctc.projects.epam.com'),
        TST3('tst3.epm-ctc.projects.epam.com'),
        TST5('tst5.epm-ctc.projects.epam.com'),
        PUBLIC('epmctc-public.minsk.epam.com');

        Environment(String address) {
            this.address = address
        }

        final String address
    }



    enum RawArtifact {
        DIFFERENCE_DB('DIFFERENCE', 'difference')


        RawArtifact(String name, String code){
            this.name = name
            this.code = code
        }

        final String name
        final String code
    }

    enum DB {
        TST1(
                'ecsc0010601d.epam.com',
                'CTCTST1'
        ),
        TST3(
                'ecsc00106830.epam.com',
                'CTCTST3'
        ),
        TST5(
                'ecsc00106838.epam.com',
                'CTCTST5'
        ),
        PUBLIC(
                'ecsc00103df9.epam.com',
                'CTCPUB'
        );

        DB(
                String address,
                String oracleTNS
        ) {
            this.address = address
            this.oracleTNS = oracleTNS
        }

        final String address
        final String oracleTNS
    }
}
