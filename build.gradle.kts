import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
	kotlin("kapt") version "1.9.21"

}

group = "com.ke"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")

	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.5")

	implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.3.0")

	val graalVersion = "21.1.0"
	implementation ("org.graalvm.sdk:graal-sdk:$graalVersion")
	implementation ("org.graalvm.js:js:$graalVersion")
	// necessary to integrate with legacy ScriptEngine based implementation
	implementation ("org.graalvm.js:js-scriptengine:$graalVersion")

	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
	implementation("com.squareup.moshi:moshi:1.15.0")
	kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")

	implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
	implementation("com.squareup.okhttp3:okhttp")
	implementation("com.squareup.okhttp3:logging-interceptor")
	implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
	implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
