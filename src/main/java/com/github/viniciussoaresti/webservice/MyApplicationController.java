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
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }

    /*
    A nota da unidade é fazer um crud funcionando. Com ou sem BD.
    Ao fazer outro método, sem definir um path, a aplicação crashou.
    Ou seja, creio que ao definir o path da classe, e ter um método sem path,
    dentro dele, ele é meio que a 'main'.
    Portanto, imaginemos agora que a classe chama 'calculadora', e possui
    os seguintes métodos:
     */
    @Path("soma")
    /*Acessamos esse método pelo caminho
    http://localhost:porta/webService/meuwebservice/soma */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String soma() {
        return Integer.toString(1 + 1);
    }

    @Path("diferenca")
    /*Acessamos esse método pelo caminho
   http://localhost:porta/webService/meuwebservice/diferenca */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String diferenca() {
        return Integer.toString(1 - 2);
    }

    @Path("multiplicacao")
    /*Acessamos esse método pelo caminho
    http://localhost:porta/webService/meuwebservice/multiplicacao */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String multiplicacao() {
        return Integer.toString(10 * 7);
    }

    @Path("divisao")
    /*Acessamos esse método pelo caminho
    http://localhost:porta/webService/meuwebservice/divisao */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String divisao() {
        return Double.toString(10 / 6);
    }

    @Path("parametros")
    /*Acessamos esse método pelo caminho
    http://localhost:porta/webService/meuwebservice/parametros */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    /*Esse QueryParam é o parametro que utilizaremos depois,
    sendo passado assim: http://localhost:porta/nome-projeto/
    meuwebservice/parametros/query?nome=Leonardo */
    public String parametros(@QueryParam("nome") String nomeUsuario){
        return "Olá " + nomeUsuario;
    }

    @Path("json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornoJson() {
        Pessoa pessoa = new Pessoa("leonardo");
        String json = new Gson().toJson(pessoa).toString();
        /*Esse é o código que Léo forneceu:
        return new Response.status(Response.Status.OK.entity)(jsonCriado).build();
        Porém peguei o daqui:
        https://stackoverflow.com/questions/4687271/jax-rs-how-to-return-json-and-http-status-code-together
        */
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    /*@Path("cadastrar")
    Acessamos esse método pelo caminho
    http://localhost:porta/webService/meuwebservice/parametros
    @POST
    @Produces(MediaType.TEXT_HTML)
    /*Esse QueryParam é o parametro que utilizaremos depois,
    sendo passado assim: http://localhost:porta/nome-projeto/
    meuwebservice/parametros/query?nome=Leonardo
    public String cadastrar(@QueryParam("nome") String nome) {
        Pessoa p = new Pessoa(nome);
        pessoas.add(p);
        return "Pessoa cadastrada.";
    }
    */
    
    /*
    Pra próxima aula, é interessante perguntar como fazer e treinar:
    -qual o nível de complexidade que ele quer pra um 10
    -etc.
     */
}
