pipeline {

    agent any

    parameters {
        string(name: "override_list_of_repo", defaultValue: "", trim: true, description: "Multiple Target Repositories for version upgrade")
    }
    stages {
        stage('Reading repositories from override list of target repositories') {
            when {
                expression { params.override_list_of_repo != "" }
            }
            steps {
                script {
                    for (repo in override_list_of_repo.split(","))
                    {
                        gke_version_upgrade(repo)
                    }
                }
            }
        }
        stage('Reading repositories from properties file') {
            when {
                expression { params.override_list_of_repo == "" }
            }
            steps {
                script {
                    def props = readProperties file: 'list_of_repo.properties'
                    env.list_of_repo = props.list_of_repos
                    for (repo in list_of_repo.split(","))
                    {
                        println("${repo}")
                    }
                }
            }

        }
        stage('Reading repositories from yaml file') {
            when {
                expression { params.override_list_of_repo == "" }
            }
            steps {
                script {
                    def props = readYaml file: 'manifest.yml'
                    echo "configVal: " + configVal
                    
                }
            }

        }

    }

}