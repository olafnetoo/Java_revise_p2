package org.example;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        org.example.Client client = new org.example.Client();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        new Thread(client).start();
        while(true){
            client.send(reader.readLine());
        }

    }
}

/* MAIN SERVER
package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.listen();
    }
}
 */



/* POM
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.example</groupId>
        <artifactId>client</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>java_client</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
 */