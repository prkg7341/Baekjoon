package DynamicProgramming;
import java.util.Scanner;

public class Investment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m,n;
		n = sc.nextInt();//금액	
		m = sc.nextInt();//기업의 개수			
		int[][] input = new int [n][m+1];
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<m+1 ; j++){
				input[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		//단계(기업의수), 상태(남은액수, )
		
		int[][] output = new int [m+1][n+1];
		
		for(int i=0 ; i<m+1 ; i++){
			output[i][0] = 0;
		}//금액이 0인경우
		
		for(int i=0 ; i<n+1 ; i++){
			output[0][i] = 0;
		}//고려하는 기업의개수가 0인경우
		
		for(int i=1 ; i<n+1 ; i++){
			output[1][i] = input[i-1][1];
		}//기업 1개만 고려(고정값)
		for(int i=0 ; i<m+1 ; i++){
			System.out.println();
			for(int j=0 ; j<n+1 ; j++){
				System.out.print(output[i][j]+" ");
			}
		}
		System.out.println();
		for(int i=2 ; i<m+1 ; i++){
			for(int j=1 ; j<n+1 ; j++){
				int max = output[i-1][j];//윗줄거
				if(input[j-1][i]>max){
					max = input[j-1][i];
				}
				/*if(output[i][j-1]+@>max){
					max = output[i][j-1]+@;//여기를 어떻헤 할지 모르겠다
				}*/
				output[i][j] = max;
			}
		}
		for(int i=0 ; i<m+1 ; i++){
			System.out.println();
			for(int j=0 ; j<n+1 ; j++){
				System.out.print(output[i][j]+" ");
			}
		}
		//System.out.println(output[m][n]);
		//System.out.println("투자한 액수");
	}

}
