package use_case.generate_meal;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GenerateMealUseCaseInteractor implements GenerateMealInputBoundary{

    final GenerateMealOutputBoundary generateMealPresenter;
    final GenerateMealDataAccessInterface generateMealDataAcessObject;
    public GenerateMealUseCaseInteractor (GenerateMealOutputBoundary generateMealsOutputBoundary,
                                          GenerateMealDataAccessInterface generateMealDataAcessInterface){
        this.generateMealPresenter = generateMealsOutputBoundary;
        this.generateMealDataAcessObject = generateMealDataAcessInterface;
    }

    public void execute(GenerateMealInputData inputData) {
        String ID = "8da598eb";
        String KEY = " 9fec3b1b7ba00da5dac76ba4af6bd26e\t";
        String URL = "https://api.edamam.com/api/recipes/v2?type=public&app_id=" + ID + "&app_key=" + KEY;
        String imageSizeURL = "&imageSize=REGULAR";

        //fields to specify the data we want to get from the API
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


            if (response.code() == 200) {
                Gson responseBody = new Gson();
                ResponseBody body = response.body();
                String content = body.string(); //Needed to be called only once, or else responseBody.fromJson will not work
                GenerateMealOutputData outputData = responseBody.fromJson(content, GenerateMealOutputData.class);

                generateMealPresenter.prepareSuccessView(outputData);

            } else {
                generateMealPresenter.prepareFailView("Error (Code " + response.code() + ").");
            }
            generateMealDataAcessObject.save();
        } catch (IOException e) {
            generateMealPresenter.prepareFailView(e.getMessage());
        }
    }


    private String convertArrtoStringURL(String urlName, List<String> arr){
        String result = "";
        for (String s : arr){
            result += urlName + s;
        }
        return result;
    }

}
