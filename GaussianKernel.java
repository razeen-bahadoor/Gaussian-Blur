public class GaussianKernel {
    private double sum=0.0;
    private float[][] auxKernel;
    private float[] kernel;

    public GaussianKernel(int size){
        auxKernel = new float[size][size];
        kernel= new float[size*size];
    }

    public  void genKernel(double sigma){
        int xIndex=0;
        int yIndex=0;
                for(int i = -(auxKernel[0].length-1) /2; i<=(auxKernel[0].length-1) / 2; i++){
                    xIndex=0;
                    for(int j = -(auxKernel[0].length-1) /2; j<=(auxKernel[0].length-1) / 2; j++){
                        auxKernel[yIndex][xIndex]= genValue(j,i,sigma);
                        sum = sum + auxKernel[yIndex][xIndex];

                        xIndex++;
                    }
                    yIndex++;
                }


        for(int row = 0; row< auxKernel.length; row++){//normalise the auxKernel so all values add to one
            for(int col = 0; col< auxKernel.length; col++){
                auxKernel[row][col] = (float) (auxKernel[row][col] * (1/sum));
            }
        }


        int index=0;
        for(int r = 0; r< auxKernel[0].length; r++){
            for(int c = 0; c< auxKernel[0].length; c++){
                kernel[index]=auxKernel[r][c];
                index++;
            }

        }


    }

    public void print(){
        for(int r = 0; r< auxKernel[0].length; r++){
            for(int c = 0; c< auxKernel[0].length; c++){
                System.out.print(auxKernel[r][c]);
            }
            System.out.println();
        }
    }


    private float genValue(int x , int y , double sigma){
        float temp1 = (float) (1/ (2 * Math.PI * sigma * sigma));
        float temp2 = (float) (-1 * ((x * x) + ( y * y)) / (2 * sigma * sigma));
        return (float) (temp1 * Math.exp( temp2));
    }


    public float[] getKernel(){
        return this.kernel;
    }

}
