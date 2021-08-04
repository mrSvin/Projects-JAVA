import java.io.FileOutputStream;
//new commit
public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

//        FileOutputStream writer = new FileOutputStream("res/numbers.txt");
//
//        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
//        //int regionCode = 199;
//
//        for (int number = 1; number < 1000; number++) {
//            StringBuilder builder = new StringBuilder();
//
//            for (int regionCode = 1; regionCode < 100; regionCode++) {
//                for (char firstLetter : letters) {
//                    for (char secondLetter : letters) {
//                        for (char thirdLetter : letters) {
////                        String carNumber = firstLetter + padNumber(number, 3) +
////                            secondLetter + thirdLetter + padNumber(regionCode, 2) + "\n";
//
//                            builder.append(firstLetter);
//                            builder.append(padNumber(number, 3));
//                            builder.append(secondLetter);
//                            builder.append(thirdLetter);
//                            builder.append(padNumber(regionCode, 2));
//                            builder.append("\n");
//
//                            //writer.write(builder.toString().getBytes());
//                            //writer.write('\n');
//                        }
//                    }
//                }
//            }
//            writer.write(builder.toString().getBytes());
//        }


//        writer.flush();
//        writer.close();

        ThreadsWriteCarNumber(1,250, start);
        ThreadsWriteCarNumber(251,500, start);
        ThreadsWriteCarNumber(501,750, start);
        ThreadsWriteCarNumber(751,1000, start);

//        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);

        if (numberLength == 2 && numberStr.length() == 1) {
            numberStr = '0' + numberStr;
        }

        if (numberLength == 3 && numberStr.length() == 1) {
            numberStr = '0' + numberStr;
        }

//        int padSize = numberLength - numberStr.length();
//        for (int i = 0; i < padSize; i++) {
//            numberStr = '0' + numberStr;
//
//        }
        return numberStr;
    }

    private static void ThreadsWriteCarNumber(int startNumber, int endNumber, long start) {
        new Thread(() -> {
            try {

                FileOutputStream writer = new FileOutputStream("res/numbers" + startNumber + "-" + endNumber + ".txt");

                char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
                //int regionCode = 199;

                for (int number = startNumber; number < endNumber; number++) {
                    StringBuilder builder = new StringBuilder();

                    for (int regionCode = 1; regionCode < 100; regionCode++) {
                        for (char firstLetter : letters) {
                            for (char secondLetter : letters) {
                                for (char thirdLetter : letters) {
//                        String carNumber = firstLetter + padNumber(number, 3) +
//                            secondLetter + thirdLetter + padNumber(regionCode, 2) + "\n";

                                    builder.append(firstLetter);
                                    builder.append(padNumber(number, 3));
                                    builder.append(secondLetter);
                                    builder.append(thirdLetter);
                                    builder.append(padNumber(regionCode, 2));
                                    builder.append("\n");

                                    //writer.write(builder.toString().getBytes());
                                    //writer.write('\n');
                                }
                            }
                        }
                    }
                    writer.write(builder.toString().getBytes());
                }


                writer.flush();
                writer.close();


            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println((System.currentTimeMillis() - start) + " ms");
        }).start();

    }


}
