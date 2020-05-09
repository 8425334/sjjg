package lq;

import java.util.Arrays;
import java.util.Scanner;

public class Lanqiao1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int kid=scanner.nextInt();
        int picture=scanner.nextInt();
        int[][] array=new int[kid][picture];
        for(int i=0;i<kid;i++) {
            for(int j=0;j<picture;j++) {
                array[i][j]=scanner.nextInt();
            }
        }
        taste(array,kid,picture);
    }
    public static void taste(int[][] array,int kid,int picture) {
        int count=0;
        for(int i=0;i<kid;i++) {
            int temp=1;
            while(temp+i<kid) {
                boolean juge=true;
                for(int j=0;j<picture;j++) {
                    if(array[i][j]+array[i+temp][j]==1) {
                        continue;
                    }else {
                        juge=false;
                        break;
                    }
                }
                if(juge) {
                    count++;
                }
                temp++;
            }

        }
        System.out.println(count);
    }

}
