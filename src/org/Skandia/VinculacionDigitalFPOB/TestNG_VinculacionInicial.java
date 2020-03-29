package org.Skandia.VinculacionDigitalFPOB;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestNG_VinculacionInicial {

    WebDriver driver;
    // esta es una linea de comentario
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Este metodo de ejecuta antes de una suite de pruebas");
    }

    @BeforeTest
    public void  beforeTest(){
        System.out.println("Este metodo se ejecuta antes de las pruebas @test");
        String baseURL = "http://10.42.55.59:10039/wps/portal/PortalAsesoria/vinculaciondigitalpruebas/proceso-vinculacion";
        String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        String actualResult = "";
        String expectResult = "Vinculacion Digital Pruebas";
        actualResult = driver.getTitle();
        System.out.println(actualResult.contentEquals(expectResult)?"¡¡¡Prueba exitosa!!! TITULO DE LA PAGINA "+ actualResult : "¡¡¡Prueba fallida!!! TITULO DE LA PAGINA");
    }

    @BeforeClass
    public void  beforeClass(){
        System.out.println("Este metodo se ejecuta antes de la clase");
    }

    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("Este metodo se ejecuta antes de cada metodo de prueba @test");
        try {
        driver.findElement(By.xpath("//button[text()='ME QUIERO AFILIAR']")).click();
        System.out.println("¡¡¡Prueba exitosa!!! Boton ME QUIERO AFILIAR");
        WebDriverWait botnmequieroafiliar = new WebDriverWait(driver,10);
        botnmequieroafiliar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ACEPTAR']")));
        driver.findElement(By.xpath("//button[text()='ACEPTAR']")).click();
        System.out.println("¡¡¡Prueba exitosa!!! Boton de la modal ACEPTAR");
        }catch (org.openqa.selenium.NoSuchElementException Exception){
            System.out.println("¡¡¡No se encontro el objeto, prueba fallida!!!");
        }
    }

    @Test
    public void testCase1(){
        System.out.println("Caso de prueba 1");
        try {
            WebDriverWait botnaceptar = new WebDriverWait(driver,30);
            botnaceptar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gridRadios1']")));
            driver.findElement(By.xpath("//label[@for='gridRadios1']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Radio Boton VINCULACION INICIAL");
            //Lista desplegable
            WebDriverWait listadesplegabletipodoc = new WebDriverWait(driver,10);
            listadesplegabletipodoc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            Select drpTipo = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            drpTipo.selectByVisibleText("Cédula de ciudadanía");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");
            //Caja de texto
            WebElement NumeroDocumento = driver.findElement(By.xpath("//input[@formcontrolname='documento']"));
            NumeroDocumento.sendKeys("1045982360");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NUMERO DE DOCUMENTO");
            //Boton Iniciar
            WebDriverWait botoniniciar = new WebDriverWait(driver,30);
            botoniniciar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='INICIAR']")));
            driver.findElement(By.xpath("//button[text()='INICIAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton INICIAR");
            //Caja de texto primer nombre
            WebDriverWait listadesplegableorigenfondo = new WebDriverWait(driver,60);
            listadesplegableorigenfondo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='primerNombre']")));
            WebElement PrimerNombre = driver.findElement(By.xpath("//input[@formcontrolname='primerNombre']"));
            PrimerNombre.sendKeys("Andrés");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER NOMBRE");
            //Caja de texto segundo nombre
            WebElement SegundoNombre = driver.findElement(By.xpath("//input[@formcontrolname='segundoNombre']"));
            SegundoNombre.sendKeys("Mauricio");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO NOMBRE");
            //Caja de texto primer apellido
            WebElement PrimerApellido = driver.findElement(By.xpath("//input[@formcontrolname='primerApellido']"));
            PrimerApellido.sendKeys("Buitrago");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER APELLIDO");
            //Caja de texto segundo apellido
            WebElement SegundoApellido = driver.findElement(By.xpath("//input[@formcontrolname='segundoApellido']"));
            SegundoApellido.sendKeys("Correal");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO APELLIDO");
            //Caja de texto fecha de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']")).click();
            WebElement FechaEXP = driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']"));
            FechaEXP.sendKeys("2011-11-19");
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
                System.out.println("Pregunta " + i + " OK");
                if (i == 1) {v1 = 0;v2 = 5;}
                else if (i==2){v1=20;v2=25;}
                else if (i==3){v1=30;v2=35;}
                else if (i==4){v1 = 40;v2 = 45;}
                else if (i==5){v1 = 50;v2 = 55;}
                for (int j = v1; j <= v2; j++) {
                    Boolean existe = false;
                    texto = driver.findElement(By.xpath("//label[@for='" + j + "']")).getText();
                    if (texto.equalsIgnoreCase("0")||
                            texto.equalsIgnoreCase("VALLE")||
                            texto.equalsIgnoreCase("19/11/2011")||
                            texto.equalsIgnoreCase("26-30")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de consumo con esta entidad actualmente")||
                            texto.equalsIgnoreCase("No tengo contratos, operaciones o créditos de leasing con la entidad")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de microcrédito con esta entidad actualmente")||
                            texto.equalsIgnoreCase("NO TENGO CUENTA DE AHORROS CON LA ENTIDAD")||
                            texto.equalsIgnoreCase("No tengo cuenta corriente con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjetas de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito de esa marca con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca VISA")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo crédito de vivienda con la entidad")||
                            texto.equalsIgnoreCase("No tengo crédito de vivienda")||
                            texto.equalsIgnoreCase("No tengo crédito de vehículo")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de vivienda con esta entidad actualmente")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca MASTERCARD")||
                            texto.equalsIgnoreCase("No tengo crédito de vehículo con la entidad")||
                            texto.equalsIgnoreCase("No tengo ningún crédito con esta entidad")||
                            texto.equalsIgnoreCase("No tengo productos con la cooperativa")||
                            texto.equalsIgnoreCase("Ninguna de las anteriores")||
                            texto.equalsIgnoreCase("NINGUNAANTERIORES")||
                            texto.equalsIgnoreCase("NINGUNO DE LOS ANTERIORES")||
                            texto.equalsIgnoreCase("NINGUNO")||
                            texto.equalsIgnoreCase("NO")){
                        driver.findElement(By.xpath("//label[@for='"+j+"']")).click();
                        driver.findElement(By.xpath("//b[text()='SIGUIENTE']")).click();
                        existe = true;
                    }
                    if(existe){break;}
                }
            }
            //Modal cuestionario correcto
            WebDriverWait modalcuestionariocorrecto = new WebDriverWait(driver,10);
            modalcuestionariocorrecto.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SIGUIENTE']")));
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton CUESTIONARIO CORRECTO");
            //Boton despues de el video
            JavascriptExecutor jst = (JavascriptExecutor) driver;
            jst.executeScript("$('#showContent').show(); ");
            WebDriverWait video = new WebDriverWait(driver,10);
            video.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SI']")));
            driver.findElement(By.xpath("//button[text()='SI']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton VIDEO");
            new WebDriverWait(driver,10).until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=' Cargando... ']"))));
            //Caja de texto fecha de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaNacimiento']")).click();
            System.out.println("YA LE DIO CLICK A LA FECHA DE NACIMIENTO");
            WebElement FechaNACI = driver.findElement(By.xpath("//input[@formcontrolname='fechaNacimiento']"));
            FechaNACI.sendKeys("1993-11-18");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE NACIMIENTO");
            //Caja de texto pais de nacimiento
            WebDriverWait paisNacimiento = new WebDriverWait(driver,30);
            paisNacimiento.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='paisNacimiento']")));
            driver.findElement(By.xpath("//input[@formcontrolname='paisNacimiento']")).click();
            WebElement paisNACI = driver.findElement(By.xpath("//input[@formcontrolname='paisNacimiento']"));
            paisNACI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PAIS DE NACIMIENTO");
            //Caja de texto departamento de nacimiento
            WebDriverWait depNacimiento = new WebDriverWait(driver,30);
            depNacimiento.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='depNacimiento']")));
            driver.findElement(By.xpath("//input[@formcontrolname='depNacimiento']")).click();
            WebElement departamentoNACI = driver.findElement(By.xpath("//input[@formcontrolname='depNacimiento']"));
            departamentoNACI.sendKeys("HUILA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE NACIMIENTO");
            //Caja de texto ciudad de nacimiento
            WebDriverWait ciudadNacimiento = new WebDriverWait(driver,30);
            ciudadNacimiento.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='ciudadNacimiento']")));
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadNacimiento']")).click();
            WebElement ciudadNACI = driver.findElement(By.xpath("//input[@formcontrolname='ciudadNacimiento']"));
            ciudadNACI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE NACIMIENTO");
            //Lista desplegable Nacionalidad
            Select nacionalidad = new Select(driver.findElement(By.xpath("//select[@formcontrolname='nacionalidad']")));
            nacionalidad.selectByVisibleText("Colombiano");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable NACIONALIDAD");
            //Caja de texto departamento de expedicion
            WebDriverWait depExpDocument = new WebDriverWait(driver,30);
            depExpDocument.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='depExpDocument']")));
            driver.findElement(By.xpath("//input[@formcontrolname='depExpDocument']")).click();
            WebElement departamentoEXP = driver.findElement(By.xpath("//input[@formcontrolname='depExpDocument']"));
            departamentoEXP.sendKeys("BOGOTA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE EXPEDICION");
            //Caja de texto ciudad de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadExpDocument']")).click();
            WebElement ciudadEXP = driver.findElement(By.xpath("//input[@formcontrolname='ciudadExpDocument']"));
            ciudadEXP.sendKeys("BOGOTA D.C.");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE EXPEDICION");
            //Lista desplegable genero
            Select genero = new Select(driver.findElement(By.xpath("//select[@formcontrolname='genero']")));
            genero.selectByVisibleText("Masculino");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable GENERO");
            //Boton Paso 1.1
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Caja de texto direccion
            WebElement direccion = driver.findElement(By.xpath("//input[@formcontrolname='direccionResidencia']"));
            direccion.sendKeys("Calle 102 # 70 G - 79");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DIRECCION");
            //Caja de texto pais de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='paisResidencia']")).click();
            WebElement paisRESI = driver.findElement(By.xpath("//input[@formcontrolname='paisResidencia']"));
            paisRESI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PAIS DE RESIDENCIA");
            //Caja de texto departamento de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='depResidencia']")).click();
            WebElement departamentoRESI = driver.findElement(By.xpath("//input[@formcontrolname='depResidencia']"));
            departamentoRESI.sendKeys("HUILA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE RESIDENCIA");
            //Caja de texto ciudad de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadResidencia']")).click();
            WebElement ciudadRESI = driver.findElement(By.xpath("//input[@formcontrolname='ciudadResidencia']"));
            ciudadRESI.sendKeys("NEIVA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE RESIDENCIA");
            //Caja de texto telefono fijo
            WebElement telefonofijo = driver.findElement(By.xpath("//input[@formcontrolname='telFijo']"));
            telefonofijo.sendKeys("4631848");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto TELEFONO FIJO");
            //Lista desplegable envio informacion
            Select envioINFO = new Select(driver.findElement(By.xpath("//select[@formcontrolname='envioInformacion']")));
            envioINFO.selectByVisibleText("Físico");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ENVIO INFORMACION");
            //Boton Paso 1.2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Lista desplegable estado civil
            Select estadocivil = new Select(driver.findElement(By.xpath("//select[@formcontrolname='estadoCivil']")));
            estadocivil.selectByVisibleText("Unión Libre");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ESTADO CIVIL");
            //Lista desplegable nivel estudios
            Select nivelestudios = new Select(driver.findElement(By.xpath("//select[@formcontrolname='nivelEstudios']")));
            nivelestudios.selectByVisibleText("Universitario");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable NIVEL ESTUDIOS");
            //Lista desplegable profesion
            Select profesion = new Select(driver.findElement(By.xpath("//select[@formcontrolname='profesion']")));
            profesion.selectByVisibleText("Técnico en desarrollo y mantenimiento de software");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable PROFESION");
            //Caja de texto personas a cargo
            WebElement personasacargo = driver.findElement(By.xpath("//input[@formcontrolname='personasCargo']"));
            personasacargo.sendKeys("0");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PERSONAS A CARGO");
            //Boton Paso 1.3
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Lista desplegable tipo trabajador
            Select tipotrabajador = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoTrabajador']")));
            tipotrabajador.selectByVisibleText("Dependiente");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE TRABAJADOR");
            //Lista desplegable ocupacion
            Select ocupacion = new Select(driver.findElement(By.xpath("//select[@formcontrolname='ocupacion']")));
            ocupacion.selectByVisibleText("Empleado");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable OCUPACION");
            //Caja de texto personas a cargo
            WebElement cargo = driver.findElement(By.xpath("//input[@formcontrolname='cargo']"));
            cargo.sendKeys("Lider tecnico");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CARGO");
            //Lista desplegable tipo documento empleador
            Select tipoDocumentoEMPL = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            tipoDocumentoEMPL.selectByVisibleText("Nit");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DOCUMENTO EMPLEADOR");
            //Caja de texto numero documento empleador
            WebElement documentoEMPL = driver.findElement(By.xpath("//input[@formcontrolname='numeroDocumento']"));
            documentoEMPL.sendKeys("900073190");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CARGO");
            //Boton Paso 2.1
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 2 - Información Laboral");
            //Caja de texto nombre empleador
            WebElement nombreEMPL = driver.findElement(By.xpath("//input[@formcontrolname='razonSocial']"));
            nombreEMPL.sendKeys("AGENCIA DE ADUANAS GRUPO LOGISTICO ADUAN");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NOMBRE EMPLEADOR");
            //Lista desplegable tipo documento empleador
            Select tipoEMPL = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoEmpresa']")));
            tipoEMPL.selectByVisibleText("Privada");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO EMPRESA");
            //Caja de texto nombre empleador
            WebElement direccionEMPL = driver.findElement(By.xpath("//input[@formcontrolname='direccion']"));
            direccionEMPL.sendKeys("Avenida 19 # 109A 30");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DIRECCION EMPLEADOR");
            //Caja de texto pais de empledor
            driver.findElement(By.xpath("//input[@formcontrolname='pais']")).click();
            WebElement paisEMPL = driver.findElement(By.xpath("//input[@formcontrolname='pais']"));
            paisEMPL.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PAIS DE EMPLEADO");
            //Caja de texto departamento de empledor
            driver.findElement(By.xpath("//input[@formcontrolname='dep']")).click();
            WebElement departamentoEMPL = driver.findElement(By.xpath("//input[@formcontrolname='dep']"));
            departamentoEMPL.sendKeys("ANTIOQUIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE EMPLEADO");
            //Caja de texto ciudad de empledor
            driver.findElement(By.xpath("//input[@formcontrolname='ciudad']")).click();
            WebElement ciudadEMPL = driver.findElement(By.xpath("//input[@formcontrolname='ciudad']"));
            ciudadEMPL.sendKeys("MEDELLIN");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE EMPLEADO");
            //Caja de texto telefono fijo empledor
            WebElement telefonofijoEMPL = driver.findElement(By.xpath("//input[@formcontrolname='telFijo']"));
            telefonofijoEMPL.sendKeys("4631848");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto TELEFONO FIJO EMPLEADO");
            //Caja de texto correo empledor
            WebElement correoEMPL = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
            correoEMPL.sendKeys("omoutentelgy25@skandia.com.co");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CORREO EMPLEADO");
            //Caja de texto fecha de vinculacion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaVinculacion']")).click();
            WebElement FechaVIN = driver.findElement(By.xpath("//input[@formcontrolname='fechaVinculacion']"));
            FechaVIN.sendKeys("2019-02-01");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE VINCULACION");
            //Boton Paso 2.2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 2 - Información Laboral");
            //Lista desplegable tipo documento empleador
            Select salariointegral = new Select(driver.findElement(By.xpath("//select[@formcontrolname='salarioIntegral']")));
            salariointegral.selectByVisibleText("No");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable SALARIO INTEGRAL");
            //Caja de texto ingresos mensuales
            WebElement ingresosmensuales = driver.findElement(By.xpath("//input[@formcontrolname='ingresosMensuales']"));
            ingresosmensuales.sendKeys("2850000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto INGRESOS MENSUALES");
            //Caja de texto IBC
            WebElement ibc = driver.findElement(By.xpath("//input[@formcontrolname='ingresoBaseCotizacion']"));
            ibc.sendKeys("2850000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto IBC");
            //Caja de texto egresos
            WebElement egresos = driver.findElement(By.xpath("//input[@formcontrolname='egresos']"));
            egresos.sendKeys("1620000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto EGRESOS");
            //Boton otros ingresos
            driver.findElement(By.xpath("//button[text()='NO']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton OTROS INGRESOS");
            //Caja de texto activos
            WebElement activos = driver.findElement(By.xpath("//input[@formcontrolname='totalActivos']"));
            activos.sendKeys("9650000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto ACTIVOS");
            //Caja de texto pasivos
            WebElement pasivos = driver.findElement(By.xpath("//input[@formcontrolname='totalPasivos']"));
            pasivos.sendKeys("6200000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PASIVOS");
            //Boton Paso 3
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 3 - Información Financiera");
            //Boton ¿Tienes relación con alguna de estas actividades: Política, Farándula, Prensa, Contratista Estatal, Fuerzas Militares, Líder Comunal y/o Deportista Profesional?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[1]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 1");
            //Boton ¿Manejas recursos públicos y/o campañas políticas?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[2]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 2");
            //Boton ¿Tienes algún familiar que esté relacionado con: Política, Farándula, Prensa, Contratista Estatal, Fuerzas Militares, Líder Comunal y/o Deportista Profesional?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[3]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 3");
            //Boton Paso 4
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 4 - Personas Expuestas Públicamente");
            //Boton beneficiaros
            driver.findElement(By.xpath("//button[text()='NO']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton BENEFICIARIOS");
            //Boton Paso 5
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 5 - Beneficiarios");
            //Boton Tratamiento de los datos utilizados por compañias Skandia
            driver.findElement(By.xpath("//button[text()='SI']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton TRATAMIENTO DE DATOS");
            //Boton Paso 6.1
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("Boton PASO 6 - Autorización para tratamiento de información personal");
            //Boton Relacionamiento estratégico
            driver.findElement(By.xpath("//button[text()='NO']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton RELACIONAMINETO ESTRATEGICO");
            //Boton Paso 6.2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 6 - Autorización para tratamiento de información personal");
            //Boton Resumen
            driver.findElement(By.xpath("//button[text()='CONFIRMAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton CONFIRMAR");
        }catch (org.openqa.selenium.NoSuchElementException Exception){
            System.out.println("¡¡¡No se encontro el objeto, prueba fallida!!!");
        }
    }

    @Test
    public void testCase2(){
        System.out.println("Caso de prueba 2");
        try {
            WebDriverWait botnaceptar = new WebDriverWait(driver,30);
            botnaceptar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='gridRadios1']")));
            driver.findElement(By.xpath("//label[@for='gridRadios1']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Radio Boton VINCULACION INICIAL");
            //Lista desplegable
            WebDriverWait listadesplegabletipodoc = new WebDriverWait(driver,10);
            listadesplegabletipodoc.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            Select drpTipo = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoDocumento']")));
            drpTipo.selectByVisibleText("Cédula de ciudadanía");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");
            //Caja de texto
            WebElement NumeroDocumento = driver.findElement(By.xpath("//input[@formcontrolname='documento']"));
            NumeroDocumento.sendKeys("1045982360");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NUMERO DE DOCUMENTO");
            //Boton Iniciar
            WebDriverWait botoniniciar = new WebDriverWait(driver,30);
            botoniniciar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='INICIAR']")));
            driver.findElement(By.xpath("//button[text()='INICIAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton INICIAR");
            //Caja de texto primer nombre
            WebDriverWait listadesplegableorigenfondo = new WebDriverWait(driver,60);
            listadesplegableorigenfondo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='primerNombre']")));
            WebElement PrimerNombre = driver.findElement(By.xpath("//input[@formcontrolname='primerNombre']"));
            PrimerNombre.sendKeys("Andrés");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER NOMBRE");
            //Caja de texto segundo nombre
            WebElement SegundoNombre = driver.findElement(By.xpath("//input[@formcontrolname='segundoNombre']"));
            SegundoNombre.sendKeys("Mauricio");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO NOMBRE");
            //Caja de texto primer apellido
            WebElement PrimerApellido = driver.findElement(By.xpath("//input[@formcontrolname='primerApellido']"));
            PrimerApellido.sendKeys("Buitrago");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PRIMER APELLIDO");
            //Caja de texto segundo apellido
            WebElement SegundoApellido = driver.findElement(By.xpath("//input[@formcontrolname='segundoApellido']"));
            SegundoApellido.sendKeys("Correal");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto SEGUNDO APELLIDO");
            //Caja de texto fecha de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']")).click();
            WebElement FechaEXP = driver.findElement(By.xpath("//input[@formcontrolname='fechaExp']"));
            FechaEXP.sendKeys("2011-11-19");
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
                System.out.println("Pregunta " + i + " OK");
                if (i == 1) {v1 = 0;v2 = 5;}
                else if (i==2){v1=20;v2=25;}
                else if (i==3){v1=30;v2=35;}
                else if (i==4){v1 = 40;v2 = 45;}
                else if (i==5){v1 = 50;v2 = 55;}
                for (int j = v1; j <= v2; j++) {
                    Boolean existe = false;
                    texto = driver.findElement(By.xpath("//label[@for='" + j + "']")).getText();
                    if (texto.equalsIgnoreCase("0")||
                            texto.equalsIgnoreCase("VALLE")||
                            texto.equalsIgnoreCase("19/11/2011")||
                            texto.equalsIgnoreCase("26-30")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de consumo con esta entidad actualmente")||
                            texto.equalsIgnoreCase("No tengo contratos, operaciones o créditos de leasing con la entidad")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de microcrédito con esta entidad actualmente")||
                            texto.equalsIgnoreCase("NO TENGO CUENTA DE AHORROS CON LA ENTIDAD")||
                            texto.equalsIgnoreCase("No tengo cuenta corriente con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjetas de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito de esa marca con la entidad")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca VISA")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito con la entidad")||
                            texto.equalsIgnoreCase("No tengo crédito de vivienda con la entidad")||
                            texto.equalsIgnoreCase("No tengo crédito de vivienda")||
                            texto.equalsIgnoreCase("No tengo crédito de vehículo")||
                            texto.equalsIgnoreCase("No estoy relacionado en ningún crédito de vivienda con esta entidad actualmente")||
                            texto.equalsIgnoreCase("No tengo tarjeta de crédito marca MASTERCARD")||
                            texto.equalsIgnoreCase("No tengo crédito de vehículo con la entidad")||
                            texto.equalsIgnoreCase("No tengo ningún crédito con esta entidad")||
                            texto.equalsIgnoreCase("No tengo productos con la cooperativa")||
                            texto.equalsIgnoreCase("Ninguna de las anteriores")||
                            texto.equalsIgnoreCase("NINGUNAANTERIORES")||
                            texto.equalsIgnoreCase("NINGUNO DE LOS ANTERIORES")||
                            texto.equalsIgnoreCase("NINGUNO")||
                            texto.equalsIgnoreCase("NO")){
                        driver.findElement(By.xpath("//label[@for='"+j+"']")).click();
                        driver.findElement(By.xpath("//b[text()='SIGUIENTE']")).click();
                        existe = true;
                    }
                    if(existe){break;}
                }
            }
            //Modal cuestionario correcto
            WebDriverWait modalcuestionariocorrecto = new WebDriverWait(driver,10);
            modalcuestionariocorrecto.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SIGUIENTE']")));
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton CUESTIONARIO CORRECTO");
            //Boton despues de el video
            JavascriptExecutor jst = (JavascriptExecutor) driver;
            jst.executeScript("$('#showContent').show(); ");
            WebDriverWait video = new WebDriverWait(driver,300);
            video.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SI']")));
            driver.findElement(By.xpath("//button[text()='SI']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton VIDEO");
            new WebDriverWait(driver,10).until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()=' Cargando... ']"))));
            //Caja de texto fecha de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='fechaNacimiento']")).click();
            WebElement FechaNACI = driver.findElement(By.xpath("//input[@formcontrolname='fechaNacimiento']"));
            FechaNACI.sendKeys("1993-11-18");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE NACIMIENTO");
            //Caja de texto pais de nacimiento
            driver.findElement(By.xpath("//input[@formcontrolname='paisNacimiento']")).click();
            WebElement paisNACI = driver.findElement(By.xpath("//input[@formcontrolname='paisNacimiento']"));
            paisNACI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PAIS DE NACIMIENTO");
            //Caja de texto departamento de nacimiento
            driver.findElement(By.xpath("//input[@formcontrolname='depNacimiento']")).click();
            WebElement departamentoNACI = driver.findElement(By.xpath("//input[@formcontrolname='depNacimiento']"));
            departamentoNACI.sendKeys("HUILA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE NACIMIENTO");
            //Caja de texto ciudad de nacimiento
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadNacimiento']")).click();
            WebElement ciudadNACI = driver.findElement(By.xpath("//input[@formcontrolname='ciudadNacimiento']"));
            ciudadNACI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE NACIMIENTO");
            //Lista desplegable Nacionalidad
            Select nacionalidad = new Select(driver.findElement(By.xpath("//select[@formcontrolname='nacionalidad']")));
            nacionalidad.selectByVisibleText("Colombiano");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable NACIONALIDAD");
            //Caja de texto departamento de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='depExpDocument']")).click();
            WebElement departamentoEXP = driver.findElement(By.xpath("//input[@formcontrolname='depExpDocument']"));
            departamentoEXP.sendKeys("BOGOTA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENASO 1 - Información ComplementariaTO DE EXPEDICION");
            //Caja de texto ciudad de expedicion
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadExpDocument']")).click();
            WebElement ciudadEXP = driver.findElement(By.xpath("//input[@formcontrolname='ciudadExpDocument']"));
            ciudadEXP.sendKeys("BOGOTA D.C.");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE EXPEDICION");
            //Lista desplegable genero
            Select genero = new Select(driver.findElement(By.xpath("//select[@formcontrolname='genero']")));
            genero.selectByVisibleText("Masculino");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable GENERO");
            //Boton Paso 1.1
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Caja de texto direccion
            WebElement direccion = driver.findElement(By.xpath("//input[@formcontrolname='direccionResidencia']"));
            direccion.sendKeys("Calle 102 # 70 G - 79");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DIRECCION");
            //Caja de texto pais de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='paisResidencia']")).click();
            WebElement paisRESI = driver.findElement(By.xpath("//input[@formcontrolname='paisResidencia']"));
            paisRESI.sendKeys("COLOMBIA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PAIS DE RESIDENCIA");
            //Caja de texto departamento de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='depResidencia']")).click();
            WebElement departamentoRESI = driver.findElement(By.xpath("//input[@formcontrolname='depResidencia']"));
            departamentoRESI.sendKeys("HUILA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DEPARTAMENTO DE RESIDENCIA");
            //Caja de texto ciudad de residencia
            driver.findElement(By.xpath("//input[@formcontrolname='ciudadResidencia']")).click();
            WebElement ciudadRESI = driver.findElement(By.xpath("//input[@formcontrolname='ciudadResidencia']"));
            ciudadRESI.sendKeys("NEIVA");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CIUDAD DE RESIDENCIA");
            //Caja de texto telefono fijo
            WebElement telefonofijo = driver.findElement(By.xpath("//input[@formcontrolname='telFijo']"));
            telefonofijo.sendKeys("4631848");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto TELEFONO FIJO");
            //Lista desplegable envio informacion
            Select envioINFO = new Select(driver.findElement(By.xpath("//select[@formcontrolname='envioInformacion']")));
            envioINFO.selectByVisibleText("Físico");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ENVIO INFORMACION");
            //Boton Paso 1.2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Lista desplegable estado civil
            WebDriverWait estadociviltiempo = new WebDriverWait(driver,20);
            estadociviltiempo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='estadoCivil']")));
            Select estadocivil = new Select(driver.findElement(By.xpath("//select[@formcontrolname='estadoCivil']")));
            estadocivil.selectByVisibleText("Divorciado");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable ESTADO CIVIL");
            //Lista desplegable nivel estudios
            Select nivelestudios = new Select(driver.findElement(By.xpath("//select[@formcontrolname='nivelEstudios']")));
            nivelestudios.selectByVisibleText("Universitario");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable NIVEL ESTUDIOS");
            //Lista desplegable profesion
            Select profesion = new Select(driver.findElement(By.xpath("//select[@formcontrolname='profesion']")));
            profesion.selectByVisibleText("Técnico en desarrollo y mantenimiento de software");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable PROFESION");
            //Caja de texto personas a cargo
            WebElement personasacargo = driver.findElement(By.xpath("//input[@formcontrolname='personasCargo']"));
            personasacargo.sendKeys("2");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PERSONAS A CARGO");
            //Boton Paso 1.3
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Lista desplegable tipo trabajador
            Select tipotrabajador = new Select(driver.findElement(By.xpath("//select[@formcontrolname='tipoTrabajador']")));
            tipotrabajador.selectByVisibleText("Independiente Obligatorio");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE TRABAJADOR");
            //Lista desplegable ocupacion
            Select ocupacion = new Select(driver.findElement(By.xpath("//select[@formcontrolname='ocupacion']")));
            ocupacion.selectByVisibleText("Independiente");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable OCUPACION");
            //Caja de texto cargo
            WebElement cargo = driver.findElement(By.xpath("//input[@formcontrolname='cargo']"));
            cargo.sendKeys("Lider tecnico");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto CARGO");
            //Boton Paso 2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 1 - Información Complementaria");
            //Lista desplegable salario integral
            Select salariointegral = new Select(driver.findElement(By.xpath("//select[@formcontrolname='salarioIntegral']")));
            salariointegral.selectByVisibleText("No");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable SALARIO INTEGRAL");
            //Caja de texto ingresos mensuales
            WebElement ingresosmensuales = driver.findElement(By.xpath("//input[@formcontrolname='ingresosMensuales']"));
            ingresosmensuales.sendKeys("2850000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto INGRESOS MENSUALES");
            //Caja de texto IBC
            WebElement ibc = driver.findElement(By.xpath("//input[@formcontrolname='ingresoBaseCotizacion']"));
            ibc.sendKeys("2850000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto IBC");
            //Caja de texto egresos
            WebElement egresos = driver.findElement(By.xpath("//input[@formcontrolname='egresos']"));
            egresos.sendKeys("1620000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto EGRESOS");
            //Boton otros ingresos
            driver.findElement(By.xpath("//button[text()='NO']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton OTROS INGRESOS");
            //Caja de texto activos
            WebElement activos = driver.findElement(By.xpath("//input[@formcontrolname='totalActivos']"));
            activos.sendKeys("9650000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto ACTIVOS");
            //Caja de texto pasivos
            WebElement pasivos = driver.findElement(By.xpath("//input[@formcontrolname='totalPasivos']"));
            pasivos.sendKeys("6200000");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto PASIVOS");
            //Boton Paso 3
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 3 - Información Financiera");
            //Boton ¿Tienes relación con alguna de estas actividades: Política, Farándula, Prensa, Contratista Estatal, Fuerzas Militares, Líder Comunal y/o Deportista Profesional?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[1]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 1");
            //Boton ¿Manejas recursos públicos y/o campañas políticas?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[2]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 2");
            //Boton ¿Tienes algún familiar que esté relacionado con: Política, Farándula, Prensa, Contratista Estatal, Fuerzas Militares, Líder Comunal y/o Deportista Profesional?
            driver.findElement(By.xpath("//*[@id=\"ini\"]/div[3]/app-form-paso-cuatro/div/div/div/div/div[3]/div/div[1]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton PEP 3");
            //Boton Paso 4
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 4 - Personas Expuestas Públicamente");
            //Boton beneficiaros
            driver.findElement(By.xpath("//button[text()='SI']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton BENEFICIARIOS");
            //PRIMER BENEFICIARIO
            //Caja de nombre
            WebElement nombres = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[1]/input"));
            nombres.sendKeys("Azul");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NOMBRES");
            //Caja de apellido
            WebElement apellidos = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[2]/input"));
            apellidos.sendKeys("Reyes");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto APELLIDOS");
            //Lista desplegable de tipoDocumento
            Select tipoDocumento = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[3]/select")));
            tipoDocumento.selectByVisibleText("Tarjeta de Identidad");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");
            //Caja de documento
            WebElement documento = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[4]/input"));
            documento.sendKeys("1022348920");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DOCUMENTO");
            //Caja de texto fecha de nacimeitno
            driver.findElement(By.xpath("//input[@formcontrolname='fechaNaci']")).click();
            WebElement fechanacimiento = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[5]/input"));
            fechanacimiento.sendKeys("2006-06-04");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE NACIMIENTO");
            //Lista desplegable genero
            Select generobene = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[6]/select")));
            generobene.selectByVisibleText("Femenino");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable GENERO");
            //Lista desplegable parentestco
            Select parentesco = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[1]/div[7]/select")));
            parentesco.selectByVisibleText("Hijo/Hija");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable PARENTESCO");
            //Boton otro beneficiario
            driver.findElement(By.xpath("//button[text()='Agregar Persona']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton AGREGAR PERSONA");
            //SEGUNDO BENEFICIARO
            //Caja de nombre
            WebElement nombres2 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[1]/input"));
            nombres2.sendKeys("Simon");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NOMBRES");
            //Caja de apellido
            WebElement apellidos2 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[2]/input"));
            apellidos2.sendKeys("Reyes");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto APELLIDOS");
            //Lista desplegable de tipoDocumento
            Select tipoDocumento2 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[3]/select")));
            tipoDocumento2.selectByVisibleText("Tarjeta de Identidad");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");
            //Caja de documento
            WebElement documento2 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[4]/input"));
            documento2.sendKeys("9711261505");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DOCUMENTO");
            //Caja de texto fecha de nacimeitno
            driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[5]/input")).click();
            WebElement fechanacimiento2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[5]/input"));
            fechanacimiento2.sendKeys("2018-08-01");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE NACIMIENTO");
            //Lista desplegable genero
            Select generobene2 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[6]/select")));
            generobene2.selectByVisibleText("Masculino");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable GENERO");
            //Lista desplegable parentestco
            Select parentesco2 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/div[7]/select")));
            parentesco2.selectByVisibleText("Hijo/Hija");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable PARENTESCO");
            //Boton otro beneficiario
            driver.findElement(By.xpath("//button[text()='Agregar Persona']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton AGREGAR PERSONA");
            //TERCER BENEFICIARO
            //Caja de nombre
            WebElement nombres3 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[1]/input"));
            nombres3.sendKeys("Paloma");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto NOMBRES");
            //Caja de apellido
            WebElement apellidos3 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[2]/input"));
            apellidos3.sendKeys("Reyes");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto APELLIDOS");
            //Lista desplegable de tipoDocumento
            Select tipoDocumento3 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[3]/select")));
            tipoDocumento3.selectByVisibleText("Tarjeta de Identidad");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable TIPO DE DOCUMENTO");
            //Caja de documento
            WebElement documento3 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[4]/input"));
            documento3.sendKeys("1015471399");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto DOCUMENTO");
            //Caja de texto fecha de nacimeitno
            driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[5]/input")).click();
            WebElement fechanacimiento3 = driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[5]/input"));
            fechanacimiento3.sendKeys("2006-06-04");
            System.out.println("¡¡¡Prueba exitosa!!! Caja de texto FECHA DE NACIMIENTO");
            //Lista desplegable genero
            Select generobene3 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[6]/select")));
            generobene3.selectByVisibleText("Femenino");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable GENERO");
            //Lista desplegable parentestco
            Select parentesco3 = new Select(driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[3]/div[7]/select")));
            parentesco3.selectByVisibleText("Hijo/Hija");
            System.out.println("¡¡¡Prueba exitosa!!! Lista desplegable PARENTESCO");
            //Boton eliminar beneficiario
            driver.findElement(By.xpath("/html/body/main/table/tbody/tr/td/table/tbody/tr/td/div/section/div/div[3]/div/app-root/app-datos-complementarios/div/div[3]/app-form-paso-cinco/div[2]/div/div/div/form/div[1]/div[2]/button")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton ELIMINAR");
            //Boton Paso 5
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 5 - Beneficiarios");
            //Boton Tratamiento de los datos utilizados por compañias Skandia
            driver.findElement(By.xpath("//button[text()='SI']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton TRATAMIENTO DE DATOS");
            //Boton Paso 6.1
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("Boton PASO 6 - Autorización para tratamiento de información personal");
            //Boton Relacionamiento estratégico
            driver.findElement(By.xpath("//button[text()='NO']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton RELACIONAMINETO ESTRATEGICO");
            //Boton Paso 6.2
            driver.findElement(By.xpath("//button[text()='SIGUIENTE']")).click();
            System.out.println("PASO 6 - Autorización para tratamiento de información personal");
            //Boton Resumen
            driver.findElement(By.xpath("//button[text()='CONFIRMAR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton CONFIRMAR");
        }catch (org.openqa.selenium.NoSuchElementException Exception){
            System.out.println("¡¡¡No se encontro el objeto, prueba fallida!!!");
        }
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Este metodo se ejecuta despues de cada metodo de prueba @test");
        try {
            //Boton Salir
            WebDriverWait salir = new WebDriverWait(driver, 30);
            salir.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='SALIR']")));
            driver.findElement(By.xpath("//button[text()='SALIR']")).click();
            System.out.println("¡¡¡Prueba exitosa!!! Boton SALIR");
        }catch (org.openqa.selenium.NoSuchElementException Exception){
            System.out.println("¡¡¡No se encontro el objeto, prueba fallida!!!");
        }
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Este metodo se ejecuta despues de la clase");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Este metodo se ejecuta despues de las pruebas @test");
        driver.close();
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("Este metodo de ejecuta despues de una suite de pruebas");
    }

}
