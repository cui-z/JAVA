package Day10;

public class Computer {
    public void run(){
        System.out.println("笔记本 打开");
    }
    public void ShutDown(){
        System.out.println("笔记本 关机 ");
    }

    public void UseUSB(USB usb){
        usb.open();
        if(usb instanceof Mouse){
            ((Mouse) usb).click();
        } else if (usb instanceof KeyBoard){
            ((KeyBoard) usb).type();
        }

    }
}
