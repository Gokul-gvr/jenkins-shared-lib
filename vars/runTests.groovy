def call() {
    stage('Run Tests') {
        sh "docker run --rm my-app-image pytest tests/"
    }
}
