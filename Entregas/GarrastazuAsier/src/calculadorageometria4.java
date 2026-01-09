import java.util.Scanner;

class calculadoraGeometria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] hist_f = new String[20];
        double[] area = new double[20];
        double[] perimetro = new double[20];
        int hist_idx = 0;
        double numeroPi = 3.14159;
        
        
        System.out.println("Calculadora Geometrica - Areas y Perimetros");

        do{
            System.out.println("[1] Circulo");
            System.out.println("[2] Rectangulo");
            System.out.println("[3] Triangulo");
            System.out.println("[4] Cilindro");
            System.out.println("[5] Ver historial y Salir");
            System.out.print("Seleccione figura: ");
            int x = sc.nextInt();

            if (x == 5) {
                System.out.println("Historial de Calculos");
                double total_area = 0;
                
                for (int i = 0; i < hist_idx; i++) {
                    System.out.println((i+1) + ". " + hist_f[i] + " -> Area: " + area[i] + ", Perimetro/Volumen: " + perimetro[i]);
                    total_area += area[i];
                }
                System.out.println("Area total acumulada: " + total_area);
                System.out.println("Gracias por usar la calculadora.");
                break;
            }

            double Radio = 0;
            double z = 0;
            boolean f = false;

            if (x == 1) {
                System.out.print("Radio: ");
                Radio = sc.nextDouble();
                if (Radio > 0) {
                    z = numeroPi * Radio * Radio;
                    double p = 2 * numeroPi * Radio;
                    System.out.println("Area: " + z);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Circulo";
                        area[hist_idx] = z;
                        perimetro[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Radio invalido");
                }
            } else if (x == 2) {
                System.out.print("Base: ");
                Radio = sc.nextDouble();
                System.out.print("Altura: ");
                z = sc.nextDouble();
                if (Radio > 0 && z > 0) {
                    double a = Radio * z;
                    double p = 2 * (Radio + z);
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Rectangulo";
                        area[hist_idx] = a;
                        perimetro[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else if (x == 3) {
                System.out.print("Lado 1: ");
                y = sc.nextDouble();
                System.out.print("Lado 2: ");
                z = sc.nextDouble();
                System.out.print("Lado 3: ");
                double w = sc.nextDouble();
                if (y > 0 && z > 0 && w > 0 && (y + z > w && y + w > z && z + w > y)) {
                    double s = (y + z + w) / 2;
                    double a = Math.sqrt(s * (s - y) * (s - z) * (s - w));
                    double p = y + z + w;
                    System.out.println("Area: " + a);
                    System.out.println("Perimetro: " + p);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Triangulo";
                        area[hist_idx] = a;
                        perimetro[hist_idx] = p;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Lados invalidos o no forman un triangulo");
                }
            } else if (x == 4) {
                System.out.print("Radio: ");
                y = sc.nextDouble();
                System.out.print("Altura: ");
                z = sc.nextDouble();
                
                
                if (y > 0 && z > 0) {
                    double area_base = 3.14159 * y * y;
                    double area_lateral = 2 * 3.14159 * y * z;
                    double area_total = 2 * area_base + area_lateral;
                    double vol = area_base * z;
                    System.out.println("Area Superficial: " + area_total);
                    System.out.println("Volumen: " + vol);
                    f = true;
                    if(hist_idx < 20) {
                        hist_f[hist_idx] = "Cilindro";
                        area[hist_idx] = area_total;
                        perimetro[hist_idx] = vol;
                        hist_idx++;
                    }
                } else {
                    System.out.println("Dimensiones invalidas");
                }
            } else {
                System.out.println("Opcion no valida");
            }

            if (f) {
                System.out.println("Calculo completado.");
            }
        sc.close();
        while (true) { 
        }
    }
