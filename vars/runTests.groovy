def call(String imageName) {
    stage('Run Tests') {
        sh "docker run --rm ${imageName} pytest tests/"
    }
}
