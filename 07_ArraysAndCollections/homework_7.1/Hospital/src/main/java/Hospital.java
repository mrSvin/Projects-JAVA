import java.util.stream.IntStream;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] array = new float[patientsCount];

        for (int i = 0; i < patientsCount; i++) {
            array[i] = (float) (32 + Math.random() * 4);
            //System.out.println(array[i]);
        }


        return array;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float[] finalTemperatureData = temperatureData;
        String temperatures = String.join(" ",
                IntStream.range(0, temperatureData.length)
                        .mapToObj(i -> String.valueOf(finalTemperatureData[i])).toArray(String[]::new));

        double average = 0;
        int count = 0;
        if (temperatureData.length > 0) {
            float sum = 0;
            for (int j = 0; j < temperatureData.length; j++) {
                sum += temperatureData[j];
                if (temperatureData[j] >= 36.2 && temperatureData[j] < 37) {
                    count++;
                }
            }
            average = sum / temperatureData.length;
        }

        String report =
                "Температуры пациентов: " + temperatures +
                        "\nСредняя температура: " + String.format("%.2f", average) +
                        "\nКоличество здоровых: " + count;

        return report;
    }
}
