package Unknown;
import java.util.Scanner;

public class DividePaper {

	public DividePaper(int[][] paper, int x1, int y1, int x2, int y2, int[] count, int n){

		devide(paper, x1, y1, x2, y2, count);
		getAnswer(count);
	}	


	void devide(int[][] paper, int x1, int y1, int x2, int y2, int[] count) { //System.out.println("메쏘드 시작");
		//int q=1; System.out.println(q + "번째 시도"); q++;
		if(x1==x2){

			//System.out.println("하나짜리 세는중");

			if(paper[x1][y1]==-1){
				//System.out.println("-1 하나짜리");
				count[0]++;
			}
			else if(paper[x1][y1]==0){
				//System.out.println("0 하나짜리");
				count[1]++;
			}
			else if(paper[x1][y1]==1){
				//System.out.println("1 하나짜리");
				count[2]++;
			}
		}

		else{//System.out.println("여러개짜리 세는중");
			int check = (x2-x1)*(x2-x1);
			for(int i=x1 ; i<x2 ; i++){
				for(int j=y1 ; j<y2 ; j++){				
					if(paper[i][j]==paper[i+1][j] && paper[i][j]==paper[i+1][j+1] && paper[i][j]==paper[i][j+1]){
						check--;//모두 같으면 감소시킨다.
					}
				}
			}
			//System.out.println("check is " +check);

			if(check==0){
				if(paper[x1][y1]==-1){
					//System.out.println("-1 여러개짜리");
					count[0]++;
				}
				else if(paper[x1][y1]==0){
					//System.out.println("0 여러개짜리");
					count[1]++;
				}
				else if(paper[x1][y1]==1){
					//System.out.println("1 여러개짜리");
					count[2]++;
				}
			}

			else{//int i=0; System.out.println("나눠"+ ++i);
				devide(paper, x1, 					y1, 					(2*(x1+1)+(x2+1))/3-1, 	(2*(y1+1)+(y2+1))/3-1, 	count);
				devide(paper, x1, 					(2*(y1+1)+(y2+1))/3, 	(2*(x1+1)+(x2+1))/3-1, 	((y1+1)+2*(y2+1))/3-1, 	count);
				devide(paper, x1, 					((y1+1)+2*(y2+1))/3,	(2*(x1+1)+(x2+1))/3-1, 	y2, 					count);
				devide(paper, (2*(x1+1)+(x2+1))/3, 	y1, 					((x1+1)+2*(x2+1))/3-1, 	(2*(y1+1)+(y2+1))/3-1, 	count);
				devide(paper, (2*(x1+1)+(x2+1))/3, 	(2*(y1+1)+(y2+1))/3, 	((x1+1)+2*(x2+1))/3-1, 	((y1+1)+2*(y2+1))/3-1, 	count);
				devide(paper, (2*(x1+1)+(x2+1))/3, 	((y1+1)+2*(y2+1))/3,	((x1+1)+2*(x2+1))/3-1, 	y2, 					count);
				devide(paper, ((x1+1)+2*(x2+1))/3, 	y1, 					x2, 					(2*(y1+1)+(y2+1))/3-1, 	count);
				devide(paper, ((x1+1)+2*(x2+1))/3, 	(2*(y1+1)+(y2+1))/3, 	x2, 					((y1+1)+2*(y2+1))/3-1, 	count);
				devide(paper, ((x1+1)+2*(x2+1))/3, 	((y1+1)+2*(y2+1))/3, 	x2, 					y2, 					count);
			}
		}
	}

	void getAnswer(int[] count){
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		int[][] paper = new int[n][n];
		int x1 = 0;
		int x2 = n-1;
		int y1 = 0;
		int y2 = n-1;
		int[] count = new int[3];
		count[0] = 0;	count[1] = 0;	count[2] = 0;

		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				paper[i][j] = sc.nextInt();
			}
		}//입력 완료

		new DividePaper(paper, x1, y1, x2, y2, count, n);

		sc.close();
	}
}
