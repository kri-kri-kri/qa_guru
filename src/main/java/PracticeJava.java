public class PracticeJava {
    public static void main(String[] args) {

        //поупражняться с математическими и логическими операторами
        byte aByte = 20;
        byte bByte = 5;
        System.out.println(aByte + bByte);
        System.out.println(aByte - bByte);
        System.out.println(aByte / bByte);
        System.out.println(aByte * bByte);
        System.out.println(aByte % bByte);

        if (aByte == bByte) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        //добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
        byte cByte = 127;
        System.out.println(cByte + 1);

        //попробовать вычисления комбинаций типов данных (int и double)
        int aInt = 5;
        double aDouble = 1.2;
        System.out.println(aInt + aDouble);
        System.out.println(aInt - aDouble);
        System.out.println(aInt / aDouble);
        System.out.println(aInt * aDouble);
        System.out.println(aInt % aDouble);
    }
}
