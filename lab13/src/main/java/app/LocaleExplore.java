package app;

import com.DisplayLocals;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {

    public static void main(String[] args) {
       // DisplayLocals.display();
        //Info.getInfo(Locale.getDefault());
        String exit="succes";
        Scanner scanner=new Scanner(System.in);

        //ar-EG
        //zh-SG
        //fr-FR
        while(true) {
            System.out.println("Enter a country tag: ");
            exit=scanner.nextLine();
            if(exit.equals("exit"))
                break;
            SetLocale.setLocale(exit);
            Info.getInfo(Locale.getDefault());
        }
    }
}
