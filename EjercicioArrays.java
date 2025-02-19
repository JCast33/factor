
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class EjercicioArraysOriginal {
    
    public static void main(String[] args) {
        int numAlumnos = 40;
        //vector con las notas generadas
        Integer[] control = new Integer[numAlumnos];
		int[] listaClase;
		int[] practicas;
		float[] calificaciones;
		float[] estadistica;
        int indMaxNota, indMinNota;
        int postEval;
		double[] calif;
        //Genera notas random entre 1 y 10
        for(int i=0; i < control.length; i++){
            control[i] = (int)(Math.random()*11);
        }
     
        //buscamos al mayor
        int maxNota = Integer.MIN_VALUE; 
        for (int i = 0; i < control.length; i++) {
            int notaActual = control[i];
            if (notaActual > maxNota) {
                maxNota = notaActual; 
            }
        }
        //buscamos al menor
        int minNota = Integer.MAX_VALUE; 
        for (int i = 0; i < control.length; i++) {
            int currentNota = control[i];
            if (currentNota < minNota) {
                minNota = currentNota; 
            }
        }
        //creamos una lista de los alumnos de la clase
        listaClase = new int[numAlumnos];
        for (int i = 0; i < numAlumnos; i++){
            listaClase[i] = i+1;
        }
        //Empezamos el uso de listas para facilitar la tarea de índices.
        List notas = Arrays.asList(control);
        indMinNota = notas.indexOf(minNota) + 1;
        indMaxNota = notas.indexOf(maxNota) + 1;

        //Comprobamos el resultado del ejercicio   
        System.out.println("Mínimo es: " + minNota);
        System.out.println("Máximo es: " + maxNota);
        System.out.println("Indice del mínimo es : " + indMinNota);
        System.out.println("Indice del máximo es : " + indMaxNota);
        System.out.println("Lista de clase :" + Arrays.toString(listaClase));
        System.out.println("Array de Notas :" + notas);
        
        //creamos el array de notas "practicas"
        practicas = new int[numAlumnos];
        for(int i=0; i < practicas.length; i++){
            practicas[i] = (int)(Math.random()*11);
        }
        //Creamos el vector calificaciones
        calificaciones = new float[numAlumnos];
        for(int i = 0; i<control.length; i++){
            calificaciones[i] = (((float) control[i] + (float) practicas[i])/ 2);
        }
        System.out.println("Prácticas      :" + Arrays.toString(practicas));
        System.out.println("Calificaciones :" + Arrays.toString(calificaciones));
        
        //Sacamos la estadística de calificaciones
        //hacemos un array de 10 para la estadística.
        estadistica = new float[10];
      
        for (int i=0; i<10; i++){
            float count = 0;
            float sum = 0;
            for (int j=0; j<control.length; j++){
                if ((i < calificaciones[j]) && ((i+1) >= calificaciones[j] )) {
                    sum += calificaciones[j];
                    count += 1;
                }
            }
            if (count != 0){
                estadistica[i] = ( (float)count / numAlumnos);
            }else{ estadistica[i] = 0;}
            double sol = (Math.round(estadistica[i] * 10000.0)) / 100.0;
            System.out.println("Estadística nota tramo <=" 
                + (i+1) + " = " 
                + sol + "%");
        }
        //Aprobados y suspensos
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];

        IntStream.range(0, numAlumnos).forEach(i -> {
            if (calificaciones[i] < 5) {
                aprobados[i] = i;
            } else {
                suspensos[i] = i;
            }
        });
        int countAprobados = (int) IntStream.of(aprobados).filter(n -> n != 0).count();
        int countSuspensos = (int) IntStream.of(suspensos).filter(n -> n != 0).count();

        System.out.println("Relación de aprobados por nº de lista: " + Arrays.toString(aprobados));
        System.out.println("Relación de suspensos por nº de lista: " + Arrays.toString(suspensos));
        
        //Resumen de aprobados y suspensos
        int[] a = Arrays.stream(aprobados).filter(n -> n != 0).toArray();//Usamos el filrto para quitar los 0
        int[] s = Arrays.stream(suspensos).filter(n -> n != 0).toArray();

        System.out.println("Resumen de aprobados por nº de lista: " + Arrays.toString(a));
        System.out.println("Resumen de suspensos por nº de lista: " + Arrays.toString(s));
    
        /*6. Suponer un vector de Calificaciones de tamaño 40 
        (máximo de alumnos por clase), pero que solo almacena las
        notas de 31 alumnos. Realizar un programa que permita insertar en
        la posición 4 del vector la calificación de un nuevo 
        alumno en clase al que supuestamente le corresponde como nota un 6.*/
        calif = new double[40];
        for (int j=0; j<31; j++){
            calif[j] = (int)(Math.random()*11);
        }
        System.out.println("Nota antigua alumno nº4: " + calif[3]); 
        calif[3] = 6;
        System.out.println("Nota nueva   alumno nº4: " + calif[3]);
    }
}
