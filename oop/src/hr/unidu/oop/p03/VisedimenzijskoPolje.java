package hr.unidu.oop.p03;
public class VisedimenzijskoPolje
{
    public void prikazi()
    {
        int [][] arr = new int[2][3];
        arr[0][0]=2;
        arr[0][1]=3;
        arr[0][2]=7;
        arr[1][0]=1;
        arr[1][1]=9;
        arr[1][2]=4;
        for (int i = 0; i < arr.length; i++) 
            for (int j = 0; j < arr[i].length; j++) 
            System.out.println("Podatak na poziciji ("+i+","+j+") je: "+arr[i][j]);
        
    }
}
