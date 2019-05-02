
package javaapplication32;
import java.util.*;

public class JavaApplication32 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //---------------------//
        
        int row=0,col=0;
        
        //---------------------//
        System.out.println("請輸入欲解之聯立方程式為幾元");
        row = scanner.nextInt();
        col = row+1;
        double ans[] = new double[row];
        double arr[][] = new double[row][col];
        double backup[][] = new double[row][col];
        int i=0,j=0;
        double chen=0;
        System.out.println("請輸入矩陣");
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                arr[i][j] = scanner.nextDouble();
                backup[i][j] = arr[i][j];
            }
        }
        
        i=0;
        j=0;
        int num = 0;
        while(num<row-1){
            for(int m=i;m<row-1;m++){
                chen = arr[m+1][j]/arr[i][j];
                for(int n=j;n<col;n++){
                    arr[m+1][n] = arr[i][n]*chen - arr[m+1][n];
                }
            }
            i++;
            j++;
            num++;
        }
        System.out.println("行梯陣式為(只顯示後四位):");
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                System.out.printf("%.4f"+" ",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        //上半用來化為行梯陣式
        int count=0;
        double dec=0;
        int c=0;
        int b=1;
        j = col-2;
        for(i=row;i>0;i--){
            count = row-i;
            
            for(;count>0;count--){
                
                dec = dec + arr[i-1][col-2-c]*ans[row-b];
                c++;
                b++;
            }
            arr[i-1][col-1] = arr[i-1][col-1]-dec;
            ans[i-1] = arr[i-1][col-1]/arr[i-1][j];
            j--;
            c=0;
            b=1;
            dec=0;
        }
        System.out.println("得"+row+"組解(只顯示後四位):");
        for(i=0;i<row;i++){
            System.out.printf("%.4f"+" ",ans[i]);
        }
        System.out.println();
        
        //-----------------------------誤差計算--------------------------------
        double totalx = 0;
        double totalans = 0;
        
        for(i=0;i<row;i++){
            for(j=0;j<col-1;j++){
                totalx = totalx + backup[i][j]*ans[j];
            }
        }
        for(i=0;i<row;i++){
            totalans = totalans + backup[i][col-1];
        }
        System.out.println("誤差值:"+Math.abs(totalx-totalans));
        
        
    }
    
}
