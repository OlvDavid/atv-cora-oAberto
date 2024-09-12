package org.example;

import org.example.applications.ProdutoApplication;
import org.example.entities.Cidade;
import org.example.facade.ProdutoFacade;
import org.example.repositories.ProdutoRepository;
import org.example.services.ProdutoService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Console
{
    private static ProdutoRepository produtoRepository;
    private static ProdutoService produtoService;
    private static ProdutoApplication produtoApplication;
    private static ProdutoFacade produtoFacade;
    private static Scanner scanner;


    public static void resolverDependencias() {
        produtoRepository = new ProdutoRepository();
        produtoService = new ProdutoService();
        produtoApplication = new ProdutoApplication(produtoRepository, produtoService);
        produtoFacade = new ProdutoFacade(produtoApplication);
        scanner = new Scanner(System.in);
    }

    public static void inicializarProdutos() {
        produtoFacade.adicionar(new Cidade(1, "Bahia", "C:\\Users\\thezu\\IdeaProjects\\ProjetoDDD1\\src\\main\\resources\\images\\download.png", 075));
        produtoFacade.adicionar(new Cidade(2, "Pernambuco", "C:\\Users\\thezu\\IdeaProjects\\ProjetoDDD1\\src\\main\\resources\\images\\Pernambuco.jpeg", 81));
    }

    public static void listarProdutos() {
        System.out.println("Id    | Nome    | DDD");

        ArrayList<Cidade> cidades = produtoFacade.buscarTodos();

        cidades.forEach(c ->{
            System.out.println(c.getId()+"   |    " +c.getDescricao() + "  |    " + c.getDdd());
        });
    }

    public static void cadastrarCidade(){
        System.out.println("Informe o ID da Estado: ");
        int id = scanner.nextInt();

        System.out.println("Informe o nome do Estado: ");
        String nome = scanner.next();

        System.out.println("Informe o DDD do Estado: ");
        int ddd = scanner.nextInt();

        System.out.println("Informe o caminho da imagem do Estado: ");
        String imagem = scanner.next();

        Cidade cidade = new Cidade(id, nome, imagem, ddd);
        produtoFacade.adicionar(cidade);
    }

    public static void exibirMenu(){
        System.out.println("\n1 - Novo estado");
        System.out.println("2 - Atualizar estado");
        System.out.println("3 - Listar estados");
        System.out.println("4 - Buscar estado pelo ID");
        System.out.println("5 - Remover estado");
        System.out.println("6 - Sair");

    }

    public static int solicitarInputUsuario() {
        System.out.println("Informe a opção do menu desejado: ");
        return scanner.nextInt();
    }

    private static void atualizarCidade(){
        System.out.println("Informe o ID do Estado: ");
        int id = scanner.nextInt();

        System.out.println("Informe a nova descrição do Estado: ");
        String descricao = scanner.next();

        System.out.println("Informe o novo DDD do Estado: ");
        int ddd = scanner.nextInt();

        System.out.println("Informe o novo caminho da Imagem do Estado: ");
        String imagem = scanner.next();

        Cidade cidade = new Cidade(id, descricao, imagem, ddd);
        produtoFacade.atualizarCidade(id, cidade);
    }

    public static void removerCidade(){
        System.out.println("Informe o ID do estado que deseja remover: ");
        int id = scanner.nextInt();

        produtoFacade.remover(id);
    }

    public static void buscarCidade(){
        System.out.println("Informe o ID do estado que deseja buscar: ");
        int id = scanner.nextInt();

        Cidade cidade = produtoFacade.buscarPorId(id);

        if (cidade != null) {

            System.out.println("Cidade encontrada: ");
            System.out.println("ID: " + cidade.getId());
            System.out.println("Nome: " + cidade.getDescricao());
            System.out.println("DDD: " + cidade.getDdd());
            System.out.println("Caminho da Imagem: " + cidade.getImagem());
        } else {

            System.out.println("Cidade com ID " + id + " não encontrada.");
        }
    }


    public static void rodar(){
        int opcaoMenu = 0;

        do{
            exibirMenu();
            opcaoMenu = solicitarInputUsuario();
            switch (opcaoMenu) {
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    atualizarCidade();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    buscarCidade();
                    break;
                case 5:
                    removerCidade();
                    break;

            }
        }while(opcaoMenu != 6);
    }

    public static void main( String[] args ) {
        resolverDependencias();
        inicializarProdutos();
        rodar();
    }
}
