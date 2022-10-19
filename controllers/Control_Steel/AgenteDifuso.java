public class AgenteDifuso
{
    private double vA[];
    private double errorPasado[] = new double[7];
    private double errorPresente[] = new double[7];
    
    private double valorXderivada[] = new double[7];
    
    private double ErrorUno[][] = new double[][]{{-2.62,-0.6525,-0.1305,0,0.1305},
                                                 {-2.61,-0.1305,0,0.1305,0.6525},
                                                 {-0.6525,-0.1305,0,0.1305,2.61},
                                                 {-0.1305,0,0.1305,0.6525,2.62}};
    
    private double DerivadaUno[][] = new double[][]{{-5.23,-0.01044,-0.000522,0,0.000522},
                                                    {-5.22,-0.000522,0,0.000522,0.01044},
                                                    {-0.01044,-0.000522,0,0.000522,5.22},
                                                    {-0.000522,0,0.000522,0.01044,5.23}};
   
    private double ErrorDos[][] = new double[][]{{-2.53,-0.63,-0.126,0,0.126},
                                                 {-2.52,-0.126,0,0.126,0.63},
                                                 {-0.63,-0.126,0,0.126,2.52},
                                                 {-0.126,0,0.126,0.63,2.53}};
    
    private double DerivadaDos[][] = new double[][]{{-5.05,-0.013104,-0.000504,0,0.000504},
                                                    {-5.04,-0.000504,0,0.000504,0.013104},
                                                    {-0.013104,-0.000504,0,0.000504,5.04},
                                                    {-0.000504,0,0.000504,0.013104,5.05}};
    
    private double ErrorTres[][] = new double[][]{{-4.97,-1.24,-0.248,0,0.248},
                                                  {-4.96,-0.248,0,0.248,1.24},
                                                  {-1.24,-0.248,0,0.248,4.96},
                                                  {-0.248,0,0.248,1.24,4.97}};

    private double DerivadaTres[][] = new double[][]{{-9.93,-0.025792,-0.000992,0,0.000992},
                                                     {-9.92,-0.000992,0,0.000992,0.025792},
                                                     {-0.025792,-0.000992,0,0.000992,9.92},
                                                     {-0.000992,0,0.000992,0.025792,9.93}};
    
    private double ErrorCuatro[][] = new double[][]{{-2.62,-0.6525,-0.1305,0,0.1305},
                                                    {-2.61,-0.1305,0,0.1305,0.6525},
                                                    {-0.6525,-0.1305,0,0.1305,2.61},
                                                    {-0.1305,0,0.1305,0.6525,2.62}};
    
    private double DerivadaCuatro[][] = new double[][]{{-5.23,-0.013572,-0.000522,0,0.000522},
                                                       {-5.22,-0.000522,0,0.000522,0.013572},
                                                       {-0.013572,-0.000522,0,0.000522,5.22},
                                                       {-0.000522,0,0.000522,0.013572,5.23}};
    
    private double ErrorCinco[][] = new double[][]{{-4.15,-1.035,-0.207,0,0.207},
                                                   {-4.14,-0.207,0,0.207,1.035},
                                                   {-1.035,-0.207,0,0.207,4.14},
                                                   {-0.207,0,0.207,1.035,4.15}};
    
    private double DerivadaCinco[][] = new double[][]{{-8.29,-0.021528,-0.000828,0,0.000828},
                                                      {-8.28,-0.000828,0,0.000828,0.021528},
                                                      {-0.021528,-0.000828,0,0.000828,8.28},
                                                      {-0.000828,0,0.000828,0.021528,8.29}};
    
    private double ErrorSeis[][] = new double[][]{{-2.79,-0.695,-0.139,0,0.139},
                                                  {-2.78,-0.139,0,0.139,0.695},
                                                  {-0.695,-0.139,0,0.139,2.78},
                                                  {-0.139,0,0.139,0.695,2.79}};
    
    private double DerivadaSeis[][] = new double[][]{{-5.57,-0.014456,-0.000556,0,0.000556},
                                                     {-5.56,-0.000556,0,0.000556,0.014456},
                                                     {-0.014456,-0.000556,0,0.000556,5.56},
                                                     {-0.000556,0,0.000556,0.014456,5.57}};

    private double ErrorSiete[][] = new double[][]{{-4.15,-1.035,-0.207,0,0.207},
                                                   {-4.14,-0.207,0,0.207,1.035},
                                                   {-1.035,-0.207,0,0.207,4.14},
                                                   {-0.207,0,0.207,1.035,4.15}};
    
    private double DerivadaSiete[][] = new double[][]{{-8.29,-0.021528,-0.000828,0,0.000828},
                                                      {-8.28,-0.000828,0,0.000828,0.021528},
                                                      {-0.021528,-0.000828,0,0.000828,8.28},
                                                      {-0.000828,0,0.000828,0.021528,8.29}};
    
    private double[][][] MatrizDeCentros = { { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
                                 
                                             { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
                                             
                                             { {-0.5875,-1.175,-1.175,1.175,0.5875},
                                               {-1.175,-1.765,-0.5875,1.765,1.175},
                                               {-2.35,-1.175,0,1.175,2.35},
                                               {-1.175,-1.765,0.5875,1.765,1.175},
                                               {-0.5875,-1.175,1.175,1.175,0.5875}},
    
                                             { {-0.5875,-1.175,-1.175,1.175,0.5875},
                                               {-1.175,-1.765,-0.5875,1.765,1.175},
                                               {-2.35,-1.175,0,1.175,2.35},
                                               {-1.175,-1.765,0.5875,1.765,1.175},
                                               {-0.5875,-1.175,1.175,1.175,0.5875}},
    
                                             { {-0.4875,-0.975,-0.975,0.975,0.4875},
                                               {-0.975,-1.4625,-0.4875,1.4625,0.975},
                                               {-1.95,-0.975,0,0.975,1.95},
                                               {-0.975,-1.4625,0.4875,1.4625,0.975},
                                               {-0.4875,-0.975,0.975,0.975,0.4875}},
    
                                             { {-0.44,-0.88,-0.88,0.88,0.44},
                                               {-0.88,-1.32,-0.44,1.32,0.88},
                                               {-1.76,-0.88,0,0.88,1.76},
                                               {-0.88,-1.32,0.44,1.32,0.88},
                                               {-0.44,-0.88,0.88,0.88,0.44}},
    
                                             { {-0.44,-0.88,-0.88,0.88,0.44},
                                               {-0.88,-1.32,-0.44, 1.32,0.88},
                                               {-1.76,-0.88,0,0.88, 1.76},
                                               {-0.88,-1.32,0.44,1.32,0.88},
                                               {-0.44,-0.88,0.88,0.88,0.44}}};
    
    private double GradosPX1[] = new double[5];
    private double GradosPX2[] = new double[5];
    private double GradosPX3[] = new double[5];
    private double GradosPX4[] = new double[5];
    private double GradosPX5[] = new double[5];
    private double GradosPX6[] = new double[5];
    private double GradosPX7[] = new double[5];
    private double GradosPX8[] = new double[5];
    private double GradosPX9[] = new double[5];
    private double GradosPX10[] = new double[5];
    private double GradosPX11[] = new double[5];
    private double GradosPX12[] = new double[5];
    private double GradosPX13[] = new double[5];
    private double GradosPX14[] = new double[5];
    
    private double SumaMatrizAuxiliar[] = new double[7];
    private double SumaValoresInferencia[] = new double[7];
    
    private double Salida[] = new double[7];
    
    private double ValoresInferencia[][][] = new double[7][5][5];
    
    private double MatrizAuxiliar[][][] = new double[7][5][5];

    public AgenteDifuso() 
    {
        vA = new double[7];
    }
    
    public double[] DecisionMaking(double[] dA,double[] sA, double[] sAnt)
    {
    
        for(int i=0;i<valorXderivada.length;i++) {
          errorPasado[i] = dA[i] - sAnt[i];
          errorPresente[i] = dA[i] - sA[i];
          valorXderivada[i] = errorPresente[i] - errorPasado[i];
        }
        
        for(int c = 0;c < ErrorUno.length;c++) {
            for(int d = 0;d < ErrorUno[c].length;d++) {
                if(errorPresente[0] > ErrorUno[3][d]) {
                    GradosPX1[d] = 0; 
                } else if(errorPresente[0] > ErrorUno[2][d]) {
                    GradosPX1[d] = (ErrorUno[3][d] - errorPresente[0])/(ErrorUno[3][d] - ErrorUno[2][d]); 
                } else if(errorPresente[0] > ErrorUno[1][d]) {
                    GradosPX1[d] = 1; 
                } else if(errorPresente[0] > ErrorUno[0][d]) {
                    GradosPX1[d] = (errorPresente[0] - ErrorUno[0][d])/(ErrorUno[1][d] - ErrorUno[0][d]) ; 
                } else {
                    GradosPX1[d] = 0;
                }
                
                if(valorXderivada[0] > DerivadaUno[3][d]) {
                    GradosPX2[d] = 0; 
                } else if(valorXderivada[0] > DerivadaUno[2][d]) {
                    GradosPX2[d] = (DerivadaUno[3][d] - valorXderivada[0])/(DerivadaUno[3][d] - DerivadaUno[2][d]); 
                } else if(valorXderivada[0] > DerivadaUno[1][d]) {
                    GradosPX2[d] = 1; 
                } else if(valorXderivada[0] > DerivadaUno[0][d]) {
                    GradosPX2[d] = (valorXderivada[0] - DerivadaUno[0][d])/(DerivadaUno[1][d] - DerivadaUno[0][d]) ; 
                } else {
                    GradosPX2[d] = 0;
                }
                
                if(errorPresente[1] > ErrorDos[3][d]) {
                    GradosPX3[d] = 0; 
                } else if(errorPresente[1] > ErrorDos[2][d]) {
                    GradosPX3[d] = (ErrorDos[3][d] - errorPresente[1])/(ErrorDos[3][d] - ErrorDos[2][d]); 
                } else if(errorPresente[1] > ErrorDos[1][d]) {
                    GradosPX3[d] = 1; 
                } else if(errorPresente[1] > ErrorDos[0][d]) {
                    GradosPX3[d] = (errorPresente[1] - ErrorDos[0][d])/(ErrorDos[1][d] - ErrorDos[0][d]) ; 
                } else {
                    GradosPX3[d] = 0;
                }
                
                if(valorXderivada[1] > DerivadaDos[3][d]) {
                    GradosPX4[d] = 0; 
                } else if(valorXderivada[1] > DerivadaDos[2][d]) {
                    GradosPX4[d] = (DerivadaDos[3][d] - valorXderivada[1])/(DerivadaDos[3][d] - DerivadaDos[2][d]); 
                } else if(valorXderivada[1] > DerivadaDos[1][d]) {
                    GradosPX4[d] = 1; 
                } else if(valorXderivada[1] > DerivadaDos[0][d]) {
                    GradosPX4[d] = (valorXderivada[1] - DerivadaDos[0][d])/(DerivadaDos[1][d] - DerivadaDos[0][d]) ; 
                } else {
                    GradosPX4[d] = 0;
                }
                
                if(errorPresente[2] > ErrorTres[3][d]) {
                    GradosPX5[d] = 0; 
                } else if(errorPresente[2] > ErrorTres[2][d]) {
                    GradosPX5[d] = (ErrorTres[3][d] - errorPresente[2])/(ErrorTres[3][d] - ErrorTres[2][d]); 
                } else if(errorPresente[2] > ErrorTres[1][d]) {
                    GradosPX5[d] = 1; 
                } else if(errorPresente[2] > ErrorTres[0][d]) {
                    GradosPX5[d] = (errorPresente[2] - ErrorTres[0][d])/(ErrorTres[1][d] - ErrorTres[0][d]) ; 
                } else {
                    GradosPX5[d] = 0;
                }
                
                if(valorXderivada[2] > DerivadaTres[3][d]) {
                    GradosPX6[d] = 0; 
                } else if(valorXderivada[2] > DerivadaTres[2][d]) {
                    GradosPX6[d] = (DerivadaTres[3][d] - valorXderivada[2])/(DerivadaTres[3][d] - DerivadaTres[2][d]); 
                } else if(valorXderivada[2] > DerivadaTres[1][d]) {
                    GradosPX6[d] = 1; 
                } else if(valorXderivada[2] > DerivadaTres[0][d]) {
                    GradosPX6[d] = (valorXderivada[2] - DerivadaTres[0][d])/(DerivadaTres[1][d] - DerivadaTres[0][d]) ; 
                } else {
                    GradosPX6[d] = 0;
                }
                
                if(errorPresente[3] > ErrorCuatro[3][d]) {
                    GradosPX7[d] = 0; 
                } else if(errorPresente[3] > ErrorCuatro[2][d]) {
                    GradosPX7[d] = (ErrorCuatro[3][d] - errorPresente[3])/(ErrorCuatro[3][d] - ErrorCuatro[2][d]); 
                } else if(errorPresente[3] > ErrorCuatro[1][d]) {
                    GradosPX7[d] = 1; 
                } else if(errorPresente[3] > ErrorCuatro[0][d]) {
                    GradosPX7[d] = (errorPresente[3] - ErrorCuatro[0][d])/(ErrorCuatro[1][d] - ErrorCuatro[0][d]) ; 
                } else {
                    GradosPX7[d] = 0;
                }
                
                if(valorXderivada[3] > DerivadaCuatro[3][d]) {
                    GradosPX8[d] = 0; 
                } else if(valorXderivada[3] > DerivadaCuatro[2][d]) {
                    GradosPX8[d] = (DerivadaCuatro[3][d] - valorXderivada[3])/(DerivadaCuatro[3][d] - DerivadaCuatro[2][d]); 
                } else if(valorXderivada[3] > DerivadaCuatro[1][d]) {
                    GradosPX8[d] = 1; 
                } else if(valorXderivada[3] > DerivadaCuatro[0][d]) {
                    GradosPX8[d] = (valorXderivada[3] - DerivadaCuatro[0][d])/(DerivadaCuatro[1][d] - DerivadaCuatro[0][d]) ; 
                } else {
                    GradosPX8[d] = 0;
                }
                
                if(errorPresente[4] > ErrorCinco[3][d]) {
                    GradosPX9[d] = 0; 
                } else if(errorPresente[4] > ErrorCinco[2][d]) {
                    GradosPX9[d] = (ErrorCinco[3][d] - errorPresente[4])/(ErrorCinco[3][d] - ErrorCinco[2][d]); 
                } else if(errorPresente[4] > ErrorCinco[1][d]) {
                    GradosPX9[d] = 1; 
                } else if(errorPresente[4] > ErrorCinco[0][d]) {
                    GradosPX9[d] = (errorPresente[4] - ErrorCinco[0][d])/(ErrorCinco[1][d] - ErrorCinco[0][d]) ; 
                } else {
                    GradosPX9[d] = 0;
                }
                
                if(valorXderivada[4] > DerivadaCinco[3][d]) {
                    GradosPX10[d] = 0; 
                } else if(valorXderivada[4] > DerivadaCinco[2][d]) {
                    GradosPX10[d] = (DerivadaCinco[3][d] - valorXderivada[4])/(DerivadaCinco[3][d] - DerivadaCinco[2][d]); 
                } else if(valorXderivada[4] > DerivadaCinco[1][d]) {
                    GradosPX10[d] = 1; 
                } else if(valorXderivada[4] > DerivadaDos[0][d]) {
                    GradosPX10[d] = (valorXderivada[4] - DerivadaCinco[0][d])/(DerivadaCinco[1][d] - DerivadaCinco[0][d]) ; 
                } else {
                    GradosPX10[d] = 0;
                }
                
                if(errorPresente[5] > ErrorSeis[3][d]) {
                    GradosPX11[d] = 0; 
                } else if(errorPresente[5] > ErrorSeis[2][d]) {
                    GradosPX11[d] = (ErrorSeis[3][d] - errorPresente[5])/(ErrorSeis[3][d] - ErrorSeis[2][d]); 
                } else if(errorPresente[5] > ErrorSeis[1][d]) {
                    GradosPX11[d] = 1; 
                } else if(errorPresente[5] > ErrorSeis[0][d]) {
                    GradosPX11[d] = (errorPresente[5] - ErrorSeis[0][d])/(ErrorSeis[1][d] - ErrorSeis[0][d]) ; 
                } else {
                    GradosPX11[d] = 0;
                }
                
                if(valorXderivada[5] > DerivadaSeis[3][d]) {
                    GradosPX12[d] = 0; 
                } else if(valorXderivada[5] > DerivadaSeis[2][d]) {
                    GradosPX12[d] = (DerivadaSeis[3][d] - valorXderivada[5])/(DerivadaSeis[3][d] - DerivadaSeis[2][d]); 
                } else if(valorXderivada[5] > DerivadaSeis[1][d]) {
                    GradosPX12[d] = 1; 
                } else if(valorXderivada[5] > DerivadaSeis[0][d]) {
                    GradosPX12[d] = (valorXderivada[5] - DerivadaSeis[0][d])/(DerivadaSeis[1][d] - DerivadaSeis[0][d]) ; 
                } else {
                    GradosPX12[d] = 0;
                }
                
                if(errorPresente[6] > ErrorSiete[3][d]) {
                    GradosPX13[d] = 0; 
                } else if(errorPresente[6] > ErrorSiete[2][d]) {
                    GradosPX13[d] = (ErrorSiete[3][d] - errorPresente[6])/(ErrorSiete[3][d] - ErrorSiete[2][d]); 
                } else if(errorPresente[6] > ErrorSiete[1][d]) {
                    GradosPX13[d] = 1; 
                } else if(errorPresente[6] > ErrorSiete[0][d]) {
                    GradosPX13[d] = (errorPresente[6] - ErrorSiete[0][d])/(ErrorSiete[1][d] - ErrorSiete[0][d]) ; 
                } else {
                    GradosPX13[d] = 0;
                }
                
                if(valorXderivada[6] > DerivadaSiete[3][d]) {
                    GradosPX14[d] = 0; 
                } else if(valorXderivada[6] > DerivadaSiete[2][d]) {
                    GradosPX14[d] = (DerivadaSiete[3][d] - valorXderivada[6])/(DerivadaSiete[3][d] - DerivadaSiete[2][d]); 
                } else if(valorXderivada[6] > DerivadaSiete[1][d]) {
                    GradosPX14[d] = 1; 
                } else if(valorXderivada[6] > DerivadaSiete[0][d]) {
                    GradosPX14[d] = (valorXderivada[6] - DerivadaSiete[0][d])/(DerivadaSiete[1][d] - DerivadaSiete[0][d]) ; 
                } else {
                    GradosPX14[d] = 0;
                }
            }
        }
        
        for(int b = 0;b < ValoresInferencia[0].length;b++) {
            for(int c = 0;c < ValoresInferencia[0][b].length;c++) {
                ValoresInferencia[0][b][c] = Math.min(GradosPX1[c], GradosPX2[b]);
                ValoresInferencia[1][b][c] = Math.min(GradosPX3[c], GradosPX4[b]);
                ValoresInferencia[2][b][c] = Math.min(GradosPX5[c], GradosPX6[b]);
                ValoresInferencia[3][b][c] = Math.min(GradosPX7[c], GradosPX8[b]);
                ValoresInferencia[4][b][c] = Math.min(GradosPX9[c], GradosPX10[b]);
                ValoresInferencia[5][b][c] = Math.min(GradosPX11[c], GradosPX12[b]);
                ValoresInferencia[6][b][c] = Math.min(GradosPX13[c], GradosPX14[b]);
            }
        }
        
        for(int g = 0;g < ValoresInferencia.length;g++) {
            for(int h = 0;h < ValoresInferencia[g].length;h++) {
                 for(int i = 0;i < ValoresInferencia[g][h].length;i++) {
                    MatrizAuxiliar[g][h][i] = ValoresInferencia[g][h][i] * MatrizDeCentros[g][h][i];
                    SumaValoresInferencia[g] += ValoresInferencia[g][h][i];
                    SumaMatrizAuxiliar[g] += MatrizAuxiliar[g][h][i];
                 }
            }
        }
        
        for(int i = 0;i < Salida.length;i++) {
            Salida[i] = SumaMatrizAuxiliar[i]/SumaValoresInferencia[i];
            vA[i] = Salida[i];
        }   
 
        return vA;
  }
}