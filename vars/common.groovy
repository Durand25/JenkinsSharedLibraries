def call(String stageName){
  def mavenHome = tool name: 'maven3.9.6'
 
  if ("${stageName}" == "Build")
     {
       
       //sh "mvn clean package"
       sh "${mavenHome}/bin/mvn package"
       sh "echo 'running JUnit-test-cases' "
      sh "echo 'testing must passed to create artifacts ' "
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       //sh "mvn clean sonar:sonar"
       sh "${mavenHome}/bin/mvn sonar:sonar"
       sh "echo CodeQualityAnalysis completed"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       //sh "mvn clean deploy"
       sh "${mavenHome}/bin/mvn deploy"
       sh "echo artifacts uploaded successfully"
          sh "echo I am now a Build and Release Engineer"
          sh "echo Build and release completed"
     }
}
