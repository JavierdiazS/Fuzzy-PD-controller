import com.cyberbotics.webots.controller.Robot;
import com.cyberbotics.webots.controller.PositionSensor;
import com.cyberbotics.webots.controller.Motor;

/**
 *
 * @author Dante Sterpin
 */
 
public class Control_Steel extends Robot
{
    private final int timeStep=32;
    private PositionSensor encoderA[];
    private double sA[],dA[],vA[], sAnt[];
    private AgenteDifuso agente;
    private Motor arm[];
    
    public Control_Steel()
    {
        super();
        
        // Inicializa los sensores
        encoderA = new PositionSensor[7];
        for(int a=0; a<7; a++)
        {
            encoderA[a] = getPositionSensor("arm_"+(a+1)+"_joint_sensor");
            encoderA[a].enable(timeStep);
        }
        sA = new double[7];  // Posiciones sensadas
        sAnt = new double[7];
        // Inicializa los motores
        arm = new Motor[7];
        for(int m=0; m<7; m++)
        {
            arm[m] = getMotor("arm_"+(m+1)+"_joint");
            arm[m].setPosition(Double.POSITIVE_INFINITY);
            arm[m].setVelocity(0.0);
        }
        dA = new double[7];  // Posiciones deseadas
        vA = new double[7];  // Velocidades
        
        // Inicializa los agentes
        agente = new AgenteDifuso();
    }
    
    public void Ejecutar()
    {
        while (step(64) != -1)
        {
            // Lee los sensores   
            for(int a=0; a<7; a++)
            {
                sAnt[a] = sA[a];
                if(sAnt[a] == 0.0){
                  sAnt[a] = encoderA[a].getValue();              
                }
                //System.out.print("Anterior "+sAnt[a]+" ");
            }
            //System.out.print("\n");
            
            for(int a=0; a<7; a++)
            {
                sA[a] = encoderA[a].getValue();
                System.out.print(sA[a]+" ");
            }
            System.out.print("\n");
          
            dA[0] = 1.7;
            dA[1] = 0.0;
            dA[2] = 0.0;
            dA[3] = 1.5;
            dA[4] = 0.0;
            dA[5] = 0.0;
            dA[6] = 0.0;
            
            // Decide la actuación
            vA = agente.DecisionMaking(dA,sA,sAnt);
            
            for(int a=0; a<7; a++)
            {
                //System.out.print(vA[a]+" ");   
            }
            //System.out.print("\n");
            
            // Mueve los motores
            for(int m=0; m<7; m++)
            {
                arm[m].setVelocity(vA[m]);
            }
        };
        
        finalize();
    }
    
    public static void main(String[] args)
    {
        new Control_Steel().Ejecutar();
    }
}