package com.leanfactory.challenge;

import com.leanfactory.challenge.objects.Surface;
import com.leanfactory.challenge.objects.Vehicle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class VehicleChallengeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VehicleChallengeApplication.class, args);
    }

    @Override
    public void run(String... args) {

        try{
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese el número de filas de la superficie:");
            int numRows = scanner.nextInt();
            System.out.println("Ingrese el número de columnas de la superficie:");
            int numCols = scanner.nextInt();
            Surface surface = new Surface(numRows, numCols);

            System.out.println("Ingrese la lista de comandos separados por ; (punto y coma):");
            scanner.nextLine(); // Consumir el salto de línea después de los números
            String[] commands = scanner.nextLine().split(";");

            Vehicle vehicle = new Vehicle(surface,numRows-1);
            for (String command : commands) {
                String[] parts = command.split(",");
                int numSteps = Integer.parseInt(parts[0]);
                char direction = parts[1].toUpperCase().charAt(0);
                if(!vehicle.move(numSteps, direction)){
                    break;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

