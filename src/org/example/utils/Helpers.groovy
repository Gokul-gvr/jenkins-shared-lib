package org.example.utils

class Helpers implements Serializable {

    def steps

    Helpers(steps) {
        this.steps = steps
    }

    def log(String message) {
        steps.echo "[HELPER] ${message}"
    }

    def validateEnvVars(List<String> vars) {
        vars.each { var ->
            if (!steps.env."${var}") {
                throw new RuntimeException("Missing required environment variable: ${var}")
            }
        }
    }

    def runShell(String command) {
        return steps.sh(script: command, returnStdout: true).trim()
    }

    def checkDocker() {
        try {
            def version = runShell("docker --version")
            log("Docker is available: ${version}")
        } catch (Exception e) {
            throw new RuntimeException("Docker is not installed or not available in PATH.")
        }
    }
}
