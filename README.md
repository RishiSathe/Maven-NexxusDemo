STEPS for Maven + Nexus workflow:
-----------------------------------
## 🚀 Steps to Deploy Artifacts to Nexus
### 1. Install Maven (On **Killer Koda**) verify:
$ apt isntall mvn  and   $ mvn -v

### 2. Clone the Git Repository
$ git clone https://github.com/RishiSathe/Maven-NexxusDemo.git
$ cd Maven-NexxusDemo

### 3. Run Nexus in a Docker Container
$ docker run -d -p 8081:8081 --name nexus sonatype/nexus3
Access Nexus at:  
`http://localhost:8081`

### 4. Configure Maven Settings
Create or edit `~/.m2/settings.xml` with Nexus credentials:
```xml
<settings>
  <servers>
    <server>
      <id>nexus-releases</id>
      <username>admin</username>
      <password>your-admin-password</password>
    </server>
    <server>
      <id>nexus-snapshots</id>
      <username>admin</username>
      <password>your-admin-password</password>
    </server>
  </servers>
</settings>
```

---

### 5. Run Maven Commands (from project folder with `pom.xml`)
```bash
mvn validate
mvn clean install   # Cleans old files and installs to ~/.m2
mvn deploy          # Deploys artifacts to Nexus repository
```

---

### 6. Configure `pom.xml`
- **Snapshot vs Release**:
```xml
<groupId>com.example</groupId>
<artifactId>welcome-app</artifactId>
<version>1.0-SNAPSHOT</version>   <!-- Change to 1.0 for RELEASE -->
<packaging>war</packaging>
```

- **Distribution Management**:
```xml
<distributionManagement>
  <repository>
    <id>nexus-releases</id>
    <url>http://localhost:8081/repository/maven-releases/</url>
  </repository>
  <snapshotRepository>
    <id>nexus-snapshots</id>
    <url>http://localhost:8081/repository/maven-snapshots/</url>
  </snapshotRepository>
</distributionManagement>
```

---

## ✅ Summary
- Install Maven → Clone repo → Run Nexus container.  
- Configure `settings.xml` with credentials.  
- Use `mvn clean install` and `mvn deploy` to push artifacts.  
- Control snapshot vs release via `pom.xml` version and distribution management.  

---
