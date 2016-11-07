
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.spec.InvalidKeySpecException;

public class RMIManager implements InterfaceRmiCommunication {

    //Operational Classes
    private static Registry _registry;
    private static InterfaceRmiCommunication _stub;

    //Constructors
    public RMIManager(int rmiPort) throws IOException, InvalidKeySpecException, Exception {
        _registry = LocateRegistry.createRegistry(rmiPort);
        this._stub = (InterfaceRmiCommunication) UnicastRemoteObject.exportObject(this, 0);

        try {
            System.setProperty("java.security.policy", "java.policy");
            System.setSecurityManager(new RMISecurityManager());
            _registry.bind("rmiServer", _stub);
            System.out.println("Esperando peticiones del cliente...");
        } catch (RemoteException | AlreadyBoundException e) {
            System.out.println("Server exception: " + e.toString());
        }
    }

    @Override
    public Integer getSuma(int num1, int num2) throws RemoteException {
        return num1 + num2;
    }
    public Integer getResta(int num1, int num2) throws RemoteException{
        return num1 - num2;
    }
     public Integer getDivision(int num1, int num2) throws RemoteException{
        return num1 / num2;
    }
      public Integer getMultiplicacion(int num1, int num2) throws RemoteException{
        return num1 * num2;
    }
       public double getPotencia(double num1, double num2) throws RemoteException{
        return Math.pow(num1, num2);
    }
        public double getRaiz(double num1, double num2) throws RemoteException{
        return Math.sqrt(num2);
    }
    
}
