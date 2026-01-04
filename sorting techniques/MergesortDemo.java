 class MergesortDemo {
    static int a[];
    static int b[];
    static void merge(int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=low;
        while(i<=mid &&j<=high){
            if(a[i]<=a[j]){
                b[k++]=a[i++];
            }
            else{
                b[k++]=a[j++];
            }
        }
       while(i<=mid){
        b[k++]=a[i++];
       }
       while(j<=high){
        b[k++]=a[j++];
       }
       for(i=low;i<=high;i++)
{
    a[i]=b[i];
}    }
    static void mergesort(int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergesort(low,mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
    }
    public static void main(String args[])
{
    a=new int[]{45,90,78,56,43,12,23,67};
    int n=a.length;
    b=new int[n];
  
    System.out.println("array before sorting  is:");
    for(int x:a){
        System.out.print(x+" ");

    }
    mergesort(0,n-1);
    System.out.println("array after sorting  is:");
    for(int x:a){
        System.out.print(x+" ");

    }
}    
}
