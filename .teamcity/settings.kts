import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.03"

project {

    vcsRoot(HttpsGithubComHoaxltExampleTeamcityRefsHeadsMaster1)

    buildType(Build1)
    buildType(Build)

    features {
        githubConnection {
            id = "PROJECT_EXT_3"
            displayName = "GitHub.com"
            clientId = "Hoaxlt"
            clientSecret = "credentialsJSON:5aa994ad-c389-44d6-96a5-c2b37837c4be"
        }
        githubConnection {
            id = "PROJECT_EXT_4"
            displayName = "GitHub.com (1)"
            clientId = "Ov23lieN4kR6Xr3aeDK4"
            clientSecret = "credentialsJSON:4f01cd94-8319-4f5f-a222-c52732be7e42"
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "Maven2"

            conditions {
                contains("teamcity.build.branch", "master")
            }
            goals = "clean deploy"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            userSettingsSelection = "settings.xml"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Build1 : BuildType({
    name = "Build (1)"

    vcs {
        root(HttpsGithubComHoaxltExampleTeamcityRefsHeadsMaster1)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object HttpsGithubComHoaxltExampleTeamcityRefsHeadsMaster1 : GitVcsRoot({
    name = "https://github.com/Hoaxlt/example-teamcity#refs/heads/master (1)"
    url = "https://github.com/Hoaxlt/example-teamcity"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "Hoaxlt"
        password = "credentialsJSON:76c2c5f9-de6a-46fe-aae1-dc76c7169693"
    }
})
