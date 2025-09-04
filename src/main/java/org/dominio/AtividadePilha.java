package org.dominio;

import java.util.Scanner;


public class AtividadePilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Histórico de Navegação");
            System.out.println("2 - Desfazer Operações");
            System.out.println("3 - Editor de Texto");
            System.out.println("S - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine().toUpperCase();

            switch (opcao) {
                case "1":
                    historico(sc);
                    break;
                case "2":
                    desfazer(sc);
                    break;
                case "3":
                    editor(sc);
                    break;
                case "S":
                    System.out.println("Encerrando programa geral.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Exercício 1
    private static void historico(Scanner sc) {
        Pilha historico = new Pilha(10);
        System.out.println("\n=== Histórico de Navegação ===");
        while (true) {
            System.out.print("Digite um site (número), VOLTAR ou SAIR: ");
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.equals("SAIR")) break;
            else if (entrada.equals("VOLTAR")) {
                if (!historico.estaVazia()) {
                    int removido = historico.remover();
                    System.out.println("Voltando, removido site: " + removido);
                } else System.out.println("Histórico vazio.");
            } else {
                int site = Integer.parseInt(entrada);
                historico.adicionar(site);
                System.out.println("Acessou site: " + site);
            }
        }
    }

    // Exercício 2
    private static void desfazer(Scanner sc) {
        Pilha comandos = new Pilha(10);
        System.out.println("\n=== Desfazer Operações ===");
        while (true) {
            System.out.print("Digite um comando (número), DESFAZER ou SAIR: ");
            String entrada = sc.nextLine().toUpperCase();

            if (entrada.equals("SAIR")) break;
            else if (entrada.equals("DESFAZER")) {
                if (!comandos.estaVazia()) {
                    int removido = comandos.remover();
                    System.out.println("Desfeito comando: " + removido);
                } else System.out.println("Nenhum comando para desfazer.");
            } else {
                int comando = Integer.parseInt(entrada);
                comandos.adicionar(comando);
                System.out.println("Executado comando: " + comando);
            }
        }
    }

    // Exercício 3
    private static void editor(Scanner sc) {
        Pilha texto = new Pilha(50);
        System.out.println("\n=== Editor de Texto ===");
        while (true) {
            System.out.print("Digite um caractere, BACKSPACE ou ENTER: ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("ENTER")) {
                System.out.print("Texto final: ");
                while (!texto.estaVazia()) {
                    System.out.print(texto.remover());
                }
                System.out.println("\nEncerrando editor.");
                break;
            } else if (entrada.equalsIgnoreCase("BACKSPACE")) {
                if (!texto.estaVazia()) {
                    char removido = texto.remover();
                    System.out.println("Removido: " + removido);
                } else System.out.println("Nada para remover.");
            } else {
                char c = entrada.charAt(0);
                texto.adicionar((int) c);
            }
        }
    }
}
