package test;

import be.bstorm.akimts.test.calc.Calculatrice;
import be.bstorm.akimts.test.calc.CalculatriceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {

    private final Calculatrice calculatrice = new CalculatriceImpl();
    private Object rslt;
    private Object expected;

    @Given("addition de {int} et {int}")
    public void additionDeEt(int arg0, int arg1) {
        rslt = calculatrice.addition(arg0, arg1);
    }

    @When("Je demande si la reponse entière vaut {int}")
    public void jeDemandeSiLaReponseVaut(int arg0) {
        expected = arg0;
    }

    @Then("On devrait me dire oui")
    public void onDevraitMeDireOui() {
        Assertions.assertEquals(rslt, expected);
    }

    @Then("On devrait me dire non")
    public void onDevraitMeDireNon() {
        Assertions.assertNotEquals(rslt, expected);
    }


    @Given("division de {int} par {int}")
    public void division(int a, int b){
        rslt = calculatrice.division(a, b);
    }

    @When("Je demande si la reponse réelle vaut {double}")
    public void jeDemandeSiLaReponseVaut(double arg0) {
        expected = arg0;
    }
}
