package use_case.generate_meal;

import app.custom_data.Range;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenerateMealUseCaseInteractor implements GenerateMealInputBoundary{
    private String convertArrtoStringURL(String urlName, List<String> arr){
        String result = "";
        for (String s : arr){
            result += urlName + s;
        }
        return result;
    }
    public void execute(GenerateMealInputData inputData) {
        String ID = "8da598eb";
        String KEY = " 9fec3b1b7ba00da5dac76ba4af6bd26e\t";
        String URL = "https://api.edamam.com/api/recipes/v2?type=public&app_id=" + ID + "&app_key=" + KEY;
        String imageSizeURL = "&imageSize=REGULAR";
        List<String> fields = Arrays.asList("label", "image", "source", "url", "ingredientLines",
                "calories", "totalTime", "totalNutrients");


        String healthPreferencesURL = convertArrtoStringURL("&health=", inputData.getHealthPreferences());
        String mealTypeURL = convertArrtoStringURL("&mealType=", inputData.getMealType());
        String dishTypeURL = convertArrtoStringURL("&dishType=", inputData.getDishType());
        String calRangeURL = "&calories=" + inputData.getCalRange();
        String carbRangeURL = "&nutrients%5CHOCDF=" + inputData.getCarbRange(); //Carbs
        String proteinRangeURL = "&nutrients%5PROCNT=" + inputData.getProteinRange(); //Protein
        String fatRangeURL = "&nutrients%5FAT=" + inputData.getFatRange(); //Fat
        String field = convertArrtoStringURL("&field=", fields);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(String.format("%s%s%s%s%s%s%s%s%s%s", URL, imageSizeURL, healthPreferencesURL, mealTypeURL,
                        dishTypeURL, calRangeURL, carbRangeURL, proteinRangeURL, fatRangeURL, field))
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Language", "en")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);


            if (response.code() == 200) {
                Gson responseBody = new Gson();
                ResponseBody body = response.body();
                String content = body.string();
                GenerateMealOutputData outputData = responseBody.fromJson(content, GenerateMealOutputData.class);
                System.out.println(outputData.getHits()[0].getRecipe().getTotalNutrients().getProtein().getQuantity());

            } else {
                System.out.println("error");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
        List<String> a1 = new ArrayList<>();
        a1.add("vegan");
        a1.add("vegetarian");

        List<String> a2 = new ArrayList<>();
        a2.add("lunch");

        List<String> a3 = new ArrayList<>();
        a3.add("Main Course");

        GenerateMealUseCaseInteractor test = new GenerateMealUseCaseInteractor();
        test.execute(new GenerateMealInputData(a1, a2, a3, new Range(100, 101), new Range(0, 100), new Range(0, 30), new Range(0,20)));

    }

}
