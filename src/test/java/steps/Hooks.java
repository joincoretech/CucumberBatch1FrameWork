package steps;


import  io.cucumber.java.Before;
import  io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {


    @Before
    public void start(){
        setUp();

    }

    @After
    public void end(Scenario scenario){
        byte [] pic;
        if (scenario.isFailed()){
            pic=takeScreeShot("failed/" + scenario.getName());
        }else {
            pic=takeScreeShot("passed/" +scenario.getName());
        }
        scenario.attach(pic, "image/png",scenario.getName());

        closBrowser();
    }
}
