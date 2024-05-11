package stepDefinitions.API_Steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class ApiSteps {
    private String body;
    private Response response;

    @Dado("um json de uma api")
    public void um_json_de_uma_api() {
        body = "{\"username\": \"admin\"," +
                " \"password\": \"password\"}";
    }

    @Quando("enviou esse json")
    public void enviou_esse_json() {
        RestAssured.baseURI = "https://tranquil-cove-07655-38b519d38c2f.herokuapp.com";
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/login");
    }
    @Então("entao devo validar sua resposta")
    public void entao_devo_validar_sua_resposta() {
        response.then()
                .statusCode(201)
                .body("token", Matchers.notNullValue());

        System.out.println(response.jsonPath().getString("token"));
        System.out.println(response.prettyPrint());
        //se eu quiser extrair o token e guardar e depois usar em outro teste
        String token = response.jsonPath().getString("token");
    }
}
