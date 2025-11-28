package com.exemplo.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Caminho para os arquivos .feature
    glue = "com.exemplo.steps",              // Pacote onde estão os step definitions
    plugin = {
        "pretty",                           // Saída formatada no console
        "html:target/cucumber-reports.html",// Relatório HTML
        "json:target/cucumber.json"         // Relatório JSON
    },
    monochrome = true,                       // Saída mais legível no consoleq
    dryRun = false,                          // true para validar os steps sem executá-los
    tags = "@login"                     // Executa apenas cenários com essa tag
)
public class RunCucumberTest {
    // Classe de execução dos testes Cucumber
}
