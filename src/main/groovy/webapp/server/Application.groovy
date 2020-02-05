package webapp

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
        info = @Info(
                title = "Hello World",
                version = "0.0",
                description = "My API",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
        )
)

@CompileStatic
class Application {
    static void main(String[] args) {
       // System.getenv().sort().each { property, value -> println "$property = $value"}
        String filename=System.properties['micronaut.config.files']
        File f= new File(filename)
        if( f.exists()){
            println "File found: $filename"
            println f.text
        } else{
            println "file not found : $filename"
        }
        Micronaut.run(Application)

    }
}