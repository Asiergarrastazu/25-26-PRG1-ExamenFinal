import java.util.Scanner;

class CalculadoraGeometria {

    static final double PI = 3.14159;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] historialFiguras = new String[20];
        double[] historialAreas = new double[20];
        double[] historialPerimetrosVolumenes = new double[20];
        int[] indiceHistorial = {0};

        while (true) {
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                calcularCirculo(scanner, historialFiguras, historialAreas, historialPerimetrosVolumenes, indiceHistorial);
            } else if (opcion == 2) {
                calcularRectangulo(scanner, historialFiguras, historialAreas, historialPerimetrosVolumenes, indiceHistorial);
            } else if (opcion == 3) {
                calcularTriangulo(scanner, historialFiguras, historialAreas, historialPerimetrosVolumenes, indiceHistorial);
            } else if (opcion == 4) {
                calcularCilindro(scanner, historialFiguras, historialAreas, historialPerimetrosVolumenes, indiceHistorial);
            } else if (opcion == 5) {
                mostrarHistorial(historialFiguras, historialAreas, historialPerimetrosVolumenes, indiceHistorial[0]);
                break;
            } else {
                System.out.println("Opcion no valida");
            }
        }
        scanner.close();
    }

    static void calcularCirculo(Scanner scanner, String[] historialFiguras, double[] historialAreas,
        double[] historialPerimetrosVolumenes, int[] indiceHistorial) {
        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        if (radio > 0) {
            double area = PI * radio * radio;
            double perimetro = 2 * PI * radio;
            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);
            if (indiceHistorial[0] < 20) {
                historialFiguras[indiceHistorial[0]] = "Circulo";
                historialAreas[indiceHistorial[0]] = area;
                historialPerimetrosVolumenes[indiceHistorial[0]] = perimetro;
                indiceHistorial[0]++;
            }
            System.out.println("Calculo completado.");
        } else {
            System.out.println("Radio invalido");
        }
    }

    static void calcularRectangulo(Scanner scanner, String[] historialFiguras, double[] historialAreas,
        double[] historialPerimetrosVolumenes, int[] indiceHistorial) {
        System.out.print("Base: ");
        double base = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        if (base > 0 && altura > 0) {
            double area = base * altura;
            double perimetro = 2 * (base + altura);

            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);

            if (indiceHistorial[0] < 20) {
                historialFiguras[indiceHistorial[0]] = "Rectangulo";
                historialAreas[indiceHistorial[0]] = area;
                historialPerimetrosVolumenes[indiceHistorial[0]] = perimetro;
                indiceHistorial[0]++;
            }
            System.out.println("Calculo completado.");
        } else {
            System.out.println("Dimensiones invalidas");
        }
    }

    static void calcularTriangulo(Scanner scanner, String[] historialFiguras, double[] historialAreas,
        double[] historialPerimetrosVolumenes, int[] indiceHistorial) {
        System.out.print("Lado 1: ");
        double x = scanner.nextDouble();
        System.out.print("Lado 2: ");
        double y = scanner.nextDouble();
        System.out.print("Lado 3: ");
        double z = scanner.nextDouble();

        if (x > 0 && y > 0 && z > 0 && x + y > z && x + z > y && y + z > x) {
            double s = (x + y + z) / 2;
            double area = Math.sqrt(s * (s - x) * (s - y) * (s - z));
            double perimetro = x + y + z;

            System.out.println("Area: " + area);
            System.out.println("Perimetro: " + perimetro);

            if (indiceHistorial[0] < 20) {
                historialFiguras[indiceHistorial[0]] = "Triangulo";
                historialAreas[indiceHistorial[0]] = area;
                historialPerimetrosVolumenes[indiceHistorial[0]] = perimetro;
                indiceHistorial[0]++;
            }
            System.out.println("Calculo completado.");
        } else {
            System.out.println("Lados invalidos o no forman un triangulo");
        }
    }

    static void calcularCilindro(Scanner scanner, String[] historialFiguras, double[] historialAreas,
        double[] historialPerimetrosVolumenes, int[] indiceHistorial) {
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

            if (indiceHistorial[0] < 20) {
                historialFiguras[indiceHistorial[0]] = "Cilindro";
                historialAreas[indiceHistorial[0]] = areaTotal;
                historialPerimetrosVolumenes[indiceHistorial[0]] = volumen;
                indiceHistorial[0]++;
            }
            System.out.println("Calculo completado.");
        } else {
            System.out.println("Dimensiones invalidas");
        }
    }

    static void mostrarHistorial(String[] historialFiguras, double[] historialAreas,
        double[] historialPerimetrosVolumenes, int indiceHistorial) {
        double areaTotal = 0;
        System.out.println("Historial de Calculos");
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
    }
}