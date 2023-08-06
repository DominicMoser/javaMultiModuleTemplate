plugins {
    id("java")
}

dependencies{
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("dev.dmoser.utils:tests:0.15")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
