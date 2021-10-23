package Application;

import Entities.funcionario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class application {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\ruben\\OneDrive\\Área de Trabalho\\java_files\\in.csv");
        List<funcionario> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sv = new Scanner(System.in);
        String[] object = null;


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                object = sc.nextLine().split(";");
                list.add(new funcionario(object[0], object[1], Double.parseDouble(object[2])));
                System.out.println("Nome:" +object[0]+ "Email:" + object[1] + "Salario" + object[2]);
                br.readLine();
            }

            System.out.println("Type a Salary to see the Email of peoples whose the salary is above:");
            Double maiorq = sv.nextDouble();
            System.out.println("Emails list:");
            List<String> emailsmq = list.stream().filter(funcionario -> funcionario.getSalario() > maiorq).map(funcionario -> funcionario.getEmail())
                    .sorted().collect(Collectors.toList());
            System.out.println(emailsmq);


            System.out.println("salary some of peoples who start with the letter 'M' :");
            Double somaSalario = list.stream().filter(funcionario -> funcionario.getNome().charAt(0) == 'M').map(funcionario -> funcionario.getSalario()).
                    reduce(Double.valueOf(0), Double::sum);
            System.out.println(somaSalario);



        } catch (IOException e) {
            System.out.println("File not found or can't be read");
        } finally {

            if (sc != null) {
                sc.close();
            }
        }
        sv.close();
    }
}