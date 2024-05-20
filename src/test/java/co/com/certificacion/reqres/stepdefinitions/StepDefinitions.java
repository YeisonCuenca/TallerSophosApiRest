package co.com.certificacion.reqres.stepdefinitions;

import co.com.certificacion.reqres.models.Data;
import co.com.certificacion.reqres.models.DatosUsuario;
import co.com.certificacion.reqres.models.GenericModel;
import co.com.certificacion.reqres.questions.*;
import co.com.certificacion.reqres.tasks.*;
import co.com.certificacion.reqres.utils.Constantes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StepDefinitions {
    DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String fechaActual = formateador.format(date);

    @Given("^que el usuario cuenta con la api reqres$")
    public void queElUsuarioCuentaConLaApiReqres() {
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(Constantes.URL_REQRES));
    }


    @When("^se realiza la peticion para listar usuarios$")
    public void seRealizaLaPeticionParaListarUsuarios() {
       OnStage.theActorInTheSpotlight().attemptsTo(ListarUsuarios.deApiReqres());
    }

    @Then("^la respuesta de la api presenta el codigo (.*)$")
    public void laRespuestaDeLaApiPresentaElCodigo(int codigoRespuesta) {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ObtenerCodigo.deRespuesta(), Matchers.equalTo(codigoRespuesta)));
    }

    @And("^en la respuesta debe presentar el campo llamado total con valor (.*)$")
    public void enLaRespuestaDebePresentarElCampoLlamadoTotalConValor(String valor) {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ObtenerValor.totalDeUsuarios(), Matchers.equalTo(valor)));
    }


    @When("^se envian los datos de usuario a crear$")
    public void seEnvianLosDatosDeUsuarioACrear(DatosUsuario data) {
        List<DatosUsuario> data2 = new ArrayList<>();
        data2.add(data);
       OnStage.theActorInTheSpotlight().attemptsTo(CrearUsuario.conApiReqres(data2));
    }

    @And("^en la respuesta la fecha de creacion debe ser la fecha actual$")
    public void enLaRespuestaLaFechaDeCreacionDebeSerLaFechaActual() {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ObtenerFecha.deCreacionUsuario(), Matchers.containsString(fechaActual)));
    }


    @When("^se realiza la consulta por id$")
    public void seRealizaLaConsultaPorId(List<GenericModel> id) {
       OnStage.theActorInTheSpotlight().attemptsTo(GetUser.infoById(id.get(0).getId()));
    }

    @And("^la respuesta de la api presenta la informacion del usuario$")
    public void laRespuestaDeLaApiPresentaLaInformacionDelUsuario(List<Data> infoUsuario) {
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(GetInfo.user(),
                Matchers.equalTo(infoUsuario.get(0).getId())));
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(actor -> actor.recall("emailUser"),
                Matchers.equalTo(infoUsuario.get(0).getEmail())));
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(actor -> actor.recall("firstNameUser"),
                Matchers.equalTo(infoUsuario.get(0).getFirst_name())));
       OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(actor -> actor.recall("lastNameUser"),
                Matchers.equalTo(infoUsuario.get(0).getLast_name())));
    }

    @When("^se realiza la consulta por id (.*)$")
    public void seRealizaLaConsultaPorId(String id) {
       OnStage.theActorInTheSpotlight().attemptsTo(GetUser.infoById(id));
    }

    //METODO DELETE
    @And("^el usuario envia la peticion para eliminar usuario$")
    public void elUsuarioEnviaLaPeticionParaEliminarUsuario() {
       OnStage.theActorInTheSpotlight().attemptsTo(EliminarUsuario.conApiReqres());
    }



}
