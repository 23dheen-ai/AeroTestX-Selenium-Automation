pipeline {

    agent any

    parameters {

        choice(
            name: 'BROWSER',
            choices: [
                'chrome',
                'firefox',
                'edge'
            ],
            description: 'Browser for UI tests'
        )

        choice(
            name: 'SUITE',
            choices: [
                'smoke',
                'regression',
                'api',
                'database',
                'full',
                'ErrorValidation'
            ],
            description: 'TestNG suite'
        )
    }

    stages {

        stage('Checkout') {

            steps {
                checkout scm
            }
        }

        stage('Environment Check') {

            steps {

                bat 'java -version'

                bat 'mvn -version'

                bat 'git --version'
            }
        }

        stage('Run Tests') {

            steps {

                bat """
                mvn clean test ^
                -P{SUITE} ^
                -Dbrowser=${BROWSER}
                """
            }
        }
    }

    post {

        always {

            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: 'target/surefire-reports/**',
                allowEmptyArchive: true
            )

            archiveArtifacts(
                artifacts: 'logs/**',
                allowEmptyArchive: true
            )

            archiveArtifacts(
                artifacts: 'screenshots/**',
                allowEmptyArchive: true
            )
        }

        success {

            echo 'AeroTestX execution completed successfully.'
        }

        failure {

            echo 'AeroTestX execution failed.'
        }
    }
}