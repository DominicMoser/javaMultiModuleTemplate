plugins {
    id("java")
    id("maven-publish")
}

allprojects {
    group = "{{ group_id }}"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven {
            url = uri(findProperty("repositoryUrl") as String)
        }
    }

    pluginManager.withPlugin("java-library") {
        apply(plugin = "maven-publish")
        apply(plugin = "java")

        java {
            withJavadocJar()
            withSourcesJar()
            sourceCompatibility = JavaVersion.VERSION_{{ java_version }}
            targetCompatibility = JavaVersion.VERSION_{{ java_version }}
        }

        publishing {
            publications {
                create<MavenPublication>(project.name) {
                    artifactId = project.name
                    from(components["java"])
                }
            }
            repositories {
                maven {
                    url = uri(findProperty("repositoryUrl") as String)
                    credentials {
                        username = findProperty("repositoryUsername") as String
                        password = findProperty("repositoryPassword") as String
                    }
                }
            }
        }
    }
}

