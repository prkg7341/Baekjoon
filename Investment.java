package DynamicProgramming;
import java.util.Scanner;

public class Investment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m,n;
		n = sc.nextInt();//�ݾ�	
		m = sc.nextInt();//����� ����			
		int[][] input = new int [n][m+1];
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<m+1 ; j++){
				input[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		//�ܰ�(����Ǽ�), ����(�����׼�, )
		
		int[][] output = new int [m+1][n+1];
		
		for(int i=0 ; i<m+1 ; i++){
			output[i][0] = 0;
		}//�ݾ��� 0�ΰ��
		
		for(int i=0 ; i<n+1 ; i++){
			output[0][i] = 0;
		}//����ϴ� ����ǰ����� 0�ΰ��
		
		for(int i=1 ; i<n+1 ; i++){
			output[1][i] = input[i-1][1];
		}//��� 1���� ���(������)
		for(int i=0 ; i<m+1 ; i++){
			System.out.println();
			for(int j=0 ; j<n+1 ; j++){
				System.out.print(output[i][j]+" ");
			}
		}
		System.out.println();
		for(int i=2 ; i<m+1 ; i++){
			for(int j=1 ; j<n+1 ; j++){
				int max = output[i-1][j];//���ٰ�
				if(input[j-1][i]>max){
					max = input[j-1][i];
				}
				/*if(output[i][j-1]+@>max){
					max = output[i][j-1]+@;//���⸦ ��� ���� �𸣰ڴ�
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
		//System.out.println("������ �׼�");
	}

}
