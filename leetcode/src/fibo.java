import org.junit.Test;

public class fibo {
    /**
     * 1����֪쳲���������: 0��1��1��2��3��5��8��13��21��34, ���Ƕ���: y = f(n). �� f(0) = 0, f(1) = 1,
     * f(n) = f(n - 1) + f(n - 2)��n [����] 2��n [����] N*�� �� f(20); Ҫ��: ��ʹ�����ַ�ʽʵ��, ����� ��
     * y С�� 100,000 ʱ, ������ n
     */

     public int fibo(int n){
        if(n<=1)return n;
        int a = 0,b=0;
        int c = 1;
        for(int i=2;i<=n;i++){
            a = b;
            b = c;
            c = a+b;
        }
        return c;
     }

     public int fibo2(int n){
         if(n<=1)return n;
         else return fibo(n-1)+fibo(n-2);
     }

     public int fibo3(){
        int a = 0,b=0;
        int c = 1;
        int n = 1;
        while(c<100000){
            a = b;
            b = c;
            c = a+b;
            n++;
        }
        return n-1;
     }

     @Test
     public void test(){
         System.out.println(fibo2(20));
         System.out.println(fibo3());
     }
}
