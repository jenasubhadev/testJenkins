pipeline {

    agent any

    environment {
        list_of_repos = 'abc,def,ghi'
    }

    stages {
        stage('Read Repository') {
            steps {
                script {
                    for (repo in list_of_repos.split(","))
                    {
                        println("${repo}")
                    }
                }
            }
        }
        stage('Reading properties from properties file') {
            steps {
                script {
                    def props = readProperties file: 'extravars.properties'
                    env.list_of_repo = props.list_of_repos
                    for (repo in list_of_repo.split(","))
                    {
                        println("${repo}")
                    }
                }
            }

        }

    }

}