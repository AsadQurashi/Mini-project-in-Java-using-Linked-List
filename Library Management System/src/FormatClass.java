import java.util.Scanner;

public class FormatClass {
    public static Scanner sc = new Scanner(System.in);
    public static int getIntegerFromUser()
    {
        boolean check=true;
        String numStr="";
        while (check)
        {
            numStr=sc.nextLine();
            for (int i=0;i<numStr.length();i++)
            {
                if ((Character.isDigit(numStr.charAt(i))))
                {
                    check=false;
                }else {
                    System.out.print("Enter only number: ");
                    check=true;
                    break;
                }
            }
        }
        return Integer.parseInt(numStr);
    }
    public static String getStringFromUser()
    {
        String str=sc.nextLine();
        StringBuilder tempStr=new StringBuilder();
        String[] temp=str.split(" ");
        for (int i=0;i< temp.length;i++){
            if (temp[i].equals(" ") || temp[i].isEmpty()){
                continue;
            }
            tempStr.append(temp[i]);
            tempStr.append(" ");
        }
        str=tempStr.toString();

        char[] charArray=str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i==0)
            {
                char character=charArray[i];
                charArray[i]=Character.toUpperCase(character);
            }
            if (charArray[i]==' ' && i<charArray.length-1){
                char character=charArray[i+1];
                charArray[i+1]=Character.toUpperCase(character);

            }
        }
        StringBuilder charToString=new StringBuilder();
        for (char ch : charArray) {
            charToString.append(ch);
        }
        return charToString.toString();
    }
}
