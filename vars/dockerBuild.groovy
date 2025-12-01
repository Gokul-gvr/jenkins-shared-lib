import org.example.utils.Helpers

def call(String imageName) {
    def helper = new Helpers(this)
    helper.log("Building Docker image: ${imageName}")
    helper.checkDocker()

    stage('Docker Build') {
        sh "docker build -t ${imageName} ."
    }
}
