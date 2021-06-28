import java.util.stream.IntStream;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] array_temperature = new float[]{
                33.1F, 33.1F, 32.5F, 33.5F, 34.5F, 36.5F, 38.5F, 39.5F, 33.3F, 32.7F,
                36.9F, 36.5F, 34.3F, 37.5F, 32.5F, 32.5F, 32.4F, 34.5F, 35.4F, 32.5F,
                34.5F, 39.4F, 32.5F, 36.5F, 36.4F, 39.6F, 37.5F, 32.5F, 37.5F, 39.4F
        };

        return array_temperature;
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

        String report =
                "Температуры пациентов: " + temperatures +
                        "\nСредняя температура: " + 0 +
                        "\nКоличество здоровых: " + 0;

        return report;
    }
}
