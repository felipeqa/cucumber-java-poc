package stepDefinitions.API_Steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    static {
        RestAssured.baseURI = "https://tranquil-cove-07655-38b519d38c2f.herokuapp.com";
    }

    private String body;
    private Response response;

    @Dado("um json de uma api")
    public void um_json_de_uma_api() {
        body = "{\"username\": \"admin\"," +
                " \"password\": \"password\"}";
    }

    @Quando("enviou esse json")
    public void enviou_esse_json() {
        response = given()
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

    @Dado("que eu faca um get na api")
    public void que_eu_faca_um_get_na_api() {
        response = given()
                .when()
                .get("/json_10");
    }

    @Então("devo validar o resultado")
    public void devo_validar_o_resultado() {
        Assert.assertEquals(response.body().jsonPath().getString("users.main[0].intro[0].primeira_camada[0].segunda_camada[0].terceira_camada[0][1][0].title_terceira_camada"),
                "cada vez mais difícil");
    }
}
