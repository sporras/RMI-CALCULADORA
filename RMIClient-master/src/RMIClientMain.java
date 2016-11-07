



public class RMIClientMain 
{
     public static void main(String[] args) 
    {
        try {
            RmiCommunicationClient wsc = new RmiCommunicationClient();

            int suma = wsc.getSuma(1, 1);
            int resta = wsc.getResta(5, 3);
            int div = wsc.getDivision(16, 2);
            int mul = wsc.getMultiplicacion(4, 3);
            double pot = wsc.getPotencia(4,2);
            double raiz = wsc.getRaiz(7, 64);
            
             System.out.println(" resultado de la suma por el servidor: " + suma);
             System.out.println(" resultado de la resta por el servidor: " + resta);
             System.out.println(" resultado de la division por el servidor: " + div);
             System.out.println(" resultado de la multiplicacion por el servidor: " + mul);
             System.out.println(" resultado de la potencia por el servidor: " + pot);
             System.out.println(" resultado de la raiz por el servidor: " + raiz);

     
        } catch (Exception ex) {
            ex.printStackTrace();
             System.err.println("Connection error the server is not responding.");
        }
    }
}
