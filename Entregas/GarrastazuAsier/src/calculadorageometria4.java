
import java.util.Scanner;

class CalculadoraGeometria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] historialFiguras = new String[20];
        double[] historialAreas = new double[20];
        double[] historialPerimetrosVolumenes = new double[20];
        int indiceHistorial = 0;

        final double PI = 3.14159;

        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        while (true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int opcionFigura = scanner.nextInt();

            if (opcionFigura == 5) {
                System.out.println("Historial de Calculos");
                double areaTotal = 0;

                for (int i = 0; i < indiceHistorial; i++) {
                    System.out.println(
                        (i + 1) + ". " + historialFiguras[i] +
                        " -> Area: " + historialAreas[i] +
                        ", Perimetro/Volumen: " + historialPerimetrosVolumenes[i]
                    );
                    areaTotal += historialAreas[i];
                }

                System.out.println("Area total acumulada: " + areaTotal);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            boolean calculoExitoso = false;

            if (opcionFigura == 1) { // Círculo
                System.out.print("Radio: ");
                double radio = scanner.nextDouble();

                if (radio > 0) {
                    double areaCirculo = PI * radio * radio;
                    double perimetroCirculo = 2 * PI * radio;

                    System.out.println("Area: " + areaCirculo);
                    System.out.println("Perimetro: " + perimetroCirculo);

                    calculoExitoso = true;

                    if (indiceHistorial < 20) {
                        historialFiguras[indiceHistorial] = "Circulo";
                        historialAreas[indiceHistorial] = areaCirculo;
                        historialPerimetrosVolumenes[indiceHistorial] = perimetroCirculo;
                        indiceHistorial++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }

            } else if (opcionFigura == 2) { // Rectángulo
                System.out.print("Base: ");
                double base = scanner.nextDouble();
                System.out.print("Altura: ");
                double altura = scanner.nextDouble();

                if (base > 0 && altura > 0) {
                    double areaRectangulo = base * altura;
                    double perimetroRectangulo = 2 * (base + altura);

                    System.out.println("Area: " + areaRectangulo);
                    System.out.println("Perimetro: " + perimetroRectangulo);

                    calculoExitoso = true;

                    if (indiceHistorial < 20) {
                        historialFiguras[indiceHistorial] = "Rectangulo";
                        historialAreas[indiceHistorial] = areaRectangulo;
                        historialPerimetrosVolumenes[indiceHistorial] = perimetroRectangulo;
                        indiceHistorial++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }

            } else if (opcionFigura == 3) { // Triángulo
                System.out.print("Lado 1: ");
                double x = scanner.nextDouble();
                System.out.print("Lado 2: ");
                double y = scanner.nextDouble();
                System.out.print("Lado 3: ");
                double z = scanner.nextDouble();

                if (x > 0 && y > 0 && z > 0 &&
                    x + y > z &&
                    x + z > y &&
                    y + z > x ) {

                    double semiperimetro = (x  + y + z) / 2;
                    double areaTriangulo = Math.sqrt(
                        semiperimetro *
                        (semiperimetro - x ) *
                        (semiperimetro - y) *
                        (semiperimetro - z)
                    );
                    double perimetroTriangulo = x  + y + z;

                    System.out.println("Area: " + areaTriangulo);
                    System.out.println("Perimetro: " + perimetroTriangulo);

                    calculoExitoso = true;

                    if (indiceHistorial < 20) {
                        historialFiguras[indiceHistorial] = "Triangulo";
                        historialAreas[indiceHistorial] = areaTriangulo;
                        historialPerimetrosVolumenes[indiceHistorial] = perimetroTriangulo;
                        indiceHistorial++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }

            } else if (opcionFigura == 4) { // Cilindro
                System.out.print("Radio: ");
                double radio = scanner.nextDouble();
                System.out.print("Altura: ");
                double altura = scanner.nextDouble();

                if (radio > 0 && altura > 0) {
                    double areaBase = PI * radio * radio;
                    double areaLateral = 2 * PI * radio * altura;
                    double areaTotal = 2 * areaBase + areaLateral;
                    double volumen = areaBase * altura;

                    System.out.println("Area Superficial: " + areaTotal);
                    System.out.println("Volumen: " + volumen);

                    calculoExitoso = true;

                    if (indiceHistorial < 20) {
                        historialFiguras[indiceHistorial] = "Cilindro";
                        historialAreas[indiceHistorial] = areaTotal;
                        historialPerimetrosVolumenes[indiceHistorial] = volumen;
                        indiceHistorial++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }

            } else {
                System.out.println("Opcion no valida");
            }

            if (calculoExitoso) {
                System.out.println("Calculo completado.");
            }
        }

        scanner.close();
    }
}