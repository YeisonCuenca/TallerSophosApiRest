package co.com.certificacion.reqres.stepdefinitions;

import co.com.certificacion.reqres.models.Data;
import co.com.certificacion.reqres.models.DatosUsuario;
import co.com.certificacion.reqres.models.GenericModel;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import java.util.Map;

public class Hooks {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        Actor yeison = OnStage.theActorCalled("Yeison");
    }

    @DataTableType
    public DatosUsuario userEntry(Map<String, String> entry) {
        DatosUsuario data = new DatosUsuario();
        data.setName(entry.get("name"));
        data.setJob(entry.get("job"));
        return data;
    }

    @DataTableType
    public GenericModel genericEntry(Map<String, String> entry) {
        GenericModel data = new GenericModel();
        data.setId(entry.get("id"));
        return data;
    }

    @DataTableType
    public Data dataEntry(Map<String, String> entry){
        Data data = new Data();
        data.setId(entry.get("id"));
        data.setEmail(entry.get("email"));
        data.setFirst_name(entry.get("first_name"));
        data.setLast_name(entry.get("last_name"));

        return data;
    }
}
