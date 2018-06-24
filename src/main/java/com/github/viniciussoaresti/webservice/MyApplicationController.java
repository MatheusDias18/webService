/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.viniciussoaresti.webservice;
/**
 *
 * @author veneceo
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * Root resource (exposed at "myresource" path)
 */
/*
Pronto, como eu tinha dito, esse path aqui (que vem
depois do caminho da aplicação (vide @ApplicationPath)
é o caminho que eu dou pra chegar nessa classe, que,
como instruído abaixo, produz um texto ("Olá Mundo").
Você acessa essa resposta, no meu caso, pelo endereço:
http://localhost:8084/webService/meuwebservice
Ou seja, http://localhost:8084/webService é o projeto,
o "/" (webService"/"meuwebservice) o caminho da aplicação
que definimos lá no @ApplicationPath, e o "meuwebservice"
é o retorno do método olaMundo(), que é executado pois
definimos o caminho "meuwebservice" para esta classe
abaixo.
*/
@Path("meuwebservice")
public class MyApplicationController {
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }
    /*
    Ele só queria isso, um olá mundo, funcionando pra próxima aula.
    Porém, fiz os seguintes métodos para fins de teste, tentando
    ilustrar qual serão os passos pra fazer o webservice completo,
    ou seja, a nota da unidade.
    Ao fazer outro método, sem definir um path, a aplicação crashou.
    Ou seja, creio que ao definir o path da classe, e ter um método sem path,
    dentro dele, ele é meio que a 'main'.
    Portanto, imaginemos agora que a classe chama 'calculadora', e possui
    os seguintes métodos:
    */
    @Path("soma")
    /*Acessamos esse método pelo caminho
    http://localhost:8084/webService/meuwebservice/soma */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String soma() {
        return Integer.toString(1+1);
    }
    @Path("diferenca")
    /*Acessamos esse método pelo caminho
   http://localhost:8084/webService/meuwebservice/diferenca */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String diferenca() {
        return Integer.toString(1-2);
    }
    @Path("multiplicacao")
    /*Acessamos esse método pelo caminho
    http://localhost:8084/webService/meuwebservice/multiplicacao */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String multiplicacao() {
        return Integer.toString(10*7);
    }
    @Path("divisao")
    /*Acessamos esse método pelo caminho
    http://localhost:8084/webService/meuwebservice/divisao */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String divisao() {
        return Double.toString(10/6);
    }
    
    /*
    Pra próxima aula, é interessante perguntar como fazer e treinar:
    -receber parâmetros pela url, ou algo semelhante
    -transformar arquivos em json e tal
    -qual o nível de complexidade que ele quer pra um 10
    -etc.
    */
}


