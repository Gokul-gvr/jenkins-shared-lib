def call(String imageName) {
    stage('Deploy') {
        // Example: run container locally or deploy to ECS/K8s
        sh "docker run -d -p 8080:80 ${imageName}"
    }
}
