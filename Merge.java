package DivideAndConquer;
import java.util.Scanner;

public class Merge {

	public static void mergeSort(int[] ar, int low, int high){

		if(high>low){

			int mid =(low + high)/2;

			mergeSort(ar, low, mid);
			mergeSort(ar, mid+1, high);


			merge(ar, low, mid, high);			
		}
	}

	public static void merge(int[] ar, int low, int mid, int high){
		int[] temp = new int[high+1];
		int l,m,n;
		l = low;
		m = mid+1;
		n = low;

		while(l<=mid && m<=high){

			if(ar[l]<ar[m]){
				temp[n]=ar[l];
				l++;
			}
			else{
				temp[n]=ar[m];
				m++;
			}
			n++;
		}

		if(l>mid){
			while(m<=high){
				temp[n]=ar[m];
				m++; n++;
			}
		}
		else if(m>high){
			while(l<=mid){
				temp[n]=ar[l];
				l++; n++;
			}
		}
		for(int i=low ; i<high+1 ;i++){
			ar[i] = temp[i];
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0 ; i < ar.length ; i++){
			ar[i] = sc.nextInt();
		}
		sc.close();

		mergeSort(ar,0,n-1);
		
		for(int i=0 ; i < ar.length ; i++){
			System.out.println(ar[i]);
		}
	}
}
