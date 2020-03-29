package org.Skandia.VinculacionDigitalFPOB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TrasladoAFP {

    public static void main(String[] args){
        //Instanciar un objeto WebDriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://10.42.55.59:10039/wps/portal/PortalAsesoria/vinculaciondigitalpruebas/";
        String actualResult = "";
        String expectResult = "Vinculacion Digital Pruebas";
        String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";

        //Donde se encuentra nuestro Driver
        System.setProperty("webdriver.chrome.driver",chromePath);

        //Abrir el navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navegar en la pagina
        driver.get(baseURL);

        //Obtener el titulo de la pagina
        actualResult = driver.getTitle();

        //Imprimir resualtado
        System.out.println(actualResult.contentEquals(expectResult)?"¡¡¡Prueba exitosa!!! TITULO DE LA PAGINA "+ actualResult : "¡¡¡Prueba fallida!!! TITULO DE LA PAGINA");

        try {
            //Dar clic opcion 1
            ///driver.findElement(By.linkText("Autorización Tratamiento de Datos Personales")).click();
            driver.findElement(By.xpath("//button[text()='ME QUIERO AFILIAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton ME QUIERO AFILIAR");
            WebDriverWait botnmequieroafiliar = new WebDriverWait(driver,10);
            botnmequieroafiliar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ACEPTAR']")));
            driver.findElement(By.xpath("//button[text()='ACEPTAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton de la modal ACEPTAR");
            WebDriverWait botnaceptar = new WebDriverWait(driver,30);
            botnaceptar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gridRadios2']")));
            driver.findElement(By.xpath("//label[@for='gridRadios2']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Radio Boton TRASLADO");

            //Lista desplegable
            WebDriverWait listadesplegabletipodoc = new WebDriverWait(driver,10);
            listadesplegabletipodoc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            Select drpTipo = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            drpTipo.selectByVisibleText("Cédula de ciudadanía");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");

            //Caja de texto
            WebElement NumeroDocumento = driver.findElement(By.xpath("//input[@formcontrolname='documento']"));
            NumeroDocumento.sendKeys("9771716");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NUMERO DE DOCUMENTO");

            //Boton Iniciar
            WebDriverWait botoniniciar = new WebDriverWait(driver,20);
            botoniniciar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='INICIAR']")));
            driver.findElement(By.xpath("//button[text()='INICIAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton INICIAR");

            //Lista desplegable
            WebDriverWait listadesplegableorigenfondo = new WebDriverWait(driver,40);
            listadesplegableorigenfondo.until(ExpectedConditions.visibilityOfElementLocated(By.id("fondoSelect")));
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Select ListaOrigen = new Select(driver.findElement(By.id("fondoSelect")));
            ListaOrigen.selectByVisibleText("FONDO DE PENSIONES PROTECCION S.A.");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ORIGEN DE FONDO DE PENSIONES");

            //Boton Bono pensional
            driver.findElement(By.id("siBonoPensional")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton de la modal BONO PENSIONAL");

            //Lista desplegable Entidad bono pensional
            Select ListaBonoPensional = new Select(driver.findElement(By.id("entidadSelect")));
            ListaBonoPensional.selectByVisibleText("CAJA NACIONAL DE PREVISION CAJANAL");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ENTIDAD BONO PENSIONAL");

            //Boton siguiente
            driver.findElement(By.id("siguiente")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton SIGUIENTE");

            //Caja de texto primer nombre
            WebElement PrimerNombre = driver.findElement(By.xpath("//input[@formcontrolname='primerNombre']"));
            PrimerNombre.sendKeys("Andrés");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER NOMBRE");

            //Caja de texto segundo nombre
            WebElement SegundoNombre = driver.findElement(By.xpath("//input[@formcontrolname='segundoNombre']"));
            SegundoNombre.sendKeys("Mauricio");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO NOMBRE");

            //Caja de texto primer apellido
            WebElement PrimerApellido = driver.findElement(By.xpath("//input[@formcontrolname='primerApellido']"));
            PrimerApellido.sendKeys("VILLALBA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER APELLIDO");

            //Caja de texto segundo apellido
            WebElement SegundoApellido = driver.findElement(By.xpath("//input[@formcontrolname='segundoApellido']"));
            SegundoApellido.sendKeys("Correal");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO APELLIDO");

            //Caja de texto fecha de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']")).click();
            WebElement FechaEXP = driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']"));
            FechaEXP.sendKeys("1986-02-20");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE EXPEDICION");

            //Caja de texto celular
            WebElement celular = driver.findElement(By.xpath("//input[@formcontrolname='celular']"));
            celular.sendKeys("3108097621");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CELULAR");

            //Caja de texto correo
            WebElement correo = driver.findElement(By.xpath("//input[@formcontrolname='correo']"));
            correo.sendKeys("omoutentelgy25@skandia.com.co");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CORREO");

            //Caja de texto confirmacion correo
            WebElement confirmacioncorreo = driver.findElement(By.xpath("//input[@formcontrolname='correoConfirm']"));
            confirmacioncorreo.sendKeys("omoutentelgy25@skandia.com.co");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CONFIRMACION CORREO");

            //Lista desplegable FP
            Select fp = new Select(driver.findElement(By.xpath("//select[@formcontrolname='asesoriaComercial']")));
            fp.selectByVisibleText("Si");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable FP");

            //Caja de texto confirmacion correo
            WebElement IDfp = driver.findElement(By.xpath("//input[@formcontrolname='codigoAgente']"));
            IDfp.sendKeys("3273");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto ID FP");

            //Lista desplegable nombre FP
            driver.findElement(By.xpath("//select[@formcontrolname='agentId']")).click();
            WebDriverWait tiempodeespera1 = new WebDriverWait(driver,60);
            tiempodeespera1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='3273']")));
            WebElement listanombrefp=driver.findElement(By.xpath("//select[@formcontrolname='agentId']"));
            Select nombrefp=new Select(listanombrefp);
            nombrefp.selectByValue("3273");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable NOMBRE FP");

            //Boton siguiente
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton SIGUIENTE");

            //Cuestionario primera pregunta
            WebDriverWait tiempodeesperacuestionario = new WebDriverWait(driver,60);
            tiempodeesperacuestionario.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='0']")));

            //Boolean reintentoscuestionario = false;
            //while (!reintentoscuestionario){
            String texto;
            Integer v1=0,v2=0;
            for (int i = 1; i <= 5; i += 1) {
                System.out.println("Pregunta: " + i);
                if (i == 1) {v1 = 0;v2 = 5;}
                else if (i==2){v1=20;v2=25;}
                else if (i==3){v1=30;v2=35;}
                else if (i==4){v1 = 40;v2 = 45;}
                else if (i==5){v1 = 50;v2 = 55;}
                for (int j = v1; j <= v2; j++) {
                    Boolean existe = false;
                    texto = driver.findElement(By.xpath("//label[@for='" + j + "']")).getText();
                    if (texto.equalsIgnoreCase("0")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de consumo con esta entidad actualmente")||
                            texto.equalsIgnoreCase("NO TENGO CUENTA DE AHORROS CON LA ENTIDAD")||
                            texto.equalsIgnoreCase("No tengo cuenta corriente con la entidad")||
                            texto.equalsIgnoreCase("Ninguna de las anteriores")||
                            texto.equalsIgnoreCase("No tengo tarjetas de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito de esa marca con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca VISA")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo crédito de vivienda con la entidad")||
                            texto.equalsIgnoreCase("NO")||
                            texto.equalsIgnoreCase("NINGUNO DE LOS ANTERIORES")||
                            texto.equalsIgnoreCase("NINGUNO")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca MASTERCARD")||
                            texto.equalsIgnoreCase("No tengo crédito de vehículo con la entidad")||
                            texto.equalsIgnoreCase("BOGOTA")||
                            texto.equalsIgnoreCase("No tengo ningún crédito con esta entidad")){
                        driver.findElement(By.xpath("//label[@for='"+j+"']")).click();
                        System.out.println("hola mundo hizo clic");
                        driver.findElement(By.xpath("//b[text()='SIGUIENTE']")).click();
                        System.out.println("¡¡¡Prueba exitosa!!! Boton SIGUIENTE");
                        existe = true;
                    }
                    if(existe){break;}
                }
            }
            //driver.findElement(By.xpath("//button[text()='ACEPTAR']")).click();
            driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.btn.btn-success.btn-block")).click();
            driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-fade.swal2-shown > div > div.swal2-actions > button.swal2-confirm.btn.btn-success.btn-block")).click();
            //driver.close();
        }catch (org.openqa.selenium.NoSuchElementException Exception){
            System.out.println("¡¡¡No se encontro el objeto, prueba fallida!!!");
        }
    }
}
