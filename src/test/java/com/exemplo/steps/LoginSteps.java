package com.exemplo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    WebDriver navegador;
    

    @Given("acesso o site saucedemo")
    public void acesso_o_site_saucedemo() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.get("https://www.saucedemo.com/");
    }

    @When("preencho o campo Login valido")
    public void preencho_o_campo_login_valido() throws InterruptedException {
        WebElement campo_login = navegador.findElement(By.id("user-name"));
        campo_login.click();
        campo_login.sendKeys("standard_user");
        Thread.sleep(2000);
    }

    @When("preencho o campo senha correta")
    public void preencho_o_campo_senha_correta() throws InterruptedException {
        WebElement campo_senha = navegador.findElement(By.id("password"));
        campo_senha.click();
        campo_senha.sendKeys("secret_sauce");
        Thread.sleep(2000);
    }

    @When("clico no botao de login")
    public void clico_no_botao_de_login() throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.id("login-button")).click();
    }

    @Then("realizo o login no site saucedemo")
    public void realizo_o_login_no_site_saucedemo() {
        WebElement btproduto1 = navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")); 
        if (btproduto1.isDisplayed()) {
            System.out.println("login realizado!");
            
        } else {
            System.out.println("login com erro!");
        }
    }

    @When("preencho o campo senha incorreta correta")
    public void preencho_o_campo_senha_incorreta_correta()  throws InterruptedException {
        WebElement campo_senha = navegador.findElement(By.id("password"));
        campo_senha.click();
        campo_senha.sendKeys("secret_sauce_erro");
            }

    @Then("valido a mensagem de erro")
    public void valido_a_mensagem_de_erro() throws InterruptedException {
        WebElement msg_erro = navegador.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));
        if(msg_erro.isDisplayed()){
            System.out.println("Erro no login!");
            Thread.sleep(1000);
            navegador.quit();
        }else{
            System.out.println("sem msg de erro no login");
        }
    }

    @When("seleciono o produto para compra")
    public void seleciono_o_produto_para_compra() {
        WebElement btproduto1 = navegador.findElement(By.id("add-to-cart-sauce-labs-backpack")); 
        btproduto1.click();
    }

    @When("clico no carrinho de compras")
    public void clico_no_carrinho_de_compras() throws InterruptedException {
        WebElement btCarrinhoCompra = navegador.findElement(By.id("shopping_cart_container"));
        btCarrinhoCompra.click();
        Thread.sleep(2000);
    }

    @When("verifico a lista de produtos desejados")
    public void verifico_a_lista_de_produtos_desejados() {  
        WebElement btRemoverProduto = navegador.findElement(By.id("remove-sauce-labs-backpack"));
        if (btRemoverProduto.isDisplayed()) {
            System.out.println("====>>>validado lista de produto!");
           
        } else {
            System.out.println("====>>>erro na lista de produto!");
        }
    }

    @When("clico no botao finalizar compras")
    public void clico_no_botao_finalizar_compras() {
        WebElement btCheckout = navegador.findElement(By.id("checkout"));
        btCheckout.click();
    }

    @When("preenhco as informações do cliente")
    public void preenhco_as_informações_do_cliente() throws InterruptedException {
        WebElement first_name = navegador.findElement(By.id("first-name"));
        WebElement last_name = navegador.findElement(By.id("last-name"));
        WebElement postal_code = navegador.findElement(By.id("postal-code"));
        WebElement btContinue = navegador.findElement(By.id("continue"));
        first_name.click();
        first_name.sendKeys("Test");
        last_name.click();
        last_name.sendKeys("Fusion");
        postal_code.click();
        postal_code.sendKeys("60000000");
        btContinue.click();
        Thread.sleep(2000);
    }

    @When("confiro o resumo da compra")
    public void confiro_o_resumo_da_compra() {
        WebElement btfinish = navegador.findElement(By.id("finish"));
        if (btfinish.isDisplayed()) {
            System.out.println("====>>>existe resumo da compra");
        }else{
            System.out.println("====>>>nao existe resumo da compra");
        }
    }

    @Then("finalizo a compra do produto")
    public void finalizo_a_compra_do_produto() throws InterruptedException {
        WebElement btfinish = navegador.findElement(By.id("finish"));
        btfinish.click();
        WebElement btcheckout_complete_container = navegador.findElement(By.id("checkout_complete_container")); 
        Thread.sleep(2000);
        if (btcheckout_complete_container.isDisplayed()) {
            System.out.println("====>>>compra completada!!!");
        }else{
            System.out.println("====>>>Error na compra!!!");     
        }
    }
}
