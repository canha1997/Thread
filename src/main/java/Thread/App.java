package Thread;

/**
 * Hello world!
 *
 */
// synchronized la doi thang thu 1 lam xong thi thang thu 2  moi duoc lam
public class App 
{
    int bal=10;
    public synchronized void checkBallence()   ////neu ko co static thi Ham trong class phai duoc goi qua Object
                                  ///// object phai di kem voi final
    {
        for(int i=0; i<10;i++)
        {
            if(bal<=0)
            {
                System.out.println("Het tien roi");
                break;
            }
            else {
                bal--;
                System.out.println("rut tien lan" + i);

            }
        }
    }
    public static void main( String[] args )
    {
        final App app=new App();
        ///Tao tien trinh 1
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                app.checkBallence();

            }
        });

        //// Tao tien trinh 2
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                app.checkBallence();
            }
        });
        thread1.start();
        thread2.start();
    }
}
