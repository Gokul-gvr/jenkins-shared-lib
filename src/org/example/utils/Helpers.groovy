package org.example.utils

class Helpers implements Serializable {

    def steps

    Helpers(steps) {
        this.steps = steps
    }

    /**
     * Prints a formatted log message with a prefix.
     */
    def log(String message) {
        steps.echo "[JENKINS-HELPER] ${message}"
    }

    /**
     * Validates that required environment variables are set.
     */
    def validateEnvVars(List<String> requiredVars) {
        requiredVars.each { var ->
            if (!steps.env."${var}") {
                throw new RuntimeException("Missing required environment variable: ${var}")
            }
        }
    }

    /**
     * Executes a shell command and returns the output.
     */
    def runShell(String command) {
        return steps.sh(script: command, returnStdout: true).trim()
    }

    /**
     * Checks if Docker is installed and available.
     */
    def checkDocker() {
        try {
            def version = runShell("docker --version")
            log("Docker is available: ${version}")
        } catch (Exception e) {
            throw new RuntimeException("Docker is not installed or not available in PATH.")
        }
    }
}
