package co.com.certificacion.reqres.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/crear_user.feature",
        glue = "co.com.certificacion.reqres.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@CrearUsuario")
public class CrearUserRunner {
}
