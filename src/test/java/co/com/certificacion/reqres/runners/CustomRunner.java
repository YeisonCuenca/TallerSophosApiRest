package co.com.certificacion.reqres.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "co.com.certificacion.reqres.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@CrearUsuario or @EliminarUser or @ObtenerUser")
public class CustomRunner {
}
